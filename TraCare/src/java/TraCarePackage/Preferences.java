package TraCarePackage;

/**
 * Preferences Class
 * @author Dillon Young (C0005790)
 */
public class Preferences {

    // Declare variables
    private Database data;
    private PreferencesObject object;
    
    
    /**
     * The constructor for the class
     */
    public Preferences() {
        this.object = null;
        this.data = new Database();
    }
    
    
    /**
     * A constructor for the class
     * @param obj The preferences object
     */
    public Preferences(PreferencesObject obj) {
        this();
        this.object = obj;
    }
    
    
    /**
     * Loads the preferences for the selected user
     * @param userid The user ID for the selected user
     * @return Returns the preferences object
     */
    public PreferencesObject loadPreferences(int userid) {
        
        // Load the preferences
        PreferencesObject pref = this.data.loadPreferences(userid);
        
        // Return the preferences object
        return pref;
    }
    
    
    /**
     * Saves the preferences for the selected user
     * @return Returns the result status code
     */
    public int savePreferences() {
       
        // Declare variables
        int rvalue = 0;
        
        // Check to see if the object is not null
        if (this.object != null) {
            
            // Save the preferences
            rvalue = this.data.savePreferences(this.object);
            
        } else {
            rvalue = -2;
        }
        
        // Return the result
        return rvalue;
    }
    
}
