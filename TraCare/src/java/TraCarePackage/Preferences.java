package TraCarePackage;

/**
 *
 * @author Dillon
 */
public class Preferences {

    
    private Database data;
    private PreferencesObject object;
    
    public Preferences() {
        this.object = null;
        this.data = new Database();
    }
    
    public Preferences(PreferencesObject obj) {
        
        this();
        this.object = obj;
    }
    
    public PreferencesObject loadPreferences(int userid) {
        
        // Declare variables
        PreferencesObject pref = this.data.loadPreferences(userid);
        
        return pref;
    }
    
    public int savePreferences() {
       
        // Declare variables
        int rvalue = 0;
        
        if (this.object != null) {
            rvalue = this.data.savePreferences(this.object);
            
        } else {
            rvalue = -2;
        }
        
        return rvalue;
    }
    
}
