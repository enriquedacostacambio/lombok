import java.util.*;
import lombok.var;

public class VarOutersWithGenerics<Z> {
	
	class Inner {
	}
	
	class InnerWithGenerics<H> {
	}
	
	public void testOutersWithGenerics() {
		var foo = "";
		List<Inner> list = new ArrayList<Inner>();
		var elem = list.get(0);
	}
	
	public void testLocalClasses() {
		class Local<A> {}
		
		var q = new Local<String>();
	}
	
	public static void test() {
		var outer = new VarOutersWithGenerics<String>();
		var inner1 = outer.new Inner();
		var inner2 = outer.new InnerWithGenerics<Integer>();
	}
	
	static class SubClass extends VarOutersWithGenerics<String> {
		public void testSubClassOfOutersWithGenerics() {
			List<Inner> list = new ArrayList<Inner>();
			var elem = list.get(0);
		}
	}
	
	public static void loop(Map<String, String> map) {
		for (var e : map.entrySet()) {
		}
	}
}
