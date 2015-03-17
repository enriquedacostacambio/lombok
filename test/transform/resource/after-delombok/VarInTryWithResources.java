//version 7:
import java.io.IOException;
public class VarInTryWithResources {
	public void whyTryInsteadOfCleanup() throws IOException {
		try (java.io.InputStream in = getClass().getResourceAsStream("VarInTryWithResources.class")) {
			java.io.InputStream i = in;
			int j = in.read();
		}
	}
}
