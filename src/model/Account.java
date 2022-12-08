package model;

import java.text.NumberFormat;

public class Account {
	
	private int accountNumber;
	private double balance; 
	
	public Account () {
		accountNumber = 0;
		balance = 0;
	}
	
	public Account (int passedInAccountNumber, Double passedInBalance) {
		accountNumber = passedInAccountNumber;
		balance = passedInBalance;
	}
	
	public int getAccountNumber() {
		return this.accountNumber;
	}
	
	public void setAccountNumber(int passedInAccountNumber) {
		this.accountNumber = passedInAccountNumber;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void setBalance (double passedInBalance) {
		this.balance = passedInBalance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", balance=" + balance + "]";
	}
	
	
}