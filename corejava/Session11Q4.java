import java.util.Scanner;

interface Searchable{

	void search(String keyword);
}

class MovieLibrary implements Searchable{

	@Override
	public void search(String keyword) {
		// TODO Auto-generated method stub
	String name[]= {"welcome","DC","dhurandhar-2","baggi"};
	
	
	
	for (String movie : name) {
	    if (movie.toLowerCase().contains(keyword.toLowerCase())) {
	        System.out.println(movie);
	    }
	}
	}	
}
public class Session11Q4 {

	public static void main(String[] args) {
		
		MovieLibrary ml=new MovieLibrary();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a keyword: ");
		String name=sc.next();
		ml.search(name);
		
	}
}
