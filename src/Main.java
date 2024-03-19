import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Functions functions = new Functions();      // Contains the methods to perform CRUD operations on the students table.

        try {
            // Establish Connection to the PostgreSQL server.
            Connection connection = functions.getConnection();
            System.out.println("Connected to the PostgreSQL server successfully.");

            // Initialize a few variables we'll need later.
            int option = 1;
            String student_id_string;
            int student_id_int;

            // As long as the user doesn't choose to exit the program, keep asking for an option.
            while (option > 0 && option < 5){
                System.out.println(
                        "\n Choose an option: \n " +
                                "1: Display records of all students. \n " +
                                "2: Add a student. \n " +
                                "3: Update a student's email. \n " +
                                "4: Delete a student. \n " +
                                "0: Exit. \n "
                );

                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                option = Integer.valueOf(input);

                // Perform the selected operation.
                switch (option) {
                    // Display records of all students.
                    case 1:
                        functions.getAllStudents(connection);
                        break;
                    // Add a student.
                    case 2:
                        // Ask user to input the student's first name, last name, email, and enrollment date.
                        System.out.println("Enter the student's first name: ");
                        in = new Scanner(System.in);
                        String first_name = in.nextLine();

                        System.out.println("Enter the student's last name: ");
                        in = new Scanner(System.in);
                        String last_name = in.nextLine();

                        System.out.println("Enter the student's email: ");
                        in = new Scanner(System.in);
                        String email = in.nextLine();

                        System.out.println("Enter the student's enrollment date: ");
                        in = new Scanner(System.in);
                        String enrollment_date = in.nextLine();

                        functions.addStudent(connection, first_name, last_name, email, enrollment_date);
                        break;
                    // Update a student's email.
                    case 3:
                        // Ask user to input the student's id and new email.
                        System.out.println("Enter the student's id: ");
                        in = new Scanner(System.in);
                        student_id_string = in.nextLine();
                        student_id_int = Integer.valueOf(student_id_string);

                        System.out.println("Enter the student's new email: ");
                        in = new Scanner(System.in);
                        String new_email = in.nextLine();

                        functions.updateStudentEmail(connection, student_id_int, new_email);
                        break;
                    // Delete a student.
                    case 4:
                        // Ask user to input the student's id.
                        System.out.println("Enter the student's id: ");
                        in = new Scanner(System.in);
                        student_id_string = in.nextLine();
                        student_id_int = Integer.valueOf(student_id_string);

                        functions.deleteStudent(connection, student_id_int);
                        break;
                    // Close the connection and exit the program.
                    default:
                        System.out.println("Exiting the program.");
                        functions.closeConnection(connection);
                        break;
                }
            }
        // Catch any exceptions that occur and alert the user.
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}