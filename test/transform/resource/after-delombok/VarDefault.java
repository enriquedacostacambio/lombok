// version 8:
interface VarDefault {
	int size();
	default void method() {
		int x = 1;
		int size = size();
	}
}