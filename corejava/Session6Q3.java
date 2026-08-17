import java.util.Scanner;

class CartItem{
	
	String itemName;
	int quantity;


public void increaseQuantity() {
	quantity = quantity+1;
	System.out.println("your total Quantity is : "+quantity);
	
}
}
public class Session6Q3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a Quantity : ");
		int quantity=sc.nextInt();

		CartItem  c=new CartItem();
		c.increaseQuantity();
		c.increaseQuantity();
	}
}
