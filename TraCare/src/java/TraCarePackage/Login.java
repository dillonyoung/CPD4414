package TraCarePackage;

/**
 * Login Class
 * @author Dillon Young (C0005790)
 */
public class Login {

    // Declare variables
    private Database data;
    private LoginObject object;
    
    
    /**
     * A constructor for the Login class
     */
    public Login() {
        this.object = null;
        this.data = new Database();
    }
    
    
    /**
     * A constructor for the Login class
     * @param obj The login object
     */
    public Login(LoginObject obj) {
        
        this();
        this.object = obj;
    }
    
    
    /**
     * Attempt to log the user into the application
     * @return Returns the result status code
     */
    public ResultObject attemptLogin() {
        
        // Declare variables
        int rvalue;
        ResultObject result = new ResultObject();
        
        // Check to see if the object is not null
        if (this.object != null) {
            
            // Login the user
            result = this.data.loginUser(this.object);
            rvalue = result.getStatus();
        } else {
            rvalue = -2;
        }
        
        // Update the status
        result.setStatus(rvalue);
        
        // Return the result
        return result;
    }
}
