import lombok.var;

public class VarWithLabel {
	{
		LABEL: for (var x : new String[0]) {
			if (x.toLowerCase() == null) {
				continue LABEL;
			}
		}
	}
}