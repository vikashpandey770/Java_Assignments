import java.util.Scanner;

class Playylist{

	 String name,description;
	public Playylist() {

		this("","");
		System.out.println("this is a default");
	}
	public Playylist(String name) {

		
		this(name,"");
		System.out.println("name is ;"+name);
	}
	public Playylist(String name,String description) {
		
		this.name =name;
		this.description=description;
		System.out.println("name is :"+name);
		System.out.println("description is : "+description);
	}
	

}
public class Session8Q4 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a name: ");
		String name=sc.next();
		
		System.out.println("enter a description :");
		String description=sc.next();
		
		Playylist py=new Playylist();
		Playylist p1=new Playylist(name);
		Playylist p2=new Playylist(name, description);
		
		
	}
}
