package TraCarePackage;

/**
 *
 * @author Dillon
 */
public class RegisterObject {
    private String first_name = "";
    private String last_name = "";
    private int gender;
    private float weight;
    private float height;
    private String email;
    private String password;
    
    public String getFirstName() {
        return this.first_name;
    }
    
    public String getLastName() {
        return this.last_name;
    }
    
    public int getGender() {
        return this.gender;
    }
    
    public float getWeight() {
        return this.weight;
    }
    
    public float getHeight() {
        return this.height;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setFirstName(String value) {
        this.first_name = value;
    }
    
    public void setLastName(String value) {
        this.last_name = value;
    }
    
    public void setGender(int value) {
        this.gender = value;
    }
    
    public void setWeight(float value) {
        this.weight = value;
    }
    
    public void setHeight(float value) {
        this.height = value;
    }
    
    public void setEmail(String value) {
        this.email = value;
    }
    
    public void setPassword(String value) {
        this.password = value;
    }
}
