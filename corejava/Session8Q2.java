import java.util.Scanner;

class Movie{
	
	void addReview(int rating) {
		
		System.out.println("rating is : "+rating);
		
	}
	void addReview(int rating , String comment) {
		System.out.println("rating is : "+rating);
		System.out.println("comment is : "+comment);
		
	}
	
}
public class Session8Q2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a movie rating : ");
		int rating =sc.nextInt();
		
		System.out.println("Enter a comment : ");
		String comment=sc.next();
		Movie m=new Movie();
		m.addReview(rating);
	System.out.println("*****************************");
		m.addReview(rating, comment);
		
		
	}
}
