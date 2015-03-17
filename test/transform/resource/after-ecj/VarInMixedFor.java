import lombok.var;
public class VarInMixedFor {
  public VarInMixedFor() {
    super();
  }
  public void basicFor() {
    java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
    for (@var int shouldBe = 1;, @var int marked = "";, @var int error = 1.0;; ; ) 
      {
        System.out.println("");
      }
  }
}