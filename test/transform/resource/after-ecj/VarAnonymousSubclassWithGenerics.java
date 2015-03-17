import java.util.*;
import lombok.var;
public class VarAnonymousSubclassWithGenerics {
  Object object = new Object() {
    x() {
      super();
    }
    void foo() {
      @var int j = 1;
    }
  };
  java.util.List<String> names = new java.util.ArrayList<String>() {
    x() {
      super();
    }
    public String get(int i) {
      @var java.lang.String result = super.get(i);
      return result;
    }
  };
  public VarAnonymousSubclassWithGenerics() {
    super();
  }
  void bar() {
    @var int k = super.hashCode();
    int x = k;
  }
}