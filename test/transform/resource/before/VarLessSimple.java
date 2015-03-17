import lombok.var;

public class VarLessSimple {
	private short field2 = 5;
	
	private String method() {
		return "method";
	}
	
	private double method2() {
		return 2.0;
	}
	
	{
		System.out.println("Hello");
		var z = 20;
		var x = 10;
		var a = z;
		var y = field2;
	}
	
	private void testVar(String param) {
		var fieldV = field;
		var a = 10;
		var b = 20;
		{
			var methodV = method();
			var foo = fieldV + methodV;
		}
	}
	
	private void testVarInCatchBlock() {
		try {
			var x = 1 / 0;
		} catch (ArithmeticException e) {
			var y = 0;
		}
	}
	
	private String field = "field";
}
