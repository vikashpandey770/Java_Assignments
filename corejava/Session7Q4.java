import java.util.Scanner;

class InstaProfile{
	
String username;
int followers;

public void increseFollowers(int count) {
	
 followers =followers+count;
	System.out.println("your followers is : "+followers);
	
}
}

public class Session7Q4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a username: ");
		String username=sc.next();
		
		
		System.out.println("Enter a followers : ");
		int followers=sc.nextInt();
		
		
		
		
InstaProfile i=new InstaProfile();

i.username=username;
i.followers=followers;


System.out.println("enter a new followers : ");
int count=sc.nextInt();

i.increseFollowers(count);


		
	}
}
