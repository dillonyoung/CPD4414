package TraCarePackage;

import java.util.Date;

/**
 * EntryObject Class
 * @author Dillon Young (C0005790)
 */
public class EntryObject {

    // Declare variables
    private int id;
    private int userid;
    private Date datetime;
    private float weight;
    private float sleep;
    private float bloodpressure;
    private int energylevel;
    private int qualityofsleep;
    private String fitness;
    private String nutrition;
    private int symptom;
    private String symptomdescription;
    private float latitude;
    private float longitude;

    
    /**
     * Gets the entry ID
     * @return Returns the entry ID
     */
    public int getId() {
        return id;
    }

    
    /**
     * Sets the entry ID
     * @param id The value to be set to the entry ID
     */
    public void setId(int id) {
        this.id = id;
    }

    
    /**
     * Gets the entry user ID
     * @return Returns the entry user ID
     */
    public int getUserid() {
        return userid;
    }

    
    /**
     * Sets the entry user ID
     * @param userid The value to be set to the entry user ID
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }

    
    /**
     * Gets the entry date/time
     * @return Returns the entry date/time
     */
    public Date getDatetime() {
        return datetime;
    }

    
    /**
     * Sets the entry date/time
     * @param datetime The value to be set to the entry date/time
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    
    /**
     * Gets the entry weight
     * @return Returns the entry weight
     */
    public float getWeight() {
        return weight;
    }

    
    /**
     * Sets the entry weight
     * @param weight The value to be set to the entry weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    /**
     * Gets the entry sleep
     * @return Returns the entry sleep
     */
    public float getSleep() {
        return sleep;
    }

    
    /**
     * Sets the entry sleep
     * @param sleep The value to be set to the entry sleep
     */
    public void setSleep(float sleep) {
        this.sleep = sleep;
    }

    
    /**
     * Gets the entry blood pressure
     * @return Returns the entry blood pressure
     */
    public float getBloodpressure() {
        return bloodpressure;
    }

    
    /**
     * Sets the entry blood pressure
     * @param bloodpressure The value to be set to the entry blood pressure
     */
    public void setBloodpressure(float bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    
    /**
     * Gets the entry energy level
     * @return Returns the entry energy level
     */
    public int getEnergylevel() {
        return energylevel;
    }

    
    /**
     * Sets the entry energy level
     * @param energylevel The value to be set to the entry energy level
     */
    public void setEnergylevel(int energylevel) {
        this.energylevel = energylevel;
    }

    
    /**
     * Gets the entry quality of sleep
     * @return Returns the entry quality of sleep
     */
    public int getQualityofsleep() {
        return qualityofsleep;
    }

    
    /**
     * Sets the entry quality of sleep
     * @param qualityofsleep The value to be set to the entry quality of sleep
     */
    public void setQualityofsleep(int qualityofsleep) {
        this.qualityofsleep = qualityofsleep;
    }

    
    /**
     * Gets the entry fitness activity
     * @return Returns the entry fitness activity
     */
    public String getFitness() {
        return fitness;
    }

    
    /**
     * Sets the entry fitness activity
     * @param fitness The value to be set to the entry fitness activity
     */
    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    
    /**
     * Gets the entry nutrition
     * @return Returns the entry nutrition
     */
    public String getNutrition() {
        return nutrition;
    }

    
    /**
     * Sets the entry nutrition
     * @param nutrition The value to be set to the entry nutrition
     */
    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    
    /**
     * Gets the entry symptom type
     * @return Returns the entry symptom type
     */
    public int getSymptom() {
        return symptom;
    }

    
    /**
     * Sets the entry symptom type
     * @param symptom The value to be set to the entry symptom type
     */
    public void setSymptom(int symptom) {
        this.symptom = symptom;
    }

    
    /**
     * Gets the entry symptom description
     * @return Returns the entry symptom description
     */
    public String getSymptomdescription() {
        return symptomdescription;
    }

    
    /**
     * Sets the entry symptom description
     * @param symptomdescription The value to be set to the entry symptom description
     */
    public void setSymptomdescription(String symptomdescription) {
        this.symptomdescription = symptomdescription;
    }

    
    /**
     * Gets the entry latitude
     * @return Returns the entry latitude
     */
    public float getLatitude() {
        return latitude;
    }

    
    /**
     * Sets the entry latitude
     * @param latitude The value to be set to the entry latitude
     */
    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    
    /**
     * Gets the entry longitude
     * @return Returns the entry longitude
     */
    public float getLongitude() {
        return longitude;
    }

    
    /**
     * Sets the entry longitude
     * @param longitude The value to be set to the entry longitude
     */
    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
