import lombok.var;
public class VarInBasicFor {
  public VarInBasicFor() {
    super();
  }
  public void basicFor() {
    java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
    for (@var double shouldBeFloat = 1.0;, @var double here = 2;, @var double too = 3.0;; ; ) 
      {
        System.out.println("");
      }
  }
}