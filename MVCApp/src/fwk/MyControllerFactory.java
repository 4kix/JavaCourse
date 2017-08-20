package fwk;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import controller.MyControllerImpl;
import controller.interfaces.MyController;

/**An implementation of AbstractFactory for getting instances of controllers.
 * Also implements Singleton and Proxy patterns.
 * 
 * @author Ilya Falko
 *
 */
public class MyControllerFactory implements AbstractFactory {
	
	private ViewToControllerMapping map = new ViewToControllerMapping();

	
	//--------Constructor-------------
	private MyControllerFactory() {
		
	}

	//------Singleton Holder---------
	
	private static class SingletonHolder {  
	      public static final MyControllerFactory instance = new MyControllerFactory();  
	   }
	
	//---------Methods------------
	
	/**
	 * 
	 * @return instance returns an instance of MyControllerFactory
	 */
	public static MyControllerFactory getInstance()  {  
	      return SingletonHolder.instance;  
	   }
	
	/**returns new instance of the controller, related to the view, specified as a method argument argument,
	 * if it has mapping in map.xml
	 * 
	 * @param viewName name of the view
	 * @return instance of the controller
	 */
	@Override
	public MyController getByView(String viewName) {
		
		//loading map
		loadMapping();
		
		MyControllerImpl controller = null;
		try {
			//getting a class of the controller, if it has a map
			Class<?> cl = Class.forName(map.getByKey(viewName));
			controller = (MyControllerImpl)cl.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return controller;
	}
	
	/**loads map of views and controllers from map.xml
	 * 
	 */
	private void loadMapping() {
		Mapping mapping = new Mapping();
		ViewToControllerMapping unmarshalled = null;
		
		try {
			//loading of map context
			mapping.loadMapping("./mapping/mapping.xml");
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			
			//unmarshalling of map.xml
			Reader reader = new FileReader("map.xml");	
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass(ViewToControllerMapping.class);

			unmarshalled = (ViewToControllerMapping) unmarshaller.unmarshal(reader);	
			reader.close();
			
			
		} catch (MarshalException | ValidationException | IOException | MappingException e) {
			e.printStackTrace();
		}
		
		//saving map
		this.map.setMap(unmarshalled.getMap());  
		
	}

}
