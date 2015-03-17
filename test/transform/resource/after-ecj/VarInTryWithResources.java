import lombok.var;
import java.io.IOException;
public class VarInTryWithResources {
  public VarInTryWithResources() {
    super();
  }
  public void whyTryInsteadOfCleanup() throws IOException {
    try (@var java.io.InputStream in = getClass().getResourceAsStream("VarInTryWithResources.class"))
      {
        @var java.io.InputStream i = in;
        @var int j = in.read();
      }
  }
}
