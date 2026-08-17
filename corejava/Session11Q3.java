import java.util.Scanner;

abstract class UPITransaction{
	double amount;
	
	abstract void processTransaction(double amount);

}

class PaytmTransaction extends UPITransaction{


	void processTransaction(double amount) {
		this.amount=amount;
		System.out.println("this is paytm transaction amount is : "+amount);
		
	}
}
class PhonePeTransaction extends UPITransaction{
	
	void processTransaction(double amount) {
		this.amount=amount;
		
		System.out.println("this is a phone pay upi transactions : "+amount);
	}
}

public class Session11Q3 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a amount : ");
		double amount=sc.nextDouble();
		
		PaytmTransaction p=new PaytmTransaction();
		p.processTransaction(amount);

		
		PhonePeTransaction pnt=new PhonePeTransaction();
		pnt.processTransaction(amount);
	
	
		};
		
	

}
