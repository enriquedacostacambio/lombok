import lombok.var;

public class VarInBasicFor {
	public void basicFor() {
		java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
		for (var shouldBeFloat = 1.0, here = 2, too = 3.0; ; ) {
			System.out.println("");
		}
	}
}