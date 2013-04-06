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
            pstmt.setString(7, PasswordEncrypt.generateHash(obj.getPassword()));

            // Execute the statement
            rvalue = pstmt.executeUpdate();
        } catch (SQLException e) {
            rvalue = -1;
        }

        // Return the result
        return rvalue;
    }

    public ResultObject loginUser(LoginObject obj) {

        // Declare variable
        ResultObject result = new ResultObject();
        int rvalue = -1;
        int user_id = -1;
        String user_first_name = "";
        String user_password = "";

        // Declare query statement
        String query = "SELECT id, first_name, password FROM tracare_accounts WHERE email = ?";
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, obj.getEmail());

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                user_id = rs.getInt(1);
                user_first_name = rs.getString(2);
                user_password = rs.getString(3);
            }

            // Check to see if the password matches the one on record
            if (PasswordEncrypt.generateHash(obj.getPassword()).equals(user_password)) {
                rvalue = 0;
                result.setUserId(user_id);
                result.setFirstName(user_first_name);
            } else {
                rvalue = -1;
            }
        } catch (SQLException e) {
            rvalue = -2;
        }

        result.setStatus(rvalue);

        // Return the result
        return result;
    }
    
    public PreferencesObject loadPreferences(int userid) {
        
        
        // Declare variable
        PreferencesObject preferences = new PreferencesObject();
        int rvalue = -1;

        // Set the initial values
        preferences.setUserID(userid);
        preferences.setTrackWeight(true);
        preferences.setTrackSleep(true);
        preferences.setTrackBloodPressure(true);
        preferences.setTrackEnergyLevel(true);
        preferences.setTrackQualityofSleep(true);
        preferences.setTrackFitness(true);
        preferences.setTrackNutrition(true);
        preferences.setTrackSymptom(true);
        preferences.setTrackLocation(true);
        
        // Declare query statement
        String query = "SELECT * FROM tracare_preferences WHERE userid = ?";
        
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userid);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                preferences.setUserID(rs.getInt(1));
                preferences.setTrackWeight(rs.getBoolean(2));
                preferences.setTrackSleep(rs.getBoolean(3));
                preferences.setTrackBloodPressure(rs.getBoolean(4));
                preferences.setTrackEnergyLevel(rs.getBoolean(5));
                preferences.setTrackQualityofSleep(rs.getBoolean(6));
                preferences.setTrackFitness(rs.getBoolean(7));
                preferences.setTrackNutrition(rs.getBoolean(8));
                preferences.setTrackSymptom(rs.getBoolean(9));
                preferences.setTrackLocation(rs.getBoolean(10));
            }

            rvalue = 1;
        } catch (SQLException e) {
            rvalue = -2;
        }

        // Return the result
        return preferences;
    }

    public int savePreferences(PreferencesObject pref) {

        // Declare variable
        int count = 0;
        int rvalue = -1;
        int user_id = -1;
        String user_first_name = "";
        String user_password = "";

        // Declare query statement
        String query = "SELECT * FROM tracare_preferences WHERE userid = ?";
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, pref.getUserID());

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while (rs.next()) {
                count++;
            }

            // Check to see if the preferences entry does not exist
            if (count == 0) {
                
                // Create the insert query
                query = "INSERT INTO tracare_preferences (userid, track_weight, track_sleep, track_blood_pressure, track_energy_level, track_quality_of_sleep, track_fitness, track_nutrition, track_symptom, track_location) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                try {
                    
                    // Create the prepared statement and fill in the values
                    PreparedStatement pstmtInsert = conn.prepareStatement(query);
                    pstmtInsert.setInt(1, pref.getUserID());
                    pstmtInsert.setBoolean(2, pref.isTrackWeight());
                    pstmtInsert.setBoolean(3, pref.isTrackSleep());
                    pstmtInsert.setBoolean(4, pref.isTrackBloodPressure());
                    pstmtInsert.setBoolean(5, pref.isTrackEnergyLevel());
                    pstmtInsert.setBoolean(6, pref.isTrackQualityofSleep());
                    pstmtInsert.setBoolean(7, pref.isTrackFitness());
                    pstmtInsert.setBoolean(8, pref.isTrackNutrition());
                    pstmtInsert.setBoolean(9, pref.isTrackSymptom());
                    pstmtInsert.setBoolean(10, pref.isTrackLocation());
                    
                    // Execute the statement
                    rvalue = pstmtInsert.executeUpdate();
                } catch (SQLException ex) {
                    rvalue = -3;
                                System.out.println(ex.getMessage());
                }
            } else {
                
                // Create the update query
                query = "UPDATE tracare_preferences SET track_weight = ?, track_sleep = ?, track_blood_pressure = ?, track_energy_level = ?, track_quality_of_sleep = ?, track_fitness = ?, track_nutrition = ?, track_symptom = ?, track_location = ? WHERE userid = ?";
                
                try {
                    
                    // Create the prepared statement and fill in the values
                    PreparedStatement pstmtUpdate = conn.prepareStatement(query);
                    
                    pstmtUpdate.setBoolean(1, pref.isTrackWeight());
                    pstmtUpdate.setBoolean(2, pref.isTrackSleep());
                    pstmtUpdate.setBoolean(3, pref.isTrackBloodPressure());
                    pstmtUpdate.setBoolean(4, pref.isTrackEnergyLevel());
                    pstmtUpdate.setBoolean(5, pref.isTrackQualityofSleep());
                    pstmtUpdate.setBoolean(6, pref.isTrackFitness());
                    pstmtUpdate.setBoolean(7, pref.isTrackNutrition());
                    pstmtUpdate.setBoolean(8, pref.isTrackSymptom());
                    pstmtUpdate.setBoolean(9, pref.isTrackLocation());
                    pstmtUpdate.setInt(10, pref.getUserID());
                    
                    // Execute the statement
                    rvalue = pstmtUpdate.executeUpdate();
                } catch (SQLException ex) {
                    rvalue = -2;
                }
            }
        } catch (SQLException ex) {
            rvalue = -2;
        }

        // Return the result
        return rvalue;
    }
}
