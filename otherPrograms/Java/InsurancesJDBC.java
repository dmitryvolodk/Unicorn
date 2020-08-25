
import java.sql.*;

public class InsurancesJDBC {
    public static void main(String[] args)
            throws SQLException, ClassNotFoundException {
        // Load the JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver loaded"); 
        
        // Connect to a database
        Connection connection = DriverManager.getConnection
                ("jdbc:mysql://localhost/insurances", "scott", "tiger");
        System.out.println("Database connected");
        
        // Create a statement
        Statement statement = connection.createStatement();
        
        // Execute a statement
        ResultSet resultSet = statement.executeQuery
                ("select medicalService, copay$ " 
               + "from HarvardPilgrim "
               + "where medicalService = 'Primary care visit for illness'");
               
        // Iterate through the result and print the copay
        while( resultSet.next()){
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2));
        }
        
        // Close the connection
        connection.close();
    }
}
