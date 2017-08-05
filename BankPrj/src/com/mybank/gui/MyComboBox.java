package com.mybank.gui;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;

import com.mybank.domain.Bank;


public class MyComboBox extends JComboBox {

	public MyComboBox(Bank items) {
		super(new MyComboBoxModel(items));
	}
}
