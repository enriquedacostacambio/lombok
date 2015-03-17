import lombok.var;

public class VarInFor {
	public void enhancedFor() {
		java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
		for (var shouldBeString : list) {
			System.out.println(shouldBeString.toLowerCase());
			var shouldBeString2 = shouldBeString;
		}
	}
}