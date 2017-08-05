package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public class Bank{
	private static List<Customer> customers;

	
	static {
		customers = new ArrayList<Customer>(30);
	}
	/*public Bank() {
		customers = new ArrayList<Customer>(30);
		numberOfCustomers = 0;
	}*/
	
	public static void addCustomer(String f, String l) {
		customers.add(new Customer(f,l));
		
	}

	
	public static Customer getCustomer(int index) {
		return customers.get(index);
	}
	
	public static int getNumOfCustomers() {
		return customers.size();
	}
	
	public static List<Customer> getCustomers() {
		return customers;
	}

}
