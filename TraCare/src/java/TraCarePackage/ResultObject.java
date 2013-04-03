package TraCarePackage;

/**
 *
 * @author Dillon
 */
public class ResultObject {
    private int status;
    private String firstName;
    private int userId;
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int value) {
        this.status = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
