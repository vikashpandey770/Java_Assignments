import java.util.Scanner;

public class Session3Q4 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a total cart value: ");
		int value=sc.nextInt();
		
		if(value>=500) {
			System.out.println("Eligible for free Delivery");
		}
		else if(value > 0 || 500 < value){
			System.out.println("Add more items for free Delivery");
		}
		else {
			System.out.println("add right value");
		}
	}
}
