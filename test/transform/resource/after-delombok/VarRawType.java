import java.util.List;

public class VarRawType {

	public void test() {
		Element propElement = new Element();
		for (java.lang.Object attribute : propElement.attributes()) {
			VarRawType.Attribute attr = (Attribute)attribute;
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