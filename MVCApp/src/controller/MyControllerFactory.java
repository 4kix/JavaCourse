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

public class MyControllerFactory implements AbstractFactory {

	Map<String, String> map; 
	
	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public MyControllerFactory() {
		map = new HashMap<String, String>();
	}
	
	@Override
	public MyControllerImpl getByView(String s) {
		loadMapping();
		
		MyControllerImpl controller = null;
		try {
			Class<?> cl = Class.forName(map.get(s));
			controller = (MyControllerImpl)cl.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return controller;
	}
	
	private void loadMapping() {
		Mapping mapping = new Mapping();
		MyControllerFactory unmarshalled = null;
		
		try {
			mapping.loadMapping("D:/eclipse projects/MVCApp/src/mapping/mapping.xml");
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
			
			Reader reader = new FileReader("map.xml");	
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass(MyControllerFactory.class);

			unmarshalled = (MyControllerFactory) unmarshaller.unmarshal(reader);	
			reader.close();
			
			
		} catch (MarshalException | ValidationException | IOException | MappingException e) {
			e.printStackTrace();
		}
		
		this.map = unmarshalled.map;
		
	}

}
