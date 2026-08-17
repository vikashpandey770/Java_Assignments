import java.util.Scanner;

class CartItemm{
	
	 int productId;
	 int quantity;
	 
	 CartItemm(){
		 System.out.println("default");
	 }
	CartItemm(int productId){
	System.out.println("product id  is:"+productId);
		
	}
	CartItemm(int productId,int quantity){
		System.out.println("product id is : "+productId);
		System.out.println("quantity is :"+quantity);
		
		
	}
	CartItemm(CartItemm c){
		productId=c.productId;
		quantity=c.quantity;
		
		System.out.println("product id : "+productId);
		System.out.println("quantity:" +quantity);
		
	}
	
	
	
}

public class Session8Q3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a id: ");
		int id=sc.nextInt();
		
		System.out.println("enter a quantity");
		int quantity=sc.nextInt();
		
		CartItemm ci=new CartItemm();
		
		CartItemm c1=new CartItemm(id);
		
		CartItemm c2=new CartItemm(id, quantity);
		CartItemm c3=new CartItemm(c2);
		
		
	}
}
