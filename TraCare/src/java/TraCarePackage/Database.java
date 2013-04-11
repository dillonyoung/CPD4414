package TraCarePackage;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Database Class
 * @author Dillon Young (C0005790)
 */
public class Database {

    // Declare database connection variables
    // URL: The URL to the Microsoft SQL Server
    //private String url = "jdbc:sqlserver://youngski.homeserver.com\\SQLSERVEREXPRESS:1433;databaseName=CSE_DEPT_c0005790";
    private String url = "jdbc:sqlserver://ipro.lambton.on.ca\\MSSQLSERVER:1433;databaseName=CSE_DEPT_c0005790";
    
    // Username: The username for the account on the Microsoft SQL Server
    private String username = "c0005790";
    
    // Password: The password for the account on the Microsoft SQL Server
    private String password = "rested";
    
    // Declare connection variable
    private Connection conn;

    
    /**
     * A constructor for the Database class
     */
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

    
    /**
     * Closes the database connection
     */
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

    
    /**
     * Checks to see if a user already exists in the application
     * @param obj The registration object for the new user
     * @return Returns the result status code
     */
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

    
    /**
     * Registers a new user with the application
     * @param obj The registration object for the new user
     * @return Returns the result status code
     */
    public int registerNewUser(RegisterObject obj) {

        // Declare variable
        int rvalue;

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

    
    /**
     * Login the selected user with the application
     * @param obj The login object for the selected user
     * @return Returns the result object with the result data
     */
    public ResultObject loginUser(LoginObject obj) {

        // Declare variable
        ResultObject result = new ResultObject();
        int rvalue;
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
    
    
    /**
     * Load the preferences for a selected user
     * @param userid The user ID for the selected user
     * @return Returns the preferences object with the result data
     */
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

    
    /**
     * Saves the preference for a selected user
     * @param pref The preference object containing the current settings
     * @return Returns the result status code
     */
    public int savePreferences(PreferencesObject pref) {

        // Declare variable
        int count = 0;
        int rvalue;
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
   
    
    /**
     * Adds a new entry to the database for the current user
     * @param entry The entry to be added to the database
     * @return Returns the result status code
     */
    public int addEntry(EntryObject entry) {
        
        // Declare variable
        int count = 0;
        int rvalue;

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
    
    
    /**
     * Loads the list of entries for a selected user from the database
     * @param userid The user ID for the selected ID
     * @return Returns list of entries
     */
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
    
    
    /**
     * Loads a single entry from the database for the current user
     * @param userid The user ID for the selected user
     * @param id The entry ID for the selected entry
     * @return Returns an entry object containing the entry
     */
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
    
    
    /**
     * Deletes an existing entry from the database
     * @param id The ID for the selected entry
     * @return Returns the result status code
     */
    public int deleteEntry(int id) {
                     
        // Declare variable
        int count = 0;
        int rvalue;
        
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

        // Return the result
        return rvalue; 
    }
    
    
    /**
     * Runs a report based on the selected start and end dates
     * @param start The start date for the report
     * @param end The end date for the report
     * @param userid The user ID to be used for the report
     * @return Returns the report object containing the data
     */
    public ReportObject runReport(Date start, Date end, int userid) {
                         
        // Declare variable
        int count = 0;
        int rvalue = -1;
        float total = 0;
        
        // Set the report start date to one day before the selected date
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(start);
        startCal.add(Calendar.DATE, -1);
        Date newStart = startCal.getTime();
        
        // Set the report end date to one day after the selected date
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(end);
        endCal.add(Calendar.DATE, 1);
        Date newEnd = endCal.getTime();
        
        // Convert the start and end dates to SQWL based dates
        java.sql.Date startDate = new java.sql.Date(newStart.getTime());
        java.sql.Date endDate = new java.sql.Date(newEnd.getTime());

        // Create a new instance of the report object
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

                // Check to see if the weight from the selected entry is less than the lowest weight
                if (rs.getFloat(4) < report.getLowestWeight()) {
                    report.setLowestWeight(rs.getFloat(4));
                    report.setLowestDate(rs.getDate(3));
                }
                
                // Check to see if the weight from the selected entry is greater than the highest weight
                if (rs.getFloat(4) > report.getHighestWeight()) {
                    report.setHighestWeight(rs.getFloat(4));
                    report.setHighestDate(rs.getDate(3));
                }
                
                // Update the average totals
                count++;
                total += rs.getFloat(4);
            }

            // Calculate the average weight
            report.setAverageWeight(total / count);
            
            // Check to see if there were no entries used in the report and set the report values to defaults
            if (count == 0) {
                report.setHighestDate(end);
                report.setLowestDate(start);
                report.setHighestWeight(0);
                report.setLowestWeight(0);
                report.setAverageWeight(0);
            }
   
        } catch (SQLException ex) {
            rvalue = -3;
        }

        // Return the result
        return report; 
    }
    
    
    /**
     * Creates the tables for the application if needed
     * @return Returns the result status code
     */
    public int createTables() {
        
        // Declare variables
        int rvalue = -1;
        
        try {
            
            DatabaseMetaData dbm = this.conn.getMetaData();
            ResultSet tables;
            
            // Check to see if the accounts table exists
            tables = dbm.getTables(null, null, "tracare_accounts", null);
            if (tables.next()) {
                
                // Do nothing since the table already exists
            } else {
                
                // Create the accounts table
                rvalue = createTable("CREATE TABLE tracare_accounts (id INT NOT NULL IDENTITY, PRIMARY KEY (id), first_name VARCHAR(100) NOT NULL, last_name VARCHAR(100) NOT NULL, gender INT NOT NULL, weight FLOAT NOT NULL, height FLOAT NOT NULL, email VARCHAR(100) NOT NULL, password VARCHAR(100) NOT NULL);");
            } 
            
            // Check to see if the symptomtypes table exists
            tables = dbm.getTables(null, null, "tracare_symptomtypes", null);
            if (tables.next()) {
                
                // Do nothing since the table already exists
            } else {
            
                // Create the symptom types table
                rvalue = createTable("CREATE TABLE tracare_symptomtypes (id INT NOT NULL IDENTITY, PRIMARY KEY (id), description VARCHAR(200) NOT NULL);");
            }
            
            // Check to see if the preferences table exists
            tables = dbm.getTables(null, null, "tracare_preferences", null);
            if (tables.next()) {
                
                // Do nothing since the table already exists
            } else {
            
                // Create the preferences table
            
                rvalue = createTable("CREATE TABLE tracare_preferences (userid INT NOT NULL, PRIMARY KEY (userid), FOREIGN KEY (userid) REFERENCES tracare_accounts(id), track_weight BIT NOT NULL, track_sleep BIT NOT NULL, track_blood_pressure BIT NOT NULL, track_energy_level BIT NOT NULL, track_quality_of_sleep BIT NOT NULL, track_fitness BIT NOT NULL, track_nutrition BIT NOT NULL, track_symptom BIT NOT NULL, track_location BIT NOT NULL);");
            }
            
            // Check to see if the locations table exists
            tables = dbm.getTables(null, null, "tracare_locations", null);
            if (tables.next()) {
                
                // Do nothing since the table already exists
            } else {
            
                // Create the locations table
                rvalue = createTable("CREATE TABLE tracare_locations (id INT NOT NULL IDENTITY,PRIMARY KEY (id),latitude FLOAT NOT NULL,longitude FLOAT NOT NULL);");
            }
            
            // Check to see if the entries table exists
            tables = dbm.getTables(null, null, "tracare_entries", null);
            if (tables.next()) {
                
                // Do nothing since the table already exists
            } else {
            
                // Create the entries table
            
                rvalue = createTable("CREATE TABLE tracare_entries (id INT NOT NULL IDENTITY, PRIMARY KEY (id), userid INT NOT NULL, FOREIGN KEY (userid) REFERENCES tracare_accounts(id), datetime DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, weight FLOAT, hours_slept FLOAT, blood_pressure FLOAT, energy_level INT, quality_of_sleep INT, fitness VARCHAR(MAX), nutrition VARCHAR(MAX), symptom INT, symptom_description VARCHAR(MAX), location_latitude FLOAT, location_longitude FLOAT);");
            }
        } catch (Exception ex) {
            rvalue = -3;
        }
        
        // Return the result
        return rvalue;
    }
    
    
    /**
     * Creates a table based on a provided query
     * @param query The create table query
     * @return Returns the result status code
     */
    private int createTable(String query) {
                
        // Declare variable
        int count = 0;
        int rvalue;
                
        try {

            // Create the prepared statement and fill in the values
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();
            rvalue = 1;
        } catch (SQLException ex) {
            rvalue = -3;
        }

        // Return the result
        return rvalue; 
    }
}
