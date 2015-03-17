public class VarInFor {
	public void enhancedFor() {
		java.util.List<String> list = java.util.Arrays.asList("Hello, World!");
		for (java.lang.String shouldBeString : list) {
			System.out.println(shouldBeString.toLowerCase());
			java.lang.String shouldBeString2 = shouldBeString;
		}
	}
}