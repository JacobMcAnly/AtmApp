import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import business.AccountService;

public class AtmAppV2 {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		boolean moreActions = true;
		
		while(moreActions) {
			System.out.print("Select (1) for deposit, (2) for withdraw, (3) for balance, (4) EXIT: ");
			int userInput = scanner.nextInt();
			System.out.println();
		
		switch (userInput) {
			case 1: {
				AccountService.depositMoney();
				break;
			}
			case 2: {
				AccountService.withdrawMoney();
				break;
			}
			case 3: {
				AccountService.checkBalance();
				break;
				
			}
			case 4: {
				moreActions = false;
				System.out.println("Have a great day!");
				break;
			}
			default: {
				break;
				
			}
		}
		
		}

	}

}
