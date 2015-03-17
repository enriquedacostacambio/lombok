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
		int z = 20;
		int x = 10;
		int a = z;
		short y = field2;
	}
	private void testVar(String param) {
		java.lang.String fieldV = field;
		int a = 10;
		int b = 20;
		{
			java.lang.String methodV = method();
			java.lang.String foo = fieldV + methodV;
		}
	}
	private void testVarInCatchBlock() {
		try {
			int x = 1 / 0;
		} catch (ArithmeticException e) {
			int y = 0;
		}
	}
	private String field = "field";
}