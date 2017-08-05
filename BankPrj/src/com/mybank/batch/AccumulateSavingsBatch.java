package com.mybank.batch;

import com.mybank.domain.*;


public class AccumulateSavingsBatch {

	private Bank bank;
	
	public void doBatch() {
		
		for (int i=0 ; i<bank.getNumOfCustomers(); i++) {
			Customer customer = bank.getCustomer(i);
			for (int j = 0; j < customer.getNumOfAccounts(); j++) {
				Account account = customer.getAccount(j);
				if(account instanceof SavingsAccount) {
					((SavingsAccount) account).accumulateInterest();
				}
			}
		}
	}
	
	public void setBank(Bank bank) {
		this.bank = bank;
	}
}
