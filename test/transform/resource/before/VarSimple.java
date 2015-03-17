import lombok.var;

public class VarSimple {
	private String field = "field";
	private short field2 = 5;
	
	private String method() {
		return "method";
	}
	
	private double method2() {
		return 2.0;
	}
	
	private void testVar(String param) {
		var fieldV = field;
		var methodV = method();
		var paramV = param;
		
		var varOfVar = fieldV;
		var operatorV = fieldV + varOfVar;
		
		var fieldW = field2;
		var methodW = method2();
		byte localVar = 3;
		var operatorW = fieldW + localVar;
	}
}
