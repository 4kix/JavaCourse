package fwk;

import controller.interfaces.MyController;

public interface AbstractFactory {

	public MyController getByView(String s);
}