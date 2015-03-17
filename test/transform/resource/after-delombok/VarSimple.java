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
		java.lang.String fieldV = field;
		java.lang.String methodV = method();
		java.lang.String paramV = param;
		java.lang.String varOfVar = fieldV;
		java.lang.String operatorV = fieldV + varOfVar;
		short fieldW = field2;
		double methodW = method2();
		byte localVar = 3;
		int operatorW = fieldW + localVar;
	}
}
