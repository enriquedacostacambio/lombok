import java.util.List;
import lombok.var;
public class VarRawType {
  static class Element {
    Element() {
      super();
    }
    public List attributes() {
      return null;
    }
  }
  static class Attribute {
    Attribute() {
      super();
    }
  }
  public VarRawType() {
    super();
  }
  public void test() {
    Element propElement = new Element();
    for (@var java.lang.Object attribute : propElement.attributes()) 
      {
        @var VarRawType.Attribute attr = (Attribute) attribute;
      }
  }
}