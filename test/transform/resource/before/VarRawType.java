import java.util.List;
import lombok.var;

public class VarRawType {
	public void test() {
		Element propElement = new Element();
		for (var attribute : propElement.attributes()) {
			var attr = (Attribute) attribute;
		}
	}
	
	static class Element {
		public List attributes() {
			return null;
		}
	}
	
	static class Attribute {
	}
}