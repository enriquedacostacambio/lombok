import lombok.var;
public class VarSimple {
  private String field = "field";
  private short field2 = 5;
  public VarSimple() {
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
    @var java.lang.String methodV = method();
    @var java.lang.String paramV = param;
    @var java.lang.String varOfVar = fieldV;
    @var java.lang.String operatorV = (fieldV + varOfVar);
    @var short fieldW = field2;
    @var double methodW = method2();
    byte localVar = 3;
    @var int operatorW = (fieldW + localVar);
  }
}