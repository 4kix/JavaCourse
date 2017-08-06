package by.iba.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;
import org.json.JSONException;
import org.json.JSONObject;


import by.iba.entity.Person;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;



public class TestCastor {
	
	public static void main( String[] args ) {
		try {			
			Person person = new Person("Nikilai Nikolaev", "Grodno, Belarus", "nikolaev@mail.ru", "3469874");
			
			//Mapping
			Mapping mapping = new Mapping();
			mapping.loadMapping("D:\\eclipse projects\\CastorRW\\src\\by\\iba\\mapping\\mapping.xml");
			XMLContext context = new XMLContext();
			context.addMapping(mapping);
		
			//Marshall
			Writer writer = new FileWriter("person.xml");	
			Marshaller marshaller = context.createMarshaller();
			marshaller.setWriter(writer);	
			marshaller.marshal(person);
		
			writer.close();
		
			//Unmarshall
			Reader reader = new FileReader("person.xml");	
			Unmarshaller unmarshaller = context.createUnmarshaller();
			unmarshaller.setClass(Person.class);
		
			Person unmarshalled = (Person) unmarshaller.unmarshal(reader);	
			reader.close();
		
			System.out.println(unmarshalled);
		} catch (IOException e1){
			e1.printStackTrace();
		} catch (MappingException e1) {
			e1.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

}