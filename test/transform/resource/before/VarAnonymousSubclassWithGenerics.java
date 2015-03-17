// issue 205: var inside anonymous inner classes is a bit tricky in javac, this test ensures we don't break it.
import java.util.*;
import lombok.var;

public class VarAnonymousSubclassWithGenerics {
	Object object = new Object(){
		void foo() {
			var j = 1;
		}
	};
	
	void bar() {
		var k = super.hashCode();
		int x = k;
	}
	
	java.util.List<String> names = new java.util.ArrayList<String>() {
		public String get(int i) {
			var result = super.get(i);
			return result;
		}
	};
}
