package javaBeans;

public class product {

	private String name,category;
	private int id, price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public product() {
		super();
		this.name = name;
		this.category = category;
		this.id = id;
		this.price = price;
	}
	
	
	
	
}
