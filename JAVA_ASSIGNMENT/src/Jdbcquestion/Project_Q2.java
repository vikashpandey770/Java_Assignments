package Jdbcquestion;

class Expense{
	
	int id;
	int userid;
	int price;
	double amount;
	int date;
	int categoryid;
	String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Expense( int userid, int price, double amount, int date, int categoryid, String description) {
		super();
		this.userid = userid;
		this.price = price;
		this.amount = amount;
		this.date = date;
		this.categoryid = categoryid;
		this.description = description;
	}
}
public class Project_Q2 {
	public static void main(String[] args) {
		Expense e=new Expense(101, 500, 2500, 22, 1,"vikash");
		System.out.println("User id:"+e.getUserid());
		System.out.println("price: "+e.getPrice());
		System.out.println("amount: "+e.getAmount());
		System.out.println("date: "+e.getDate());
		System.out.println("category id :"+e.getCategoryid());
		System.out.println("description : "+e.getDescription());
	}
}
