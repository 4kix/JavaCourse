package classloader;
public class ClassForLoader {
	public static String stat_foo = "hello stat_foo";

	static {
		System.out.println("SexyClassForLoader$$static");
	}

	{
		System.out.println("SexyClassForLoader$$init");
	}


	public static String getStatFoo() {
		return stat_foo;
	}

	public String getSimpleFoo() {
		return simple_foo;
	}

	public String simple_foo = "hello simple_foo";

	public void makeBar() {
		System.out.println ("make bar");
	}
}