package TraCarePackage;

import java.util.Date;

/**
 *
 * @author Dillon
 */
public class ReportObject {

    private Date lowestDate;
    private Date highestDate;
    private float lowestWeight;
    private float highestWeight;
    private float averageWeight;

    public ReportObject() {
        this.lowestWeight = Float.MAX_VALUE;
        this.highestWeight = Float.MIN_VALUE;
    }
    
    public Date getLowestDate() {
        return lowestDate;
    }

    public void setLowestDate(Date lowestDate) {
        this.lowestDate = lowestDate;
    }

    public Date getHighestDate() {
        return highestDate;
    }

    public void setHighestDate(Date highestDate) {
        this.highestDate = highestDate;
    }

    public float getLowestWeight() {
        return lowestWeight;
    }

    public void setLowestWeight(float lowestWeight) {
        this.lowestWeight = lowestWeight;
    }

    public float getHighestWeight() {
        return highestWeight;
    }

    public void setHighestWeight(float highestWeight) {
        this.highestWeight = highestWeight;
    }

    public float getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(float averageWeight) {
        this.averageWeight = averageWeight;
    }
    
    
}
