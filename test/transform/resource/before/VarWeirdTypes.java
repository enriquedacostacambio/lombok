import java.util.*;
import lombok.var;

public class VarWeirdTypes<Z> {
	private List<Z> fieldList;
	
	public void testGenerics() {
		List<String> list = new ArrayList<String>();
		list.add("Hello, World!");
		var shouldBeString = list.get(0);
		var shouldBeListOfString = list;
		var shouldBeListOfStringToo = Arrays.asList("hello", "world");
		var shouldBeString2 = shouldBeListOfString.get(0);
	}
	
	public void testGenericsInference() {
		var huh = Collections.emptyList();
		var huh2 =  Collections.<Number>emptyList();
	}
	
	public void testPrimitives() {
		var x = 10;
		var y = 5 + 3L;
	}
	
	public void testAnonymousInnerClass() {
		var y = new Runnable() {
			public void run() {}
		};
	}
	
	public <T extends Number> void testTypeParams(List<T> param) {
		var t = param.get(0);
		var z = fieldList.get(0);
		var k = param;
		var y = fieldList;
	}
	
	public void testBounds(List<? extends Number> lower, List<? super Number> upper) {
		var a = lower.get(0);
		var b = upper.get(0);
		var c = lower;
		var d = upper;
		List<?> unbound = lower;
		var e = unbound;
	}
	
	public void testCompound() {
		var a = new ArrayList<String>();
		var b = new Vector<String>();
		var c = 1 < System.currentTimeMillis();
		var d = c ? a : b;
		java.util.RandomAccess confirm = c ? a : b;
	}
	
	public void nullType() {
		var nully = null;
	}
	
	public void testArrays() {
		var intArray = new int[] {1, 2, 3};
		var multiDimArray = new Object[][] {{}};
		var copy = intArray;
		var single = multiDimArray[0];
		var singleInt = copy[0];
	}
}