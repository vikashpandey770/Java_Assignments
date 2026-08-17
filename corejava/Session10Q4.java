import java.util.Scanner;

class PayTM{
	void money(int a) {
		System.out.println("money a:"+a);
	}
	void money(int a,int b) {
		System.out.println("your money is :"+a+" your availabel balance is : "+b);
	}
	void money(int a,int b,String c) {
		System.out.println("your name is :"+c+" your money is : "+a+" and your availabel balacce is : "+b);
	}
}
public class Session10Q4 {

	public static void main(String[] args) {
		
		PayTM p=new PayTM();
		Scanner sc=new Scanner(System.in);
		System.out.println("entear A:");
		int a=sc.nextInt();
		
		System.out.println("enter B: ");
		int b=sc.nextInt();
		
		System.out.println("enter name : ");
		String c=sc.next();
		
		p.money(a);
		p.money(a, b);
		p.money(a, b, c);	
	}
}
/*
 java method overriding ke andar different different class k andar same name 
 k method banega like har class
  exted hogi child parent aur sabhi k ander same name and same paramerer ka method banega
 
 */ 
