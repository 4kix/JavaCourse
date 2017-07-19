import java.util.HashMap;

public class TestLoader {
	public static void main(String[] args) throws Exception {

		HashMap <String, String> mappings = new HashMap <String, String>();
		mappings.put("TestClass1", "C:\\Users\\student\\git\\JavaCourse\\classloader\\bin\\TestClass1.class");
		mappings.put("TestClass2", "C:\\Users\\student\\git\\JavaCourse\\classloader\\bin\\TestClass2.class");
		/*
		mappings.put("TestClassInterface", "C:\\Users\\Ilya\\Desktop\\classloader\\bin\\TestClassInterface.class");
		*/
		XLoader xloader = new XLoader(mappings);
		Class <?> xClass1 = xloader.loadClass("TestClass1");
		Class <?> xClass2 = xloader.loadClass("TestClass2");
		
		Object myObj1 = xClass1.newInstance();
		Object myObj2 = xClass2.newInstance();
		
		TestClassInterface myTest1 = (TestClassInterface) myObj1;
		TestClassInterface myTest2 = (TestClassInterface) myObj2;
		
		myTest1.test();
		myTest2.test();
	}
}
