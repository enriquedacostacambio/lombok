import lombok.var;
public class VarLessSimple {
  private short field2 = 5;
  {
    System.out.println("Hello");
    @var int z = 20;
    @var int x = 10;
    @var int a = z;
    @var short y = field2;
  }
  private String field = "field";
  public VarLessSimple() {
    super();
  }
  private String method() {
    return "method";
  }
  private double method2() {
    return 2.0;
  }
  private void testVar(String param) {
    @var java.lang.String fieldV = field;
    @var int a = 10;
    @var int b = 20;
    {
      @var java.lang.String methodV = method();
      @var java.lang.String foo = (fieldV + methodV);
    }
  }
  private void testVarInCatchBlock() {
    try 
      {
        @var int x = (1 / 0);
      }
    catch (ArithmeticException e)
      {
        @var int y = 0;
      }
  }
}
