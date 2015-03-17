import lombok.var;
public class VarErrors {
  public VarErrors() {
    super();
  }
  public void unresolvableExpression() {
    var c = d;
  }
  public void arrayInitializer() {
    var e = {"foo", "bar"};
  }
}