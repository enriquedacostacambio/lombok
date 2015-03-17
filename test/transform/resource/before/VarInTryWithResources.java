//version 7:
import lombok.var;
import java.io.IOException;

public class VarInTryWithResources {
	public  void whyTryInsteadOfCleanup() throws IOException {
		try (var in = getClass().getResourceAsStream("VarInTryWithResources.class")) {
			var i = in;
			var j = in.read();
		}
	}
}