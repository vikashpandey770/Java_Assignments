import java.util.ArrayList;

class UserAAccount{
	
	int balance=0;

	ArrayList<String> transaction=new ArrayList<>();
	
	public void addfund(int amount) {
		
		balance=balance+amount;
	
		transaction.add("add amount :"+amount);
		System.out.println("current transaction :"+transaction.get(transaction.size()-1));
		System.out.println("update total balance: "+balance);
	
	
	}
}
public class ProjectQ4 {

	public static void main(String[] args) {
	
		UserAAccount ua=new UserAAccount();
		ua.addfund(1500);
		ua.addfund(400);
	}
}
