import java.util.Scanner;

class CrudFlipkart{
	
	String productName;
	int productQuantity;
	double productprice;
	
	public void addProduct(String p,int pq,double pp) {
		
		productName=p;
		productQuantity=pq;
		productprice=pp;
		System.out.println("product name: "+productName);
		
	}
	
	public void delete() {
	System.out.println("product delete : "+productName);
	
	productName=null;
	productprice=0;
	productQuantity=0;
		
	}
	public void show() {
		System.out.println("product name :"+productName);
		System.out.println("product price : "+productprice);
		System.out.println("product quantity: "+productQuantity);
	}
}

public class Session7Q5 {

	public static void main(String[] args) {
		
		CrudFlipkart cf=new CrudFlipkart();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a product name: ");
		String productName=sc.next();
			
		System.out.println("Enter a product quantity: ");
		int productQuantity=sc.nextInt();
		
		System.out.println("Enter a price : ");
		double productprice=sc.nextDouble();
		
		CrudFlipkart c=new CrudFlipkart();
		c.addProduct(productName, productQuantity, productprice);
		
		c.show();
		c.delete();
		System.out.println("*****************************");
		c.show();
	}
}
