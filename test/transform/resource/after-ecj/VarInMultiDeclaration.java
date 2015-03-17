import lombok.var;
public class VarInMultiDeclaration {
  public VarInMultiDeclaration() {
    super();
  }
  public void test() {
    @var int x = 10;
    @var java.lang.String y = "";
  }
}
