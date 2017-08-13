package controller.interfaces;

import controller.MyControllerImpl;
import view.MyViewImpl;

public interface AbstractFactory {

	public MyController getByView(String s);
}