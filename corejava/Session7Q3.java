import java.util.Scanner;

class FoodOrder{
	
	public void addItem(String itemName) {
		
		System.out.println("item name :"+itemName);
	}
	public void getOrderSummary() {
		
		System.out.println("your order is preparing now.....");
		System.out.println("you will add and modify your order and please message now.....");
	}
}
public class Session7Q3 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter  a item  name : ");
		String itemName=sc.next();
		
		FoodOrder f=new FoodOrder();
		f.addItem(itemName);
		f.getOrderSummary();
	}
	
}
