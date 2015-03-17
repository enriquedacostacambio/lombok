import java.util.*;
public class VarWeirdTypes<Z> {
	private List<Z> fieldList;
	public void testGenerics() {
		List<String> list = new ArrayList<String>();
		list.add("Hello, World!");
		java.lang.String shouldBeString = list.get(0);
		java.util.List<java.lang.String> shouldBeListOfString = list;
		java.util.List<java.lang.String> shouldBeListOfStringToo = Arrays.asList("hello", "world");
		java.lang.String shouldBeString2 = shouldBeListOfString.get(0);
	}
	public void testGenericsInference() {
		java.util.List<java.lang.Object> huh = Collections.emptyList();
		java.util.List<java.lang.Number> huh2 = Collections.<Number>emptyList();
	}
	public void testPrimitives() {
		int x = 10;
		long y = 5 + 3L;
	}
	public void testAnonymousInnerClass() {
		java.lang.Runnable y = new Runnable(){
			public void run() {
			}
		};
	}
	public <T extends Number> void testTypeParams(List<T> param) {
		T t = param.get(0);
		Z z = fieldList.get(0);
		java.util.List<T> k = param;
		java.util.List<Z> y = fieldList;
	}
	public void testBounds(List<? extends Number> lower, List<? super Number> upper) {
		java.lang.Number a = lower.get(0);
		java.lang.Object b = upper.get(0);
		java.util.List<? extends java.lang.Number> c = lower;
		java.util.List<? super java.lang.Number> d = upper;
		List<?> unbound = lower;
		java.util.List<?> e = unbound;
	}
	public void testCompound() {
		java.util.ArrayList<java.lang.String> a = new ArrayList<String>();
		java.util.Vector<java.lang.String> b = new Vector<String>();
		boolean c = 1 < System.currentTimeMillis();
		java.util.AbstractList<java.lang.String> d = c ? a : b;
		java.util.RandomAccess confirm = c ? a : b;
	}
	public void nullType() {
		java.lang.Object nully = null;
	}
	public void testArrays() {
		int[] intArray = new int[]{1, 2, 3};
		java.lang.Object[][] multiDimArray = new Object[][]{{}};
		int[] copy = intArray;
		java.lang.Object[] single = multiDimArray[0];
		int singleInt = copy[0];
	}
}