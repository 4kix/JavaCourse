package com.mybank.gui;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

import com.mybank.domain.Bank;

public class MyComboBoxModel extends DefaultComboBoxModel {
	
	private Bank bank;
	public MyComboBoxModel(Bank bnk) {
		super();
		bank = bnk;	
		}

	@Override
	public Object getElementAt(int arg0) {
		return bank.getCustomer(arg0);
	}

	@Override
	public int getSize() {
		return bank.getNumOfCustomers();
	}


}
