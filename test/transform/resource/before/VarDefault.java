// version 8:
interface VarDefault {
	int size();
	
	default void method() {
		lombok.var x = 1;
		lombok.var size = size();
	}
}