import lombok.val;
public class ValInBasicFor {
  public ValInBasicFor() {
    super();
  }
  public void basicFor() {
    java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
    for (final @val double shouldBeFloat = 1.0;, final @val double here = 2;, final @val double too = 3.0;; ; ) 
      {
        System.out.println("");
      }
  }
}