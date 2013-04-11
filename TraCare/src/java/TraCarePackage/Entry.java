package TraCarePackage;

import java.util.ArrayList;

/**
 * Entry Class
 * @author Dillon Young (C0005790)
 */
public class Entry {

    // Declare variables
    private Database data;
    private EntryObject object;
    private String userFirstName;
    private int userId;
    
    
    /**
     * A constructor for the Entry class
     */
    public Entry() {
        this.object = null;
        this.data = new Database();
    }
    
    
    /**
     * A constructor for the Entry class
     * @param obj The entry object
     */
    public Entry(EntryObject obj) {
        
        this();
        this.object = obj;
    }
    
    
    /**
     * Save the entry
     * @return Returns the result status code
     */
    public int saveEntry() {
        
        // Declare variables
        int rvalue;
        
        // Check to see if the object is not null
        if (this.object != null) {
            
            // Add the entry to the database
            rvalue = this.data.addEntry(this.object);
        } else {
            rvalue = -2;
        }
        
        // Return the result
        return rvalue;
    }
    
    
    /**
     * Loads a list of the entries for the selected user
     * @param userid The user ID for the selected user
     * @return Returns the list of entries
     */
    public ArrayList<EntryObject> loadEntries(int userid) {
        
        // Declare variables
        ArrayList<EntryObject> results;
        
        // Load the entries
        results = this.data.loadEntries(userid);
        
        // Return the list
        return results;
    }
    
    
    /**
     * Loads a selected entry details
     * @param userid The user ID for the selected user
     * @param id The ID for the selected entry
     * @return Returns the entry object
     */
    public EntryObject loadEntry(int userid, int id) {
        
        // Declare variables
        EntryObject results;
        
        // Load the entry
        results = this.data.loadEntry(userid, id);
        
        // Return the entry
        return results;
    }
 
    
    /**
     * Deletes a selected entry from the database
     * @param id The ID of the entry to be deleted
     * @return Returns the result status code
     */
    public int deleteEntry(int id) {
        
        // Declare variables
        int rvalue;
        
        // Delete the entry
        rvalue = this.data.deleteEntry(id);
        
        // Return the result
        return rvalue;
    }
}
