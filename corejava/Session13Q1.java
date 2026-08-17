import java.util.Scanner;

public class Session13Q1 {
	
	public static void withdrawAmount(int balance,int amount) {
		
		if(balance<amount) {
			
			throw new ArithmeticException();
	}
		
		else {
			balance=balance-amount;
			System.out.println("withdraw success");
			System.out.println("availabel: "+ balance);
		}
	}
public static void main(String[] args)  {
	
	Scanner sc=new Scanner(System.in);

System.out.println("enter a balance:");
int balance=sc.nextInt();


System.out.println("enter a amount: ");
int amount=sc.nextInt();

	
try {
	withdrawAmount(balance, amount);
}
catch(ArithmeticException e) {
	System.out.println("error, wrong amount enter");
}
	
	
}
	
}
