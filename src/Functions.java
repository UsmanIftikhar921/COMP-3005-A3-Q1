import java.sql.Connection;
import java.sql.DriverManager;

// This Class Contains all the Application Functions
public class Functions {
    // Function to Connect to the Database
    public static void connectToDatabase() {
        String url = "jdbc:postgresql://localhost:5432/A3_Q1";
        String username = "postgres";
        String password = "TheAtaraxia";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Function That Retrieves and displays all records from the students table.
    public static void getAllStudents() {
        // Retrieve and display all records from the students table.

    }




}


