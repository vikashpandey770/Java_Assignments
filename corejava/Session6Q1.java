import java.util.Scanner;

public class Session6Q1 {
	String productName;
	double price;
	
	public void product(String pr,double p) {
		productName=pr;
		price=p;
		
	}
	
	void print() {
		System.out.println("product name is:"+productName);
		System.out.println("price is :"+price);
		
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Product name: ");
		String productName=sc.nextLine();
		
		System.out.println("enter price :");
		int price=sc.nextInt();
		
		Session6Q1 s=new Session6Q1();
		s.product(productName, price);
		s.print();
		
	}
}
