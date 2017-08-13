package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import controller.interfaces.AbstractFactory;
import controller.interfaces.MyController;

/**An implementation of AbstractFactory for getting instances of controllers
 * 
 * @author Ilya Falko
 *
 */
public class MyControllerFactory implements AbstractFactory {

	Map<String, String> map; 
	
	//---------Getters & Setters---------
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	
	//--------Constructor-------------
	public MyControllerFactory() {
		map = new HashMap<String, String>();
	}
	
	
	//---------Methods------------
	
	
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
			Class<?> cl = Class.forName(map.get(viewName));
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
		MyControllerFactory unmarshalled = null;
		
		try {
			//loading of map context
			mapping.loadMapping("D:/eclipse projects/MVCApp/src/mapping/mapping.xml");
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			
			//unmarshalling of map.xml
			Reader reader = new FileReader("map.xml");	
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass(MyControllerFactory.class);

			unmarshalled = (MyControllerFactory) unmarshaller.unmarshal(reader);	
			reader.close();
			
			
		} catch (MarshalException | ValidationException | IOException | MappingException e) {
			e.printStackTrace();
		}
		
		//saving map
		this.map = unmarshalled.map;
		
	}

}
