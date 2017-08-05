package com.mybank.gui;

import javax.swing.JTable;

import com.mybank.domain.Bank;

public class MyTable extends JTable {
	
	public MyTable(Bank items) {
		super(new MyTableModel(items));
	}
}
