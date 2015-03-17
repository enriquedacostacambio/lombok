// version 8:
class VarLambda {
	public void easyLambda() {
		java.lang.Runnable foo = (Runnable)() -> {
		};
	}
	public void easyIntersectionLambda() {
		java.lang.Object foo = (Runnable & java.io.Serializable)() -> {
		};
		java.lang.Object bar = (java.io.Serializable & Runnable)() -> {
		};
	}
	public void easyLubLambda() {
		java.lang.Runnable foo = (System.currentTimeMillis() > 0) ? (Runnable)() -> {
		} : (Runnable)System.out::println;
	}
//	public void castLubLambda() {
//		Runnable foo = (Runnable)((System.currentTimeMillis() > 0) ? ()-> {} : System.out::println);
//		lombok.var foo = (Runnable)((System.currentTimeMillis() > 0) ? ()-> {} : System.out::println);
//	}
}