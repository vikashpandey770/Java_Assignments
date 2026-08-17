import java.util.Scanner;

class Product{
	String name;
	int price;
	Product(){
		
		System.out.println("default");
	}
	
	public Product(String name, int price) {
		this.name = name;
		this.price = price;
		
	}

	public Product(Product p) {
		name=p.name;
		price=p.price;
	}
	
	public void display() {
		System.out.println("name is : "+name);
		System.out.println("price is : "+price);
	}
	
}

public class Session8Q1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a name: ");
		String name=sc.next();
		System.out.println("Enter a price :");
		int price=sc.nextInt();
		
		Product pr=new Product();
		Product pr1=new Product(name, price);
		Product pr2=new Product(pr1);
		pr.display();
		System.out.println("**************************");
		System.out.println("parameter");

		pr1.display();
		System.out.println("************************");
		System.out.println("copy");
		pr2.display();
		
		
	}
}
