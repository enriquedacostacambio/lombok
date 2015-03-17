/*
 * Copyright (C) 2010-2015 The Project Lombok Authors.
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package lombok.javac.handlers;

import static lombok.core.handlers.HandlerUtil.handleFlagUsage;
import static lombok.javac.handlers.JavacHandlerUtil.*;
import lombok.core.DeclarationType;
import lombok.core.HandlerPriority;
import lombok.javac.JavacASTAdapter;
import lombok.javac.JavacASTVisitor;
import lombok.javac.JavacNode;
import lombok.javac.JavacResolution;
import lombok.javac.ResolutionResetNeeded;

import org.mangosdk.spi.ProviderFor;

import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.code.Symtab;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCAnnotation;
import com.sun.tools.javac.tree.JCTree.JCEnhancedForLoop;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCForLoop;
import com.sun.tools.javac.tree.JCTree.JCNewArray;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.util.List;

@ProviderFor(JavacASTVisitor.class)
@HandlerPriority(65536) // 2^16; resolution needs to work, so if the RHS expression is i.e. a call to a generated getter, we have to run after that getter has been generated.
@ResolutionResetNeeded
public class HandleDeclaration extends JavacASTAdapter {
	@Override
	public void visitLocal(JavacNode localNode, JCVariableDecl local) {
		for (DeclarationType declarationType : DeclarationType.types) {
			doVisitLocal(declarationType, localNode, local);
		}
	}
	
	private void doVisitLocal(DeclarationType declarationType, JavacNode localNode, JCVariableDecl local) {
		if (local.vartype == null || (!local.vartype.toString().equals(declarationType.annotation.getSimpleName()) && !local.vartype.toString().equals(declarationType.annotation.getName()))) return;
		
		JCTree source = local.vartype;
		
		if (!typeMatches(declarationType.annotation, localNode, local.vartype)) return;
		
		handleFlagUsage(localNode, declarationType.usageFlag, declarationType.annotation.getSimpleName());
		
		JCTree parentRaw = localNode.directUp().get();
		if (parentRaw instanceof JCForLoop) {
			JCForLoop fl = (JCForLoop) parentRaw;
			if (!fl.init.isEmpty() && fl.init.get(0) instanceof JCVariableDecl) {
				JCVariableDecl first = (JCVariableDecl) fl.init.get(0);
				if (first != local) {
					local.vartype = first.vartype;
					addAnnotation(localNode, local, source);
					return;
				}
			}
		}
		
		JCExpression rhsOfEnhancedForLoop = null;
		if (local.init == null) {
			if (parentRaw instanceof JCEnhancedForLoop) {
				JCEnhancedForLoop efl = (JCEnhancedForLoop) parentRaw;
				if (efl.var == local) rhsOfEnhancedForLoop = efl.expr;
			}
		}
		
		if (declarationType.isFinal && rhsOfEnhancedForLoop == null && local.init == null) {
			localNode.addError("'" + declarationType.annotation.getSimpleName() + "' on a local variable requires an initializer expression");
			return;
		}
		
		if (local.init instanceof JCNewArray && ((JCNewArray)local.init).elemtype == null) {
			localNode.addError("'" + declarationType.annotation.getSimpleName() + "' is not compatible with array initializer expressions. Use the full form (new int[] { ... } instead of just { ... })");
			return;
		}
		
		if (localNode.shouldDeleteLombokAnnotations()) JavacHandlerUtil.deleteImportFromCompilationUnit(localNode, declarationType.annotation.getName());
		
		if (declarationType.isFinal) local.mods.flags |= Flags.FINAL;
		
		addAnnotation(localNode, local, source);
		
		if (JavacResolution.platformHasTargetTyping()) {
			local.vartype = localNode.getAst().getTreeMaker().Ident(localNode.getAst().toName("___Lombok_VAL_Attrib__"));
		} else {
			local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
		}
		
		Type type;
		try {
			if (rhsOfEnhancedForLoop == null) {
				if (local.init.type == null) {
					JavacResolution resolver = new JavacResolution(localNode.getContext());
					try {
						type = ((JCExpression) resolver.resolveMethodMember(localNode).get(local.init)).type;
					} catch (RuntimeException e) {
						System.err.println("Exception while resolving: " + localNode);
						throw e;
					}
				} else {
					type = local.init.type;
					if (type.isErroneous()) {
						try {
							JavacResolution resolver = new JavacResolution(localNode.getContext());
							local.type = Symtab.instance(localNode.getContext()).unknownType;
							type = ((JCExpression) resolver.resolveMethodMember(localNode).get(local.init)).type;
						} catch (RuntimeException e) {
							System.err.println("Exception while resolving: " + localNode);
							throw e;
						}
					}
				}
			} else {
				if (rhsOfEnhancedForLoop.type == null) {
					JavacResolution resolver = new JavacResolution(localNode.getContext());
					type = ((JCExpression) resolver.resolveMethodMember(localNode.directUp()).get(rhsOfEnhancedForLoop)).type;
				} else {
					type = rhsOfEnhancedForLoop.type;
				}
			}
			
			try {
				JCExpression replacement;
				
				if (rhsOfEnhancedForLoop != null) {
					Type componentType = JavacResolution.ifTypeIsIterableToComponent(type, localNode.getAst());
					if (componentType == null) replacement = JavacResolution.createJavaLangObject(localNode.getAst());
					else replacement = JavacResolution.typeToJCTree(componentType, localNode.getAst(), false);
				} else {
					replacement = JavacResolution.typeToJCTree(type, localNode.getAst(), false);
				}
				
				if (replacement != null) {
					local.vartype = replacement;
				} else {
					local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
				}
				localNode.getAst().setChanged();
			} catch (JavacResolution.TypeNotConvertibleException e) {
				localNode.addError("Cannot use '" + declarationType.annotation.getSimpleName() + "' here because initializer expression does not have a representable type: " + e.getMessage());
				local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
			}
		} catch (RuntimeException e) {
			local.vartype = JavacResolution.createJavaLangObject(localNode.getAst());
			throw e;
		} finally {
			recursiveSetGeneratedBy(local.vartype, source, localNode.getContext());
		}
	}

	private void addAnnotation(JavacNode localNode, JCVariableDecl local, JCTree source) {
		if (!localNode.shouldDeleteLombokAnnotations()) {
			JCAnnotation declarationAnnotation = recursiveSetGeneratedBy(localNode.getTreeMaker().Annotation(local.vartype, List.<JCExpression>nil()), source, localNode.getContext());
			local.mods.annotations = local.mods.annotations == null ? List.of(declarationAnnotation) : local.mods.annotations.append(declarationAnnotation);
		}
	}
}
