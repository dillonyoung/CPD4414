package TraCarePackage;

import java.sql.*;

/**
 *
 * @author Dillon
 */
public class Register {

    private Database data;
    private RegisterObject object;
    
    public Register() {
        this.object = null;
        this.data = new Database();
    }
    
    public Register(RegisterObject obj) {
        
        this();
        this.object = obj;
    }
    
    public int attemptRegistration() {
        
        // Declare variables
        int rvalue = 0;
        
        if (this.object != null) {
            rvalue = this.data.checkIfUserExists(this.object);
            
            if (rvalue == 0) {
                rvalue = this.data.registerNewUser(this.object);
            } else {
                rvalue = -3;
            }
        } else {
            rvalue = -2;
        }
        
        return rvalue;
    }
}
