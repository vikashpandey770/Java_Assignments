package Section_B;

class Menuitem{
	
	private int itemid;
	private String name;
	private double price;
	private boolean isAvailabel;
	
	public Menuitem() {
		this.isAvailabel=false;
		this.price=0.0;
		
		
	}
	
	public Menuitem(int itemid, String name, double price, boolean isAvailabel) {
		super();
		this.itemid = itemid;
		this.name = name;
		this.price = price;
		this.isAvailabel = isAvailabel;
	}
	public int getItemid() {
		return itemid;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	public boolean isAvailabel() {
		return isAvailabel;
	}
	
	
	public void setPrice(double price) {
		this.price = price;
	}
	public void setAvailabel(boolean isAvailabel) {
		this.isAvailabel = isAvailabel;
	}
	
	
	

	public void display() {
		if(isAvailabel) {
			System.out.println("item id:"+itemid +"name : "+name+ "price : "+price+ "availabel : "+isAvailabel);
		}
		else {
			
			System.out.println("item id: "+itemid+" name : "+name+" [ unavailabel ]"+"price : " +price+ "available : no ");
			
		}
		
		
	}
	
	
}


public class Task_1 {

	public static void main(String[] args) {
		Menuitem m=new Menuitem(1,"vikash", 1500, false);
		
		m.display();
		
	}
	
}
