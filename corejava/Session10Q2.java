
class PaymentMethodd{
	
	public void topUp() {
		
		System.out.println("payment to topup");
	}
}

class CardPaymentt extends PaymentMethodd{
public	void topUp() {
	System.out.print(" Card Upi ");	
	}
}

class UpiPaymentt extends PaymentMethodd{
	public void topUp() {
		System.out.print(" Upi Payment ");
	}
}

class CryptoPaymentt extends PaymentMethodd{
	public void topUp() {
		
		System.out.print("Crypto Upi");
		
	}
}
public class Session10Q2 {
	public static void processWalletTopup(PaymentMethodd method, double amount) {
		System.out.println("amount:"+amount);
		method.topUp();
	}
	
	public static void main(String[] args) {
		
		
		CryptoPaymentt cp=new CryptoPaymentt();
		UpiPaymentt up=new UpiPaymentt();
		CardPaymentt ctp=new CardPaymentt();
		
		up.topUp();
		cp.topUp();
		ctp.topUp();
		processWalletTopup(up, 400);
		processWalletTopup(ctp, 500);
		processWalletTopup(cp,1500);
	}
}
