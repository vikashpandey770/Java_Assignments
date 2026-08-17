import java.util.Scanner;

class Songs{
	String title;
	String artist;

	public void done(String t,String a) {
		title=t;
		artist=a;
		System.out.println("your title is: "+title);
		System.out.println("your artist name is: "+artist);
	}
}
class PremiumSong extends Songs{
	boolean lyricsAccess;
	
}
public class Session9Q1 {
	public static void main(String[] args) {
		PremiumSong ps=new PremiumSong();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter title is: ");
		String title=sc.next();
		
		System.out.println("enter artist name : ");
		String artist=sc.next();
			
		ps.done(title, artist);
		
		
	}
}
