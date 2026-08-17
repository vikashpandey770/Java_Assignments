import java.util.Scanner;

public class Session4Q3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String music;
		do {
			
			System.out.println("Enter your artist name:");
			
			 music=sc.next();
		}
		while(!music.equalsIgnoreCase("Exit"));
		
	}
}
