package TraCarePackage;

import java.sql.*;

/**
 *
 * @author Dillon
 */
public class Database {

    // Declare database connection variables
    private String url = "jdbc:sqlserver://youngski.homeserver.com\\SQLSERVEREXPRESS:1433;databaseName=CSE_DEPT_c0005790";
    private String username = "c0005790";
    private String password = "rested";
    
    // Declare connection variable
    private Connection conn;
    
    public Database() {
        
        // Attempt to load the Microsoft SQL driver
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (Exception ex) {
            System.out.println("Class not found! " + ex.getMessage());
        }
        
        // Attempt to connect using the driver and connection details
        try {
            this.conn = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception ex) {
            System.out.println("Could not connect!" + ex.getMessage());
        }
    }
    
    public void closeConnection() {
        
        // Check to see if the connection is set
        if (this.conn != null) {
            
            // Attempt to close the connection
            try {
                this.conn.close();
            } catch (Exception ex) {
                System.out.println("Could not close!" + ex.getMessage());
            }
        }
    }
    
    public int checkIfUserExists(RegisterObject obj) {
        
        // Declare variable
        int rvalue = 0;
        
        // Declare query statement
        String query = "SELECT * FROM tracare_accounts WHERE email = ?";
        
        try {
            
            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, obj.getEmail());
            
            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                rvalue++;
            }
            rs.close();
            
        } catch (SQLException e) {
            rvalue = -1;
        }
        
        // Return the result
        return rvalue;
    }
    
    public int registerNewUser(RegisterObject obj) {
        
        // Declare variable
        int rvalue = 0;
        
        // Declare query statement
        String query = "INSERT INTO tracare_accounts (first_name, last_name, gender, weight, height, email, password) VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            
            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, obj.getFirstName());
            pstmt.setString(2, obj.getLastName());
            pstmt.setInt(3, obj.getGender());
            pstmt.setFloat(4, obj.getWeight());
            pstmt.setFloat(5, obj.getHeight());
            pstmt.setString(6, obj.getEmail());
            pstmt.setString(7, obj.getPassword());

            // Execute the statement
            rvalue = pstmt.executeUpdate();
        } catch (SQLException e) {
            rvalue = -1;
        }
        
        // Return the result
        return rvalue;
    }
}
