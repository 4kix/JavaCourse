package test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLContext;

import controller.ControllerManager;
import controller.MyControllerFactory;
import model.TextModel;
import view.MyViewImpl;

public class TestApp {

	public static void main(String[] args) {

		TextModel model = new TextModel();
		MyViewImpl view = new MyViewImpl(model);
		
		ControllerManager manager = ControllerManager.getInstance();
		
		view.launchFrame();

	}

}
