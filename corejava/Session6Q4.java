import java.util.Scanner;

class MovieTicket {
String movieTitle;
String seatNumber;
public MovieTicket(String movieTitle, String seatNumber) {
	super();
	this.movieTitle = movieTitle;
	this.seatNumber = seatNumber;
}

void printTicket() {
	
	System.out.println("Enter a movie title: "+movieTitle);
	System.out.println("Enter a seat number : "+seatNumber);
	
}

}

public class Session6Q4 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a movie title :");
		String movieTitle =sc.nextLine();
		
		System.out.println("Enter a seat number : ");
		String seatNumber = sc.nextLine();
		
		MovieTicket m=new MovieTicket(movieTitle, seatNumber);
		m.printTicket();
		
	}
}
