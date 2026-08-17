import java.util.Scanner;

class Registration{

public void registerUser(String email) {
	
	System.out.println("your email is: "+email);
}

public void registerUser(String email,int password) {
	System.out.println("your email is : "+email);
	System.out.println("your password is : "+password);
}
public void registerUser(String email,int password,long phonenumber) {
	System.out.println("your email id is : "+email+" and your password is : "+password+" and contact number is : "+phonenumber);
	
}
	

}

public class Session8Q5 {

	public static void main(String[] args) {
		
		Registration rs=new Registration();
		
		Scanner sc=new Scanner(System.in);
		try {
		System.out.println("Enter your email id: ");
		String email=sc.next();
		
		System.out.println("Enter your password: ");
		int password=sc.nextInt();
		
		System.out.println("Enter your contact number : ");
		long phonenumber=sc.nextLong();
		
		
		rs.registerUser(email);
		rs.registerUser(email, password);
		rs.registerUser(email, password, phonenumber);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error please right input");
		}
		finally {
			System.out.println("ok complete close");
		}
		
	}
}
