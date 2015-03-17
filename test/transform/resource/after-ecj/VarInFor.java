import lombok.var;
public class VarInFor {
  public VarInFor() {
    super();
  }
  public void enhancedFor() {
    java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
    for (@var java.lang.String shouldBeString : list) 
      {
        System.out.println(shouldBeString.toLowerCase());
        @var java.lang.String shouldBeString2 = shouldBeString;
      }
  }
}