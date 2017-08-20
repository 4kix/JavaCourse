/**Second class for testing classloader
 * 
 * @author Ilya Falko
 *
 */
public class TestClass2 implements TestClassInterface {
	public double field1;
	public int field2;
	public long field3;
	public short field4;
	public float field5;
	public float field6;
	public double[] array = new double[30];
	
	static {
			System.out.println("TestClass2 init");
	}
	
	@Override
	public void test() {
		System.out.println("test method of TestClass2 successfully called");
	}
}
