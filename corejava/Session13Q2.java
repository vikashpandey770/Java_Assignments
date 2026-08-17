import java.util.Scanner;

public class Session13Q2 {

	public static void wallet(int balance,int purchaseAmount) {
		
		if(purchaseAmount>balance) {
			throw new ArithmeticException();
			
		}
		else {
			System.out.println("ok you can buy this product");
			System.out.println("available for your wallet balance......");
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a Wallet Balance: ");
		int balance=sc.nextInt();
		
		System.out.println("Enter a Purchase product Amount: ");
		int purchaseAmount=sc.nextInt();
		
		
		
		try {
			wallet(balance,purchaseAmount);
		}
		catch(ArithmeticException e) {
			
			System.out.println("error");
		}
		finally {
			System.out.println("ok complete the program");
		}
		
	}
}
