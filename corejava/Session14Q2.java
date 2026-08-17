import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

class PaymentHandler{
	public PaymentHandler() {
		System.out.println("error provide");
	}
	public void processPayment() {
		int value;
		int balance;
	}
}
public class Session14Q2 {

	public static void main(String[] args){
		
		
		Scanner sc=new Scanner(System.in);
	
		try{
			System.out.println("Enter a balance: ");
		
		int balance=sc.nextInt();
		
		
		System.out.println("enter the debit amount: ");
		int value=sc.nextInt();
		if(value>balance) {
			throw new InsufficientFundsException();	
		}

		
		else {
			System.out.println("ok debit the amount");
		}
		}
		catch(InsufficientFundsException e) {
			System.out.println("error... right value insert :"+e);
		}
		
		catch(InputMismatchException n) {
			System.out.println("number formalt error: "+n);
		}
	}
	}