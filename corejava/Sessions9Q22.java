import java.util.Scanner;

class FooodOrder {

    int orderAmount;
    int discount;

    int calculateTotal() {
        return orderAmount;
    }
}

class ZomatiGoldOrder extends FooodOrder {

    
    int calculateTotal() {

        int amount = super.calculateTotal();

        discount = amount * 10 / 100;

        int finalPrice = amount - discount;

        System.out.println("Order amount is: " + amount);
        System.out.println("10% discount is: " + discount);
        System.out.println("Final price is: " + finalPrice);

        return finalPrice;
    }
}

public class Sessions9Q22 {
public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);

     System.out.println("Enter an order amount:");
     int orderAmount = sc.nextInt();

     ZomatiGoldOrder z = new ZomatiGoldOrder();

     z.orderAmount = orderAmount;
     z.calculateTotal();
	
}
	
}
