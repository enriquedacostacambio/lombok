import lombok.var;

public class VarErrors {
	public void unresolvableExpression() {
		var c = d;
	}
	
	public void arrayInitializer() {
		var e = { "foo", "bar"};
	}
}