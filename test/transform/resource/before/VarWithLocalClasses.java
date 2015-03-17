//issue 694: In javac, resolving the RHS (which is what var does) can cause an entire class to be resolved, breaking all usage of var inside that class. This tests that we handle that better.
class VarWithLocalClasses1 {
	{
		lombok.var f2 = new VarWithLocalClasses2() {};
	}
}

class VarWithLocalClasses2 {
	{
		lombok.var f3 = 0;
	}
}