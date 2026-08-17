import java.util.Scanner;

public class Session14Q3 {

	public static void main(String[] args) throws OutOfStockException, InsufficientFundsException {
		boolean available = false;
		int order,fund;
		
		System.out.println("-----Zomato order flow--------");
		
	try {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a Wallet balance:");
		 fund=sc.nextInt();
		
		System.out.print("Enter a Dish name:");
		String sr=sc.next();
		
		System.out.print("Enter a order amount :");
		order=sc.nextInt();
		
		if(!available) {
			throw new OutOfStockException();
		}
		else if(order>fund) {
			throw new InsufficientFundsException();
			
		}
		else if(order<0) {
			throw new IllegalArgumentException();
		}
		
		else {
			System.out.println("ok order place");
		}
	}
	catch(OutOfStockException e) {
		System.out.println("not availabel this dish:"+e);
	}
	catch(InsufficientFundsException e) {
		System.out.println("your order value is high not availabel your fund "+e);
	}
	catch(IllegalArgumentException e) {
		System.out.println("value is less than zero , please positive value insert"+e);
		
	}
	finally {
		System.out.println("ok complete the zomato order program");
	}
	
		
		
		
		
	
}
		
	}

