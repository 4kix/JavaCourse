package com.mybank.domain;
public class CheckingAccount extends Account {
		
	private double overdraftAmount;
	
	public CheckingAccount(double initBalance, double overdraft) {
		super(initBalance);
		overdraftAmount = overdraft;
	}
	
	public CheckingAccount(double initBalance) {
		this(initBalance, 0.0);
	}
	
	@Override
	public void withdraw(double amount) throws OverdraftException {
		boolean result = true;
		if (balance < amount) {
			double overdraftNeeded = amount - balance;
			if (overdraftAmount < overdraftNeeded) {
				throw new OverdraftException("Insufficent funds for overdraft protection", overdraftNeeded);
			} else {
				balance = 0.0;
				overdraftAmount -=amount;
			}
		} else {
			balance -= amount;
		}
		
	}
	
}
