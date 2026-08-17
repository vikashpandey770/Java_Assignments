
class PaymenTMethod{
	
	void topUp(double amount) {
		
		System.out.println("payment method amount is : "+amount);
	}
	
}

class CarDPayment extends PaymenTMethod{
	void topUp(double amount) {
		System.out.println("card payment amount is :"+amount);
	}
}

class UpIPayment extends PaymenTMethod{
	void topUp(double amount) {
		System.out.println("upi payment amount is :"+amount);
	}
}
class CryPtoPayment extends PaymenTMethod{
	
	void topUp(double amount) {
		System.out.println("crypto amount is : "+amount);
	}
}

public class Session10Q3 {

	public static void main(String[] args) {
		
		PaymenTMethod [] payments= {new CryPtoPayment(),new UpIPayment(), new CarDPayment()};
		for(PaymenTMethod payment: payments) {
			payment.topUp(400);
		}
		
	}
}
