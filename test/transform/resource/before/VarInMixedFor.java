import lombok.var;

public class VarInMixedFor {
	public void basicFor() {
		java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
		for (var shouldBe = 1, marked = "", error = 1.0; ; ) {
			System.out.println("");
		}
	}
}