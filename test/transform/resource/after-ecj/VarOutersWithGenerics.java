import java.util.*;
import lombok.var;
public class VarOutersWithGenerics<Z> {
  class Inner {
    Inner() {
      super();
    }
  }
  class InnerWithGenerics<H> {
    InnerWithGenerics() {
      super();
    }
  }
  static class SubClass extends VarOutersWithGenerics<String> {
    SubClass() {
      super();
    }
    public void testSubClassOfOutersWithGenerics() {
      List<Inner> list = new ArrayList<Inner>();
      @var VarOutersWithGenerics<java.lang.String>.Inner elem = list.get(0);
    }
  }
  public VarOutersWithGenerics() {
    super();
  }
  public void testOutersWithGenerics() {
    @var java.lang.String foo = "";
    List<Inner> list = new ArrayList<Inner>();
    @var VarOutersWithGenerics<Z>.Inner elem = list.get(0);
  }
  public void testLocalClasses() {
    class Local<A> {
      Local() {
        super();
      }
    }
    @var Local<java.lang.String> q = new Local<String>();
  }
  public static void test() {
    @var VarOutersWithGenerics<java.lang.String> outer = new VarOutersWithGenerics<String>();
    @var VarOutersWithGenerics<java.lang.String>.Inner inner1 = outer.new Inner();
    @var VarOutersWithGenerics<java.lang.String>.InnerWithGenerics<java.lang.Integer> inner2 = outer.new InnerWithGenerics<Integer>();
  }
  public static void loop(Map<String, String> map) {
    for (@var java.util.Map.Entry<java.lang.String, java.lang.String> e : map.entrySet()) 
      {
      }
  }
}
