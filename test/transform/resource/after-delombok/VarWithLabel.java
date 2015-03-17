public class VarWithLabel {
	{
		LABEL:
		for (java.lang.String x : new String[0]) {
			if (x.toLowerCase() == null) {
				continue LABEL;
			}
		}
	}
}