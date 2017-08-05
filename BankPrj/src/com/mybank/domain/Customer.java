package com.mybank.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Account account;
	private List<Account> accounts;
	private int numberOfAccounts;
	
	Customer(String f, String l) {
		firstName = f;
		lastName = l;
		accounts = new ArrayList<Account>(30);
		//numberOfAccounts = 0;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public void setAccount(Account acct) {
		account = acct;
	}
	
	public void addAccount(Account acct) {
		accounts.add(acct);
	}
	
	public Account getAccount(int index) {
		return accounts.get(index);
	}
	
	public int getNumOfAccounts() {
		return accounts.size();
	}
	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
