import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
public class Functions {
    // Establishes a connection to the PostgreSQL server.
    public Connection getConnection() throws Exception {
        String url = "jdbc:postgresql://localhost:5432/A3_Q1";
        String username = "postgres";
        String password = "TheAtaraxia";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    // Closes the connection to the PostgreSQL server.
    public void closeConnection(Connection connection) throws Exception {
        connection.close();
    }
    // Retrieves and displays all records from the students table.
    public void getAllStudents(Connection connection) throws Exception {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
        // Continue to print the records until there are no more records in the result set.
        while (resultSet.next()) {
            System.out.println(resultSet.getString("student_id") + " | " + resultSet.getString("first_name") + " " + resultSet.getString("last_name") + " | " + resultSet.getString("email") + " | " + resultSet.getString("enrollment_date"));
        }
        resultSet.close();
        statement.close();
    }
    // Inserts a new student record into the students table.
    public void addStudent(Connection connection, String first_name, String last_name, String email, String enrollment_date) throws Exception {
        Statement statement = connection.createStatement();
        // Convert the enrollment_date string to a LocalDate object.
        LocalDate ed = LocalDate.parse(enrollment_date);
        statement.executeUpdate("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + ed + "')");
    }
    // Updates the email address for a student with the specified student_id.
    public void updateStudentEmail(Connection connection, int student_id, String new_email) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id);
        statement.close();
    }
    // Deletes the record of the student with the specified student_id.
    public void deleteStudent(Connection connection, int student_id) throws Exception {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM students WHERE student_id = " + student_id);
        statement.close();
    }


}
