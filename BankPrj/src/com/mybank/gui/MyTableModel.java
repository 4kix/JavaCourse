package com.mybank.gui;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.mybank.domain.Bank;
import com.mybank.domain.Customer;

public class MyTableModel implements TableModel {

	private Bank bank;
	public MyTableModel(Bank bnk) {
		bank = bnk;	
		}
	
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int arg0) {	
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int arg0) {
		switch (arg0) {
			case 0:
				return "First Name";
			case 1:
				return "Last Name";
			}
			return "";
	}

	@Override
	public int getRowCount() {	
		return bank.getNumOfCustomers();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		Customer customer = bank.getCustomer(arg0);
		
		switch (arg1) {
			case 0:
				return customer.getFirstName();
			case 1:
				return customer.getLastName();
		}
		return "";
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
