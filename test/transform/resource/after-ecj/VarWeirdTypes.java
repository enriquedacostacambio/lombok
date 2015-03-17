import java.util.*;
import lombok.var;
public class VarWeirdTypes<Z> {
  private List<Z> fieldList;
  public VarWeirdTypes() {
    super();
  }
  public void testGenerics() {
    List<String> list = new ArrayList<String>();
    list.add("Hello, World!");
    @var java.lang.String shouldBeString = list.get(0);
    @var java.util.List<java.lang.String> shouldBeListOfString = list;
    @var java.util.List<java.lang.String> shouldBeListOfStringToo = Arrays.asList("hello", "world");
    @var java.lang.String shouldBeString2 = shouldBeListOfString.get(0);
  }
  public void testGenericsInference() {
    @var java.util.List<java.lang.Object> huh = Collections.emptyList();
    @var java.util.List<java.lang.Number> huh2 = Collections.<Number>emptyList();
  }
  public void testPrimitives() {
    @var int x = 10;
    @var long y = (5 + 3L);
  }
  public void testAnonymousInnerClass() {
    @var java.lang.Runnable y = new Runnable() {
      x() {
        super();
      }
      public void run() {
      }
    };
  }
  public <T extends Number>void testTypeParams(List<T> param) {
    @var T t = param.get(0);
    @var Z z = fieldList.get(0);
    @var java.util.List<T> k = param;
    @var java.util.List<Z> y = fieldList;
  }
  public void testBounds(List<? extends Number> lower, List<? super Number> upper) {
    @var java.lang.Number a = lower.get(0);
    @var java.lang.Object b = upper.get(0);
    @var java.util.List<? extends java.lang.Number> c = lower;
    @var java.util.List<? super java.lang.Number> d = upper;
    List<?> unbound = lower;
    @var java.util.List<?> e = unbound;
  }
  public void testCompound() {
    @var java.util.ArrayList<java.lang.String> a = new ArrayList<String>();
    @var java.util.Vector<java.lang.String> b = new Vector<String>();
    @var boolean c = (1 < System.currentTimeMillis());
    @var java.util.AbstractList<java.lang.String> d = (c ? a : b);
    java.util.RandomAccess confirm = (c ? a : b);
  }
  public void nullType() {
    @var java.lang.Object nully = null;
  }
  public void testArrays() {
    @var int[] intArray = new int[]{1, 2, 3};
    @var java.lang.Object[][] multiDimArray = new Object[][]{{}};
    @var int[] copy = intArray;
    @var java.lang.Object[] single = multiDimArray[0];
    @var int singleInt = copy[0];
  }
}