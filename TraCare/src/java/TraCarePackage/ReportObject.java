package TraCarePackage;

import java.util.Date;

/**
 * ReportObject Class
 * @author Dillon Young (C0005790)
 */
public class ReportObject {

    // Declare variables
    private Date lowestDate;
    private Date highestDate;
    private float lowestWeight;
    private float highestWeight;
    private float averageWeight;

    
    /**
     * The constructor for the ReportObject class
     */
    public ReportObject() {
        this.lowestWeight = Float.MAX_VALUE;
        this.highestWeight = Float.MIN_VALUE;
        this.lowestDate = new Date(Long.MIN_VALUE);
        this.highestDate = new Date(Long.MAX_VALUE);
    }
    
    
    /**
     * Gets the date of the lowest weight
     * @return Returns the date of the lowest weight
     */
    public Date getLowestDate() {
        return lowestDate;
    }

    
    /**
     * Sets the date of the lowest weight
     * @param lowestDate The date to be set to the lowest weight date
     */
    public void setLowestDate(Date lowestDate) {
        this.lowestDate = lowestDate;
    }

    
    /**
     * Gets the date of the highest weight
     * @return Returns the date of the highest weight
     */
    public Date getHighestDate() {
        return highestDate;
    }

    
    /**
     * Sets the date of the highest weight
     * @param highestDate The date to be set to the highest weight date
     */
    public void setHighestDate(Date highestDate) {
        this.highestDate = highestDate;
    }

    
    /**
     * Gets the lowest weight value
     * @return Returns the lowest weight value
     */
    public float getLowestWeight() {
        return lowestWeight;
    }

    
    /**
     * Sets the lowest weight value
     * @param lowestWeight The value to be set to the lowest weight
     */
    public void setLowestWeight(float lowestWeight) {
        this.lowestWeight = lowestWeight;
    }

    
    /**
     * Gets the highest weight value
     * @return Returns the highest weight value
     */
    public float getHighestWeight() {
        return highestWeight;
    }

    
    /**
     * Sets the highest weight value
     * @param highestWeight The value to be set to the highest weight
     */
    public void setHighestWeight(float highestWeight) {
        this.highestWeight = highestWeight;
    }

    
    /**
     * Gets the average weight value
     * @return Returns the average weight value
     */
    public float getAverageWeight() {
        return averageWeight;
    }

    
    /**
     * Sets the average weight value
     * @param averageWeight The value to be set to the average value
     */
    public void setAverageWeight(float averageWeight) {
        this.averageWeight = averageWeight;
    }
}
