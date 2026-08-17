import java.util.Scanner;

public class Session2Q4 {

	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a number:");
		int message=sc.nextInt();
		
		if(message==0) {
			System.out.println("no new message");
		}
		else if(message>0 || 10<=message) {
			System.out.println("Few Message");
		}
		else if(message>10) {
			System.out.println("To many message");
		}
		else {
			System.out.println("please valid input provide");
		}
	}
}