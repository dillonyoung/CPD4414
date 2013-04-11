package TraCarePackage;

/**
 * RegisterObject Class
 * @author Dillon Young (C0005790)
 */
public class RegisterObject {
    
    // Declare variables
    private String first_name = "";
    private String last_name = "";
    private int gender;
    private float weight;
    private float height;
    private String email;
    private String password;
    
    
    /**
     * Gets the first name
     * @return Returns the first name
     */
    public String getFirstName() {
        return this.first_name;
    }
    
    
    /**
     * Gets the last name
     * @return Returns the last name
     */
    public String getLastName() {
        return this.last_name;
    }
    
    
    /**
     * Gets the gender
     * @return Returns the gender
     */
    public int getGender() {
        return this.gender;
    }
    
    
    /**
     * Gets the weight
     * @return Returns the weight
     */
    public float getWeight() {
        return this.weight;
    }
    
    
    /**
     * Gets the height
     * @return Returns the height
     */
    public float getHeight() {
        return this.height;
    }
    
    
    /**
     * Gets the email address
     * @return Returns the email address
     */
    public String getEmail() {
        return this.email;
    }
    
    
    /**
     * Gets the password
     * @return Returns the password
     */
    public String getPassword() {
        return this.password;
    }
    
    
    /**
     * Sets the first name
     * @param value The value to be set to the first name
     */
    public void setFirstName(String value) {
        this.first_name = value;
    }
    
    
    /**
     * Sets the last name
     * @param value The value to be set to the last name
     */
    public void setLastName(String value) {
        this.last_name = value;
    }
    
    
    /**
     * Sets the gender
     * @param value The value to be set to the gender
     */
    public void setGender(int value) {
        this.gender = value;
    }
    
    
    /**
     * Sets the weight
     * @param value The value to be set to the weight
     */
    public void setWeight(float value) {
        this.weight = value;
    }
    
    /**
     * Sets the height
     * @param value The value to be set to the height
     */
    public void setHeight(float value) {
        this.height = value;
    }
    
    
    /**
     * Sets the email address
     * @param value The value to the set to the email address
     */
    public void setEmail(String value) {
        this.email = value;
    }
    
    
    /**
     * Sets the password
     * @param value The value to be set to the password
     */
    public void setPassword(String value) {
        this.password = value;
    }
}
