import java.util.Scanner;

class Playlists{
	int s;
	public void addSong() {
		
		
		System.out.println("Song added to playlist");
		
s++;
	}
	public void checkSongCount() {
		
		System.out.println("Total number of songs added :"+s);
		

	}

}

public class Session7Q1 {

	public static void main(String[] args) {
	
		Playlists p=new Playlists();
		p.addSong();
		p.addSong();
		
		p.checkSongCount();
		
	}
}
