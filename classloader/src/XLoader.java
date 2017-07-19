import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

class XLoader extends ClassLoader {
// карта отображения имен классов на файлы .class, где хранятся их определения
	HashMap <String, String> mappings;

	XLoader(HashMap <String, String> mappings) {
		this.mappings = mappings;
	}

	public synchronized Class <?> loadClass(String name) throws ClassNotFoundException {
		try {
			System.out.println ("loadClass (" + name + ")");
			// приоритет отдан именно загрузке с помощью встроенного загрузчика
			if (! mappings.containsKey(name)){
				return super.findSystemClass(name);
			}
			String fileName = mappings.get(name);
			FileInputStream fin = new FileInputStream(fileName);
			byte[] bbuf = new byte [(int) (new File(fileName).length())];
			fin.read(bbuf);
			fin.close();
			Class<?> loadedClass = defineClass(name, bbuf, 0, bbuf.length);
			if(checkClass(loadedClass)) {
				return loadedClass;
			}
			else return null;
		} catch (IOException e) {
			e.printStackTrace();
			throw new ClassNotFoundException(e.getMessage(), e);
		}
	}
	
	private boolean checkClass(Class<?> loadedClass) {
		Field[] fields = loadedClass.getClass().getDeclaredFields();
			
		for (Field field : fields) {
			
			field.setAccessible(true);
			Class typeOfField = field.getType();
			
		}
		return true;
	}
}