package TraCarePackage;

/**
 * Register Class
 * @author Dillon Young (C0005790)
 */
public class Register {

    // Declare variables
    private Database data;
    private RegisterObject object;
    
    
    /**
     * A constructor for the Register class
     */
    public Register() {
        this.object = null;
        this.data = new Database();
    }
    
    
    /**
     * A constructor for the Register class
     * @param obj The registration oject
     */
    public Register(RegisterObject obj) {
        this();
        this.object = obj;
    }
    
    
    /**
     * Attempt to complete the registration
     * @return Returns the result status
     */
    public int attemptRegistration() {
        
        // Declare variables
        int rvalue = 0;
        
        // Check to ensure that the object has been set
        if (this.object != null) {
            
            // Check to see if the email address is available
            rvalue = this.data.checkIfUserExists(this.object);
            
            if (rvalue == 0) {
                
                // Register the user
                rvalue = this.data.registerNewUser(this.object);
            } else {
                rvalue = -3;
            }
        } else {
            rvalue = -2;
        }
        
        // Return the result
        return rvalue;
    }
}
