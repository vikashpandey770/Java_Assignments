import java.util.Scanner;

class OutOfStockException extends Exception {
	 public OutOfStockException() {

		 System.out.println("not availabe");
	}
	
	public void shows() {
		int stock;
		
	}
	
}

public class Session14Q1 {

	public static void main(String[] args) throws OutOfStockException {
	Scanner sc=new Scanner (System.in);
	
	try {
	System.out.println("Enter a stock quantity: ");
	int stock=sc.nextInt();
		
	
	if(stock<100 && stock>0) {
		System.out.println("yes availabel the stock");
	}
	
	else {
		throw new OutOfStockException();
	}
	}catch(OutOfStockException e) {
		System.out.println("not available this stock quantity");
	}
	finally {
		System.out.println("ok close the program");
	}
	}
}
