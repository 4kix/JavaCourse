package by.iba.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.codehaus.jackson.map.ObjectMapper;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;

import by.iba.entity.Person;
import by.iba.marshaller.MyMarshallerToJSON;

public class TestJSONMarshaller {

	public static void main(String[] args) {
		
		Person person = new Person("Nikilai Nikolaev", "Grodno, Belarus", "nikolaev@mail.ru", "3469874");
		
		Writer writer;
		try {
			writer = new FileWriter("person.json");
			Marshaller marshaller = new MyMarshallerToJSON(writer);
			marshaller.marshal(person);
			
			/*ObjectMapper mapper = new ObjectMapper();
			Person person1 = mapper.readValue(new File("person.json"), Person.class);		
			System.out.println(person1);*/
			
			//writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MarshalException e) {
			e.printStackTrace();
		} catch (ValidationException e) {
			e.printStackTrace();
		} 

	}

}
