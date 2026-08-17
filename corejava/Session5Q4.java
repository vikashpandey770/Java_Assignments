
public class Session5Q4 {
	
public static void main(String[] args) {


	        char[][] seats = {
	                {'B', 'B', 'B', 'B', 'B', 'A'},
	                {'B', 'A', 'A', 'B', 'B', 'A'},
	                {'B', 'B', 'B', 'A', 'B', 'B'},
	                {'B', 'B', 'A', 'A', 'B', 'A'},
	                {'B', 'B', 'B', 'B', 'B', 'A'}
	        };

	        int availableSeats = 0;

	        System.out.println("Seat Layout:");

	        for (int i = 0; i < seats.length; i++) {
	            for (int j = 0; j < seats[i].length; j++) {

	                System.out.print(seats[i][j] + " ");

	                if (seats[i][j] == 'A') {
	                    availableSeats++;
	                }
	            }
	            System.out.println();
	        }

	        System.out.println("\nTotal Available Seats = " + availableSeats);
	    }
	

	
}
