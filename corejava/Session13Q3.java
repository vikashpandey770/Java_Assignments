import java.util.Scanner;

class InsufficientFundsException extends Exception{
	
	void sendMoney(int amount){
	
		
	}
}

public class Session13Q3 {
	int send;

	public static void main(String[] args) throws InsufficientFundsException {
Scanner sc=new Scanner(System.in);
System.out.println("enter a balance: ");
int amount=sc.nextInt();
		
		System.out.println("Enter a Send money: ");
		int send=sc.nextInt();
try {
		if(send>amount) {
			throw new InsufficientFundsException();
		}
		else {
			System.out.println("ok payment succesfully Send...");
			System.out.println("send money:"+send);

			int sub=amount-send;
			System.out.println("available balance is :"+sub);
		}
}catch(InsufficientFundsException e) {
	System.out.println("error provide");
	System.out.println("Required more money");
}

		
	}
}
