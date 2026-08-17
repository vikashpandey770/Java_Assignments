import java.util.Scanner;

class Playlistt{
	private 	String name;
	private String owner;
	private int totalSongs;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getTotalSongs() {
		return totalSongs;
	}
	public void setTotalSongs(int totalSongs) {
		this.totalSongs = totalSongs;
	}
	
	
	public void print() {
		System.out.println("name : "+name);
		System.out.println("owner : "+owner);
		System.out.println("total songs :"+totalSongs);
		
	}
	
	
}
public class Session11Q1 {

	public static void main(String[] args) {
		
		Playlistt pt=new Playlistt();
		Scanner sc=new Scanner (System.in);
		
		System.out.println("enter a name: ");
		String name=sc.next();
		
		System.out.println("enter a owner name : ");
		String owner=sc.next();
		
		System.out.println("Enter a total songs : ");
		int totalSongs=sc.nextInt();
		
		pt.setName(name);
		pt.setOwner(owner);
		pt.setTotalSongs(totalSongs);
		pt.print();
	}
}
