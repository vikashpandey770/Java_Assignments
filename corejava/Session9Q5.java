import java.util.Scanner;

class Productt{
	
	String name;
	Productt(String name){
	this.name=name;
		System.out.println("your name is : "+name);
		
	}
}

public class Session9Q5 {

	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
System.out.println("enter a name here: ");
String name=sc.next();

		Productt pr=new Productt(name);
		
	}
}
