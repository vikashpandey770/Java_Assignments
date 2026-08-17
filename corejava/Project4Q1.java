import java.util.Scanner;

class UserAccount{
	private String username;
	private String password;
	private int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
		System.out.println("balance is :"+balance);
	}
	
	
	UserAccount(String username,String password){
		this.username=username;
		this.password=password;
		System.out.println("username is : "+username);
		System.out.println("password is : "+password);
		
	}
	
	
}

public class Project4Q1 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a username :");
		String username=sc.next();
		
		System.out.println("Enter a password : ");
		String password=sc.next();
		UserAccount ua=new UserAccount(username, password);
			ua.setBalance(1500);	
	}
}
