import java.util.Scanner;

class PaymentMethod{
	
	public void topUp(double amount) {
		
		System.out.println("this is a payment method class:"+amount);
	}
}

class CardPayment extends PaymentMethod{
public void topUp(double amount) {
		
	System.out.println("this is a card payment class: "+amount);
	}
	
}
class UpiPayment extends PaymentMethod{
public void topUp(double amount) {
System.out.println("this is a upi payment class : "+amount);
	}	
}
class CryptoPayment extends PaymentMethod{
public void topUp(double amount) {
	System.out.println("this is a crypto payment class :"+amount);
	}
	
}


public class Session10Q1 {

	public static void main(String[] args) {
		
		CryptoPayment cp=new CryptoPayment();
		PaymentMethod pm=new PaymentMethod();
		CardPayment cy=new CardPayment();
		UpiPayment up=new UpiPayment();
		
		Scanner sc=new  Scanner(System.in);
		System.out.println("enter a amount : ");
	double amount=sc.nextDouble();
	
		cp.topUp(amount);
		cy.topUp(amount);
		up.topUp(amount);
		pm.topUp(amount);

		
		
	}
}
