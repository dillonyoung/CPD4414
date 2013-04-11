package TraCarePackage;

/**
 * ResultObject Class
 * @author Dillon Young (C0005790)
 */
public class ResultObject {
    
    // Declare variables
    private int status;
    private String firstName;
    private int userId;
    
    
    /**
     * Gets the status
     * @return Return the status
     */
    public int getStatus() {
        return this.status;
    }
    
    
    /**
     * Sets the status
     * @param value The value to be set to the status
     */
    public void setStatus(int value) {
        this.status = value;
    }

    
    /**
     * Gets the first name
     * @return Returns the first name
     */
    public String getFirstName() {
        return firstName;
    }

    
    /**
     * Sets the first name
     * @param firstName The value to be set to the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
}
