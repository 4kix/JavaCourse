import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

interface IJarSample {
    public void demo(String str);
}
public class JarClassLoader extends ClassLoader
{

	private HashMap<String, String> cache = new HashMap<String, String>();
	private HashMap<String, JarEntry> files = new HashMap<String, JarEntry>();
    private String jarFileName;
    private JarFile jarFile;
    private String packageName;
    private static String WARNING = "Warning : No jar file found. Packet unmarshalling won't be possible. Please verify your classpath";
    private static String NOCLASS = "Failed to load %s.class";
    public static void main (String [] args)
    {
    	JarClassLoader jarClassLoader = new JarClassLoader("C:\\Program Files\\Java\\jdk1.8.0_101\\jre\\lib\\jfr.jar", "");

    	Class<?> clazz;
		try {
			clazz = jarClassLoader.loadClass("DataType");
			IJarSample sample = (IJarSample) clazz.newInstance();
	    	sample.demo("Test");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public JarClassLoader(String jarFileName, String packageName)
    {    
    	this.jarFileName = jarFileName;        
    	this.packageName = packageName;
    	cacheClasses();
    }
    private void cacheClasses()
    {
        try
        {           
            jarFile = new JarFile(jarFileName);
            Enumeration<JarEntry> entries = jarFile.entries();
            JarEntry jarEntry;
            while (entries.hasMoreElements())
            {
                jarEntry = (JarEntry) entries.nextElement();
                // Одно из назначений хорошего загрузчика - валидация классов на этапе загрузки
                if (match(normalize(jarEntry.getName()), packageName))
                {
                    if (loadClassData(jarFile, jarEntry) != null)
                    {
                    	cache.put(stripClassName(normalize(jarEntry.getName())), jarFileName + "/" + jarEntry.getName());
                    	files.put(stripClassName(normalize(jarEntry.getName())), jarEntry);
                    }
                }
            }
            Iterator<String> it = files.keySet().iterator();
            for (String name : files.keySet())
            {
                jarEntry = files.get(name);
                // Одно из назначений хорошего загрузчика - валидация классов на этапе загрузки
                byte[] classData = loadClassData(jarFile, jarEntry);
                if (classData != null)
                {
                	try {
                		Class<?> clazz = defineClass(name, classData, 0, classData.length);
                        System.out.println("== class " + clazz.getName() + " loaded in cache");
                	}
                    catch (ClassFormatError E)
                    {
                    	System.out.println(String.format(NOCLASS, normalize(name)));
                    }
                }
            }
        }
        catch (IOException IOE)
        {
        	System.out.println(WARNING);
        }
        
	}
    /**
     * Собственно метод, который и реализует загрузку класса
     * @throws ClassNotFoundException 
     */

    public synchronized Class<?> loadClass(String name) throws ClassNotFoundException
    {
    	try {
			System.out.println ("loadClass (" + name + ")");
			// приоритет отдан именно загрузке с помощью встроенного загрузчика
			if (! files.containsKey(name)){
				return super.findSystemClass(name);
			}
			//String fileName = files.get(name);
			//FileInputStream fin = new FileInputStream(fileName);
			//byte[] bbuf = new byte [(int) (new File(fileName).length())];
			//fin.read(bbuf);
			//fin.close();
			byte[] bbuf = loadClassData (jarFile, files.get(name));
			return defineClass(name, bbuf, 0, bbuf.length);
		} catch (IOException e) {
			throw new ClassNotFoundException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(String.format(NOCLASS, name));
		}
		return null;
    }
    
    /**
     * Получаем каноническое имя класса
     * @param className
     * @return
     */
    private String stripClassName(String className) {
        return className.substring(0, className.length() - 6);
    }
    
    /**
     * Преобразуем имя в файловой системе в имя класса
     * (заменяем слэши на точки)
     * @param className
     * @return
     */

    private String normalize(String className) {
        return className.replace('/', '.');
    }
    
    /**
     * Валидация класса - проверят принадлежит ли класс заданному пакету и имеет ли
     * он расширение .class
     * @param className
     * @param packageName
     * @return
     */

    private boolean match(String className, String packageName) {
        return className.startsWith(packageName) && className.endsWith(".class");
    }   

    /**
     * Извлекаем файл из заданного JarEntry
     * @param jarFile - файл jar-архива из которого извлекаем нужный файл
     * @param jarEntry - jar-сущность которую извлекаем
     * @return null если невозможно прочесть файл
     */

    private byte[] loadClassData(JarFile jarFile, JarEntry jarEntry) throws IOException
    {
        long size = jarEntry.getSize();     
        if (size == -1 || size == 0)
            return null;
        byte[] data = new byte[(int)size];
        InputStream in = jarFile.getInputStream(jarEntry);
        in.read(data);
        in.close();
        return data;
    }
}