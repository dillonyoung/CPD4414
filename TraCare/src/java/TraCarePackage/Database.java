package TraCarePackage;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
   
    public int addEntry(EntryObject entry) {
        
        // Declare variable
        int count = 0;
        int rvalue = -1;

        // Declare query statement
        String query = "INSERT INTO tracare_entries (userid, weight, hours_slept, blood_pressure, energy_level, quality_of_sleep, fitness, nutrition, symptom, symptom_description, location_latitude, location_longitude) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmtInsert = conn.prepareStatement(query);
            pstmtInsert.setInt(1, entry.getUserid());
            pstmtInsert.setFloat(2, entry.getWeight());
            pstmtInsert.setFloat(3, entry.getSleep());
            pstmtInsert.setFloat(4, entry.getBloodpressure());
            pstmtInsert.setInt(5, entry.getEnergylevel());
            pstmtInsert.setInt(6, entry.getQualityofsleep());
            pstmtInsert.setString(7, entry.getFitness());
            pstmtInsert.setString(8, entry.getNutrition());
            pstmtInsert.setInt(9, entry.getSymptom());
            pstmtInsert.setString(10, entry.getSymptomdescription());
            pstmtInsert.setFloat(11, entry.getLatitude());
            pstmtInsert.setFloat(12, entry.getLongitude());

            // Execute the statement
            rvalue = pstmtInsert.executeUpdate();
        } catch (SQLException ex) {
            rvalue = -3;
            System.out.println(ex.getMessage());
        }
 

        // Return the result
        return rvalue;
    }
    
    public ArrayList<EntryObject> loadEntries(int userid) {
               
        // Declare variable
        int count = 0;
        int rvalue = -1;

        ArrayList<EntryObject> entries = new ArrayList<EntryObject>();
        
        // Declare query statement
        String query = "SELECT * FROM tracare_entries WHERE userid = ? ORDER BY datetime DESC";
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userid);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                EntryObject entry = new EntryObject();
                entry.setId(rs.getInt(1));
                entry.setUserid(rs.getInt(2));
                entry.setDatetime(rs.getTimestamp(3));
                entry.setWeight(rs.getFloat(4));
                entry.setSleep(rs.getFloat(5));
                entry.setBloodpressure(rs.getFloat(6));
                entry.setEnergylevel(rs.getInt(7));
                entry.setQualityofsleep(rs.getInt(8));
                entry.setFitness(rs.getString(9));
                entry.setNutrition(rs.getString(10));
                entry.setSymptom(rs.getInt(11));
                entry.setSymptomdescription(rs.getString(12));
                entry.setLatitude(rs.getFloat(13));
                entry.setLongitude(rs.getFloat(14));
                //entry = new SimpleDateFormat("MMMMM d, yyyy HH:mm:ss aa").format(rs.getTimestamp(1));
                entries.add(entry);
            }
   
        } catch (SQLException ex) {
            rvalue = -3;
            System.out.println(ex.getMessage());
        }
 

        // Return the result
        return entries; 
    }
    
    public EntryObject loadEntry(int userid, int id) {
                       
        // Declare variable
        int count = 0;
        int rvalue = -1;

        EntryObject entry = new EntryObject();
        
        // Declare query statement
        String query = "SELECT * FROM tracare_entries WHERE userid = ? AND id = ? ORDER BY datetime DESC";
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userid);
            pstmt.setInt(2, id);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {
                entry.setId(rs.getInt(1));
                entry.setUserid(rs.getInt(2));
                entry.setDatetime(rs.getTimestamp(3));
                entry.setWeight(rs.getFloat(4));
                entry.setSleep(rs.getFloat(5));
                entry.setBloodpressure(rs.getFloat(6));
                entry.setEnergylevel(rs.getInt(7));
                entry.setQualityofsleep(rs.getInt(8));
                entry.setFitness(rs.getString(9));
                entry.setNutrition(rs.getString(10));
                entry.setSymptom(rs.getInt(11));
                entry.setSymptomdescription(rs.getString(12));
                entry.setLatitude(rs.getFloat(13));
                entry.setLongitude(rs.getFloat(14));
            }
            
            if ("".equals(entry.getFitness())) { entry.setFitness("N/A"); }
            if ("".equals(entry.getNutrition())) { entry.setNutrition("N/A"); }
            if ("".equals(entry.getSymptomdescription())) { entry.setSymptomdescription("N/A"); }
   
        } catch (SQLException ex) {
            rvalue = -3;
        }

        // Return the result
        return entry; 
    }
    
    public int deleteEntry(int id) {
                     
        // Declare variable
        int count = 0;
        int rvalue = -1;
        
        // Declare query statement
        String query = "DELETE FROM tracare_entries WHERE id = ?";
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            rvalue = 1;
        } catch (SQLException ex) {
            rvalue = -3;
        }

        System.err.println(rvalue);
        // Return the result
        return rvalue; 
    }
    
    public ReportObject runReport(Date start, Date end, int userid) {
                         
        // Declare variable
        int count = 0;
        int rvalue = -1;
        float total = 0;
        
        java.sql.Date startDate = new java.sql.Date(start.getTime());
        java.sql.Date endDate = new java.sql.Date(end.getTime());

        ReportObject report = new ReportObject();
        
        // Declare query statement
        String query = "SELECT * FROM tracare_entries WHERE userid = ? AND datetime BETWEEN ? AND ?";
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userid);
            pstmt.setDate(2, startDate);
            pstmt.setDate(3, endDate);
            
            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            while (rs.next()) {

                if (rs.getFloat(4) < report.getLowestWeight()) {
                    report.setLowestWeight(rs.getFloat(4));
                    report.setLowestDate(rs.getDate(3));
                }
                if (rs.getFloat(4) > report.getHighestWeight()) {
                    report.setHighestWeight(rs.getFloat(4));
                    report.setHighestDate(rs.getDate(3));
                }
                
                count++;
                total += rs.getFloat(4);
            }

            report.setAverageWeight(total / count);
   
        } catch (SQLException ex) {
            rvalue = -3;
        }

        // Return the result
        return report; 
    }
}
