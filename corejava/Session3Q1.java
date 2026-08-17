import java.util.Scanner;

public class Session3Q1 {

	public static void main(String args[]) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a amount: ");
		int money=sc.nextInt();
		
		if(money<100) {
			System.out.println("Low Balance Warning");
		}
		else {
			System.out.println("Sufficient Balance");
		}
	}
}
