package TraCarePackage;

import java.util.ArrayList;

/**
 *
 * @author Dillon
 */
public class Entry {


    private Database data;
    private EntryObject object;
    private String userFirstName;
    private int userId;
    
    public Entry() {
        this.object = null;
        this.data = new Database();
    }
    
    public Entry(EntryObject obj) {
        
        this();
        this.object = obj;
    }
    
    public int saveEntry() {
        
        // Declare variables
        int rvalue = -1;
        
        if (this.object != null) {
            rvalue = this.data.addEntry(this.object);
        } else {
            rvalue = -2;
        }
        
        return rvalue;
    }
    
    public ArrayList<EntryObject> loadEntries(int userid) {
        
        // Declare variables
        ArrayList<EntryObject> results;
        
        results = this.data.loadEntries(userid);
        
        return results;
    }
    
    public EntryObject loadEntry(int userid, int id) {
        
        // Declare variables
        EntryObject results;
        
        results = this.data.loadEntry(userid, id);
        
        return results;
    }
 
    public int deleteEntry(int id) {
        
        // Declare variables
        int rvalue;
        
        rvalue = this.data.deleteEntry(id);
        
        return rvalue;
    }
}
