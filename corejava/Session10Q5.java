
class CardPAYMENT{
	
	 int amount;

	void topup(int amount) {
		this.amount=amount;
		if(amount>1000) {
			System.out.println("you are get a cashback offer");
		}
		
	}
}
public class Session10Q5 {

	public static void main(String[] args) {
		
		CardPAYMENT cm=new CardPAYMENT();
		cm.topup(1500);
	}
}
