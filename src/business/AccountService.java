package business;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

import model.Account;

import data.AccountRepository;

public class AccountService {
	private static Scanner scanner = new Scanner (System.in);
	
	private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	
	public static void depositMoney() throws IOException {
		
		System.out.print("Which account number would you like to deposit money into?: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println();
		
		System.out.print("How much would you like to deposit?: ");
	
		boolean isValid = false;
		double number = 0;
		
		while(!isValid) {
			try {
				number = Double.parseDouble(scanner.nextLine());
				number = Math.floor(number * 100) / 100;
				isValid = true;
			}
			catch (NumberFormatException numberFormatException) {
				System.out.println("Invalid value. Please enter a number.");
				System.out.println();
				System.out.print("Re-enter amount: ");
				
			}
		}
		
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber);
		account = AccountRepository.updateAccountBalanceByAccount(account, number);
		
		//System.out.println("Balance: " + currencyFormatter.format(account.getBalance()));
		
		System.out.println();
		System.out.println("Balance: " + currencyFormatter.format(account.getBalance()));
		System.out.println();
	}
	
	public static void withdrawMoney() throws FileNotFoundException {
		
		System.out.print("Enter account number: ");
		
		int accountNumber = scanner.nextInt();
		
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber);
		
		System.out.println();
		
		System.out.print("Enter withdraw amount: ");
		
		boolean isValid = false;
		
		while(!isValid) {
			try {
				double withdrawAmount = scanner.nextDouble();
				
				if(account.getBalance() > withdrawAmount) {
					account = AccountRepository.updateAccountBalanceByAccount(account, - withdrawAmount);
					isValid = true;
				}
				
			    else {
					System.out.println("Not enough money in account");
					System.out.println();
					System.out.print("Enter a valid amount: ");
					continue;
				}
				
			}
			catch (Exception e) {
			System.out.println("Invalid amount.");
			System.out.println();
			System.out.print("Enter a valid amount: ");
			
		}
			System.out.println();	
			System.out.println("Balance: " + currencyFormatter.format(account.getBalance()));
		System.out.println();
	
	}
	
}
	public static void checkBalance() throws FileNotFoundException {
		
		System.out.print("Enter account number: ");
		
		int accountNumber = scanner.nextInt();
		
		Account account = AccountRepository.getAccountByAccountNumber(accountNumber);
		
		System.out.println("Balance: " + currencyFormatter.format(account.getBalance()));
	
		
		System.out.println();
		
	}
}
