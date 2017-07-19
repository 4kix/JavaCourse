import java.util.HashMap;

public class TestLoader {
	public static void main(String[] args) throws Exception {

		HashMap <String, String> mappings = new HashMap <String, String>();
		mappings.put("TestClass1", "C:\\Users\\Ilya\\Desktop\\classloader\\bin\\TestClass1.class");
		/*
		mappings.put("TestClassInterface", "C:\\Users\\Ilya\\Desktop\\classloader\\bin\\TestClassInterface.class");
		*/

		XLoader xloader = new XLoader(mappings);
		Class <?> xClass1 = xloader.loadClass("TestClass1");
		Object myObj = xClass1.newInstance();
		
		TestClassInterface myTest = (TestClassInterface) myObj;
		myTest.test();
	}
}
