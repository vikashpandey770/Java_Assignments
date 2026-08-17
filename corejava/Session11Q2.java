import java.util.Scanner;

class ProDuct{
	private String productName;
	private double price;
	private double discount;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	 double getFinalPrice(double price) {
		this.price=price;
		double discount=price*10/100;
		double finalprice= price-discount;
		System.out.println("your main price is:"+price);
		System.out.println("applied discount is :10%");
		System.out.println("after discount price: "+finalprice);
		return finalprice;
		
	}
	
}

public class Session11Q2 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a product name is: ");
		String productName=sc.next();
		
		System.out.println("enter a price: ");
		double price=sc.nextDouble();
		
		System.out.println("Enter a discount:");
		double discount=sc.nextDouble();
		
		ProDuct pd=new ProDuct();
		pd.setProductName(productName);
		pd.setPrice(price);
		pd.setDiscount(discount);
		pd.getFinalPrice(price);
		
	}
}
