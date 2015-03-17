import java.util.*;
public class VarAnonymousSubclassWithGenerics {
	Object object = new Object(){
		void foo() {
			int j = 1;
		}
	};
	void bar() {
		int k = super.hashCode();
		int x = k;
	}
	java.util.List<String> names = new java.util.ArrayList<String>(){
		public String get(int i) {
			java.lang.String result = super.get(i);
			return result;
		}
	};
}
