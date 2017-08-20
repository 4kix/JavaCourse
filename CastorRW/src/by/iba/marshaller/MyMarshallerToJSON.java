package by.iba.marshaller;

import java.io.IOException;
import java.io.Writer;

import java.util.HashMap;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.json.JSONException;
import org.json.JSONObject;

/**An extension of Castor Marshaller class for marshalling in JSON
 * 
 * @author Ilya Falko
 *
 */
public class MyMarshallerToJSON extends Marshaller {
	
	Writer writer;
	
	public MyMarshallerToJSON(Writer out) throws IOException {
		setWriter(out);
	}
	
	@Override
	public void setWriter(Writer out) throws IOException {
		writer = out;
	}
	
	/**Marshalls objext in JSON
	 * 
	 * @param object An object for marshalling
	 */
	@Override
	public void marshal(Object object) throws MarshalException, ValidationException {

		JSONObject jsonObject = new JSONObject(object);
		
		try {
			jsonObject.write(writer);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		} 					
	}	
}
