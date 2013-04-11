package TraCarePackage;

/**
 * LoginStatus Class
 * @author Dillon Young (C0005790)
 */
public class LoginStatus {

    // Declare variables
    private String firstname;
    private int userId;
    private int status;

    
    /**
     * Gets the first name
     * @return Returns the first name
     */
    public String getFirstname() {
        return firstname;
    }

    
    /**
     * Sets the first name
     * @param firstname The value to be set to be first name
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    
    /**
     * Gets the user ID
     * @return Returns the user ID
     */
    public int getUserId() {
        return userId;
    }

    
    /**
     * Sets the user ID
     * @param userId The value to be set to the user ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    
    /**
     * Gets the status
     * @return Returns the status
     */
    public int getStatus() {
        return status;
    }

    
    /**
     * Sets the status
     * @param status The value to be set to the status
     */
    public void setStatus(int status) {
        this.status = status;
    }
}
