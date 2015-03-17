public class VarErrors {
	public void unresolvableExpression() {
		java.lang.Object c = d;
	}
	public void arrayInitializer() {
		var e = {"foo", "bar"};
	}
}