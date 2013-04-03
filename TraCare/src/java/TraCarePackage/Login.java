package TraCarePackage;

/**
 *
 * @author Dillon
 */
public class Login {

    
    private Database data;
    private LoginObject object;
    private String userFirstName;
    private int userId;
    
    public Login() {
        this.object = null;
        this.data = new Database();
    }
    
    public Login(LoginObject obj) {
        
        this();
        this.object = obj;
    }
    
    public ResultObject attemptLogin() {
        
        // Declare variables
        int rvalue = -1;
        ResultObject result = new ResultObject();
        
        if (this.object != null) {
            result = this.data.loginUser(this.object);
            rvalue = result.getStatus();
        } else {
            rvalue = -2;
        }
        
        result.setStatus(rvalue);
        
        return result;
    }
}
