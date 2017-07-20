import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * 
 * @author Ilya Falko
 *
 */
public class reflectionCopy {

	/**
	 * 
	 * @param entity
	 * @param entity2
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 */
	public static <T1, T2>  void classCopy(T1 entity, T2 entity2) throws IllegalAccessException, NoSuchFieldException {
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

	
	/**
	 * 
	 * @param source
	 * @return
	 */
	public static <T> T[] arrayCopy(T[] source) {
		
		Class<?> arrayType = source.getClass().getComponentType();		
		T[] copy = (T[])Array.newInstance(arrayType, source.length);		
		System.arraycopy(source, 0, copy, 0, source.length);		
		return copy;
	}
}
