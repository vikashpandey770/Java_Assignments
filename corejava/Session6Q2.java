import java.util.Scanner;

class Playlist{
	String playlistName;
	int totalSongs;
	

public void displayInfo(String p,int t) {
	playlistName=p;
	totalSongs=t;
	
	
}

void prints() {
	System.out.println("play list name: "+playlistName);
	System.out.println("total songs :"+totalSongs);
	
}
}
public class Session6Q2 {

	public static void main(String[] args) {
		
		Playlist p=new Playlist();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a play list name : ");
		String playlistName=sc.nextLine();
		
		System.out.println("enter a total songs : ");
		int totalSongs=sc.nextInt();
		
		p.displayInfo(playlistName, totalSongs);
		p.prints();
	}
}
