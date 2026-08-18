package Jdbcquestion;

public class Session1Q4 {

	public static void main(String[] args) {
		System.out.println("Java Application → DriverManager → Connection → Statement → MySQL Database");
		System.out.print("┌──────────────────────────────┐\r\n"
				+ "│       Java Application       │\r\n"
				+ "│                              │\r\n"
				+ "│   Class.forName(...)         │\r\n"
				+ "│   DriverManager              │\r\n"
				+ "└──────────────┬───────────────┘\r\n"
				+ "               │\r\n"
				+ "               │ getConnection()\r\n"
				+ "               ▼\r\n"
				+ "┌──────────────────────────────┐\r\n"
				+ "│      DriverManager           │\r\n"
				+ "│                              │\r\n"
				+ "│  Creates database connection │\r\n"
				+ "└──────────────┬───────────────┘\r\n"
				+ "               │\r\n"
				+ "               │ Connection\r\n"
				+ "               ▼\r\n"
				+ "┌──────────────────────────────┐\r\n"
				+ "│         Connection           │\r\n"
				+ "│                              │\r\n"
				+ "│  Represents connection       │\r\n"
				+ "│  with MySQL database         │\r\n"
				+ "└──────────────┬───────────────┘\r\n"
				+ "               │\r\n"
				+ "               │ createStatement()\r\n"
				+ "               ▼\r\n"
				+ "┌──────────────────────────────┐\r\n"
				+ "│          Statement           │\r\n"
				+ "│                              │\r\n"
				+ "│  Executes SQL queries        │\r\n"
				+ "│  SELECT / INSERT / UPDATE    │\r\n"
				+ "└──────────────┬───────────────┘\r\n"
				+ "               │\r\n"
				+ "               │ SQL Query\r\n"
				+ "               ▼\r\n"
				+ "┌──────────────────────────────┐\r\n"
				+ "│       MySQL Database         │\r\n"
				+ "│                              │\r\n"
				+ "│      Tables + Data           │\r\n"
				+ "└──────────────────────────────┘");
		
	}
}
