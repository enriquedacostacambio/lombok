import java.util.*;
public class VarOutersWithGenerics<Z> {
	class Inner {
	}
	class InnerWithGenerics<H> {
	}
	public void testOutersWithGenerics() {
		java.lang.String foo = "";
		List<Inner> list = new ArrayList<Inner>();
		VarOutersWithGenerics<Z>.Inner elem = list.get(0);
	}
	public void testLocalClasses() {
		class Local<A> {
		}
		Local<java.lang.String> q = new Local<String>();
	}
	public static void test() {
		VarOutersWithGenerics<java.lang.String> outer = new VarOutersWithGenerics<String>();
		VarOutersWithGenerics<java.lang.String>.Inner inner1 = outer.new Inner();
		VarOutersWithGenerics<java.lang.String>.InnerWithGenerics<java.lang.Integer> inner2 = outer.new InnerWithGenerics<Integer>();
	}
	static class SubClass extends VarOutersWithGenerics<String> {
		public void testSubClassOfOutersWithGenerics() {
			List<Inner> list = new ArrayList<Inner>();
			VarOutersWithGenerics<java.lang.String>.Inner elem = list.get(0);
		}
	}
	public static void loop(Map<String, String> map) {
		for (java.util.Map.Entry<java.lang.String, java.lang.String> e : map.entrySet()) {
		}
	}
}
