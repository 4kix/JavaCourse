package com.mybank.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.mybank.domain.*;

public class DataSource {

	private File dataFile;
	
	public DataSource(String dataFilePath) {
		dataFile = new File(dataFilePath);
	}
	
	public void loadData() throws IOException {
		Scanner input = new Scanner(dataFile);
		Customer customer;
		int numOfCustomers = input.nextInt();
		for (int i = 0; i < numOfCustomers; i++) {
			String firstName = input.next();
			String lastName = input.next();
			Bank.addCustomer(firstName, lastName);
			customer = Bank.getCustomer(i);
			
			int numOfAccounts = input.nextInt();
			while (numOfAccounts-- > 0) {
				char accountType = input.next().charAt(0);
				switch (accountType) {
				case 'S': {
					float initBalance = input.nextFloat();
					float interestRate = input.nextFloat();
					customer.addAccount(new SavingsAccount(initBalance, interestRate));
					break;
				}
				case 'C' :{
					float initBalance = input.nextFloat();
					float overdraftProtection = input.nextFloat();
					customer.addAccount(new CheckingAccount(initBalance, overdraftProtection));
					break;
				}
				}
			}
		}
	
	}
}
