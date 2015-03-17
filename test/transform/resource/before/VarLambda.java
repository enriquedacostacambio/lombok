// version 8:
class VarLambda {
	public void easyLambda() {
		lombok.var foo = (Runnable)()-> {};
	}
	
	public void easyIntersectionLambda() {
		lombok.var foo = (Runnable & java.io.Serializable)()-> {};
		lombok.var bar = (java.io.Serializable & Runnable)()-> {};
	}
	
	public void easyLubLambda() {
		lombok.var foo = (System.currentTimeMillis() > 0) ? (Runnable)()-> {} : (Runnable)System.out::println;
	}
	
//	public void castLubLambda() {
//		Runnable foo = (Runnable)((System.currentTimeMillis() > 0) ? ()-> {} : System.out::println);
//		lombok.var foo = (Runnable)((System.currentTimeMillis() > 0) ? ()-> {} : System.out::println);
//	}
}
