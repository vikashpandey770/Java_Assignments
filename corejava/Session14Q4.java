import java.util.Scanner;

public class Session14Q4 {

	public static void main(String[] args) {
		System.out.println("------------Ticket Booking System-----------");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter a Balance: ");
		try {
		int balance=sc.nextInt();
		
		System.out.println("Enter a Ticket Amount: ");
		int ticket=sc.nextInt();
		
		if(ticket>balance) {
			throw new InsufficientFundsException();
		}
		else {
			System.out.println("Booking Successfully");
			
		}
		
		}
		catch(InsufficientFundsException e) {
			System.out.println("fund not availabel "+e);
		}
		finally {
			System.out.println("ok clear the pgogram");
		}
		
		
	}
}
