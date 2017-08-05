package com.mybank.domain;
public class SavingsAccount extends Account{
		private double interestRate;
		
		public SavingsAccount(double initBalance, double interestRate) {
			super(initBalance);
			this.interestRate = interestRate;
		}
		
		public void accumulateInterest() {
			this.balance = this.balance + (this.balance * (interestRate/12));
		}
}
