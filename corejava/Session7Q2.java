
class MovieTicketss{
	int price;
	static int totalTicket;
	
	public void bookTicket(int price) {
	totalTicket++;
	System.out.println("price is : "+price);
		
		
	}
	public void checkTotalTickets() {
		System.out.println("your total ticket is: "+totalTicket);
	
	}
	
}

public class Session7Q2 {

	public static void main(String[] args) {
		
		MovieTicketss m=new MovieTicketss();
		m.bookTicket(250);
		m.checkTotalTickets();
		MovieTicketss m1=new MovieTicketss();
		m.bookTicket(500);
		m.checkTotalTickets();
		
	}
}

