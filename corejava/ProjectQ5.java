import java.util.ArrayList;

class UserAAccounnt{
	
	int balance=0;

	ArrayList<String> transaction=new ArrayList<>();
	
	public void addfund(int amount) {
		
		balance=balance+amount;
	
		transaction.add("add amount :"+amount);
		System.out.println("current transaction :"+transaction.get(transaction.size()-1));
		System.out.println("update total balance: "+balance);
	
	
	}
	
	
	public void spendfund(int price) {
		
		if(price<=balance) {
			
			balance=balance-price;
			
			transaction.add("add spend price: "+price);
			
			System.out.println("transaction: "+transaction.get(transaction.size()-1));
			System.out.println("balance :"+balance);
		}
		
	}
	
}

public class ProjectQ5 {

	public static void main(String[] args) {
		
		UserAAccounnt uac=new UserAAccounnt();
		uac.addfund(100);
		uac.addfund(1500);
		System.out.println("--------------------spend amout---------------------");
		uac.spendfund(500);
		
		
	}
}
