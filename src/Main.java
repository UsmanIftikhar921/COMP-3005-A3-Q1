import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/A3_Q1";
        String username = "postgres";
        String password = "TheAtaraxia";

        try {
            // Connect to the database
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Do Functions Here
            getAllStudentsName(connection);

            // Disconnect from the database
            connection.close();
            System.out.println("Disconnected from the PostgreSQL server successfully.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Function That Retrieves and displays all records from the students table.
    public static void getAllStudentsName(Connection connection) {
        Statement statement = connection.createStatement();
        statement.executeQuery("SELECT * FROM students;");
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
        }
    }
}