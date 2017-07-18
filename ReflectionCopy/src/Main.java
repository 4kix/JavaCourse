import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("Vasia", "Pupkin");
		Account acc = new Account(500);
		customer1.setAccount(acc);
		Customer customer2 = new Customer();
		
		try {
			reflectionCopy.classCopy(customer1, customer2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		System.out.println(customer1);
		System.out.println(customer2);
		
		Integer[] array1 = {1,2,3,4,5};
		System.out.println(Arrays.toString(array1));
		Integer[] array2 = reflectionCopy.arrayCopy(array1);
		System.out.println(Arrays.toString(array2));
	}

	
}
