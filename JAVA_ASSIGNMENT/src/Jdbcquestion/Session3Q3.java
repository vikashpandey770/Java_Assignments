package Jdbcquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class Cart{
	
	int cart_item_id;
	String product;
	int price;
	
	
	

	public int getCart_item_id() {
		return cart_item_id;
	}

	public void setCart_item_id(int cart_item_id) {
		this.cart_item_id = cart_item_id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	public static Connection  createConnection() {
		Connection conn=null;
		
		try {
			// driver load hua
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loadded....");
		// connection kiye database se
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/addsong","root","");
			
			if(conn.isClosed()) {
				System.out.println("not connected to databse");
			}
			else {
				System.out.println("connection success");
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	
	}
	
	// insert data ab krege
	
				public static void insert() {
					try {
						Cart apl=new Cart();
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter a product name: ");
						apl.setProduct(sc.next());
						
						System.out.println("Enter a  price : ");
						apl.setPrice(sc.nextInt());
						
						try {
							Connection conn=createConnection();
							String s="insert into cart_items(product,price)values(?,?)";
							
							PreparedStatement pst=conn.prepareStatement(s);
							pst.setString(1, apl.getProduct());
							pst.setInt(2,apl.getPrice());
							
							pst.executeUpdate();
							conn.close();
							
							
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
								
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
	
	
				// update the process.....
				
				public static void update() {
					Connection conn=createConnection();
					
					PreparedStatement pst=null;
					
					try {
						
						Cart apl=new Cart();
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter id for product ordr: ");
						int cart_item_id=sc.nextInt();
						
						
						String sql="select *from cart_items where cart_item_id=?";
						pst=conn.prepareStatement(sql);
						pst.setInt(1, cart_item_id);
						
						ResultSet rs=pst.executeQuery();
						if(rs.next()) {
							
							System.out.println("product name : "+rs.getString("product"));
							System.out.println(" price : "+rs.getInt("price"));

						}
						
						
						

						System.out.println("---- now Enter new Information to update ----");
						
						System.out.println("enter your product name: ");
						apl.setProduct(sc.next());

						System.out.println("Enter your price : ");
						apl.setPrice(sc.nextInt());
						
						
						String sq="update cart_items set product=?,price=? where cart_item_id=?";
						pst=conn.prepareStatement(sq);
						
						pst.setString(1, apl.getProduct());
						pst.setInt(2,apl.getPrice());
					pst.setInt(3, cart_item_id);
						pst.executeUpdate();
						
						System.out.println("update successfully");
						
						
						
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				// delete the data from id
				
				
				public static void delete() {
					Connection conn=createConnection();
					PreparedStatement pst=null;
					
					try {
						Cart s=new Cart();
						Scanner sc=new Scanner(System.in);
						System.out.println("Enter id for Student Delete Data : ");
						int cart_item_id=sc.nextInt();
						String sql1="delete from cart_items where cart_item_id=?";
						
						pst=conn.prepareStatement(sql1);
						pst.setInt(1, cart_item_id);
						pst.executeUpdate();
						
						System.out.println("data deleted successfully");
					}
					
					catch(Exception e) {
						e.printStackTrace();
					}
					
				}
				
				
				
				

}

public class Session3Q3 {

	public static void main(String[] args) {
	 Cart ct=new Cart();
	 ct.createConnection();
	 //ct.insert();
	// ct.update();
	 ct.delete();
		
	}
}
