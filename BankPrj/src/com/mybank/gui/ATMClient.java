package com.mybank.gui;

import com.mybank.domain.*;

//import javafx.scene.control.ComboBox;

import com.mybank.data.*;
import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ATMClient {

  private static final String USAGE
    = "USAGE: java com.mybank.gui.ATMClient <dataFilePath>";

  public static void main(String[] args) {

    // Retrieve the dataFilePath command-line argument
    if ( args.length != 1 ) {
      System.out.println(USAGE);
    } else {
      String dataFilePath = args[0];

      try {
	System.out.println("Reading data file: " + dataFilePath);
	
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();

	// Run the ATM GUI
	ATMClient client = new ATMClient();
	client.launchFrame();

      } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    }
  }

  private JTextField message;
  private JTextField dataEntry;
  private JTextArea output;
  
  private JButton btn1;
  private JButton btn2;
  private JButton btn3;
  private JButton btn4;
  private JButton btn5;
  private JButton btn6;
  private JButton btn7;
  private JButton btn8;
  private JButton btn9;
  private JButton btn0;
  private JButton btnPoint;
  private JButton btnEnter;
  private JButton btnBalance;
  private JButton btnDeposit;
  private JButton btnWithdrawal;
  
  public ATMClient() {
		message = new JTextField(75);
		dataEntry = new JTextField(10);
		output = new JTextArea(10,75);
		output.setEnabled(false);;
		dataEntry.setEnabled(false);
		
		btn1 = new JButton("1");
		btn2 = new JButton("2");
		btn3 = new JButton("3");
		btn4 = new JButton("4");
		btn5 = new JButton("5");
		btn6 = new JButton("6");
		btn7 = new JButton("7");
		btn8 = new JButton("8");
		btn9 = new JButton("9");
		btn0 = new JButton("0");
		btnPoint = new JButton(".");
		btnEnter = new JButton("Enter");
		btnBalance = new JButton("Display account balance");
		btnDeposit = new JButton("Make a deposit");
		btnWithdrawal = new JButton("Make a withdrawal");
		
		
	}
  
  public void launchFrame() {
	  
	  JFrame frame = new JFrame("Bank ATM");
		
		frame.setLayout(new BorderLayout());
		
		JPanel keyPadPanel = new JPanel();
		JPanel actionButtonPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		JPanel fieldsPanel = new JPanel();
		
	
		JTable table = new MyTable(new Bank());
		
		JComboBox comboBox = new MyComboBox(new Bank());
		

		controlPanel.setLayout(new BorderLayout());
		fieldsPanel.setLayout(new BoxLayout(fieldsPanel, BoxLayout.Y_AXIS));
		
		keyPadPanel.setLayout(new GridLayout(4, 3));
		keyPadPanel.add(btn1);
		keyPadPanel.add(btn2);
		keyPadPanel.add(btn3);
		keyPadPanel.add(btn4);
		keyPadPanel.add(btn5);
		keyPadPanel.add(btn6);
		keyPadPanel.add(btn7);
		keyPadPanel.add(btn8);
		keyPadPanel.add(btn9);
		keyPadPanel.add(btn0);
		keyPadPanel.add(btnPoint);
		keyPadPanel.add(btnEnter);
		
		actionButtonPanel.setLayout(new GridLayout(3, 1));
		actionButtonPanel.add(btnBalance);
		actionButtonPanel.add(btnDeposit);
		actionButtonPanel.add(btnWithdrawal);
		
		controlPanel.add(actionButtonPanel, BorderLayout.NORTH);
		controlPanel.add(dataEntry, BorderLayout.CENTER);
		controlPanel.add(keyPadPanel, BorderLayout.SOUTH);
		
		fieldsPanel.add(output);
		fieldsPanel.add(comboBox);
		fieldsPanel.add(table);
		fieldsPanel.add(message);
		
		frame.add(controlPanel, BorderLayout.WEST);
		frame.add(fieldsPanel, BorderLayout.EAST);
		frame.pack();
		frame.setVisible(true);

	
		
  }
  
  
}
