import java.util.Scanner;

public class Session12Q2 {

	public static void main(String[] args) {
		System.out.println("-----------Song Comparison program--------");
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("enter a first song title :");
		String song1=sc.nextLine();
		
		System.out.print("Enter a Second song title :");
		String songT=sc.nextLine();
		
		System.out.println("Song one :"+song1);
		System.out.println("Song two :"+songT);
		
		int s=song1.compareTo(songT);
		if(s==0) {
			System.out.println("both song are same");
		}
		else {
			System.out.println("Not same song");
			
		}
	}
}
