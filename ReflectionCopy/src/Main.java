import java.lang.reflect.Field;

public class Main {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer("Vasia", "Pupkin");
		Account acc = new Account(500);
		customer1.setAccount(acc);
		Customer customer2 = new Customer();
		
		try {
			copy(customer1, customer2);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		System.out.println(customer1);
		System.out.println(customer2);
		
	}

	public static <T1, T2>  void copy(T1 entity, T2 entity2) throws IllegalAccessException, NoSuchFieldException {
			Class<?> copy1 = entity.getClass();
			Class<?> copy2 = entity2.getClass();

			Field[] fromFields = copy1.getDeclaredFields();
			Object value = null;

			for (Field field : fromFields){
	
				field.setAccessible(true);
				
			    Field toField = copy2.getDeclaredField(field.getName());
			    toField.setAccessible(true);
			    
			    System.out.println(field.getName());
			    value = field.get(entity);
			    toField.set(entity2, value);
			}
	}
}
