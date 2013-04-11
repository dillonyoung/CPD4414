package TraCarePackage;

/**
 * PreferencesObject Class
 * @author Dillon Young (C0005790)
 */
public class PreferencesObject {

    // Declare variables
    private int userID;
    private boolean trackWeight;
    private boolean trackSleep;
    private boolean trackBloodPressure;
    private boolean trackEnergyLevel;
    private boolean trackQualityofSleep;
    private boolean trackFitness;
    private boolean trackNutrition;
    private boolean trackSymptom;
    private boolean trackLocation;

    
    /**
     * Gets the user ID
     * @return Returns the user ID
     */
    public int getUserID() {
        return userID;
    }

    
    /**
     * Sets the user ID
     * @param userID The value to be set to the user ID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    
    /**
     * Gets whether the weight entry is tracked
     * @return Returns whether the weight entry is tracked
     */
    public boolean isTrackWeight() {
        return trackWeight;
    }

    
    /**
     * Sets whether the weight entry is tracked
     * @param trackWeight The value to be set to determine if the weight entry is tracked
     */
    public void setTrackWeight(boolean trackWeight) {
        this.trackWeight = trackWeight;
    }

    
    /**
     * Gets whether the sleep entry is tracked
     * @return Returns whether the sleep entry is tracked
     */
    public boolean isTrackSleep() {
        return trackSleep;
    }

    
    /**
     * Sets whether the sleep entry is tracked
     * @param trackSleep The value to be set to determine if the sleep entry is tracked
     */
    public void setTrackSleep(boolean trackSleep) {
        this.trackSleep = trackSleep;
    }

    
    /**
     * Gets whether the blood pressure entry is tracked
     * @return Returns whether the blood pressure entry is tracked
     */
    public boolean isTrackBloodPressure() {
        return trackBloodPressure;
    }

    
    /**
     * Sets whether the blood pressure entry is tracked
     * @param trackBloodPressure The value to be set to determine if the blood pressure entry is tracked
     */
    public void setTrackBloodPressure(boolean trackBloodPressure) {
        this.trackBloodPressure = trackBloodPressure;
    }

    
    /**
     * Gets whether the energy level entry is tracked
     * @return Returns whether the energy level is tracked
     */
    public boolean isTrackEnergyLevel() {
        return trackEnergyLevel;
    }

    
    /**
     * Sets whether the energy level entry is tracked
     * @param trackEnergyLevel The value to be set to determine if the energy level entry is tracked
     */
    public void setTrackEnergyLevel(boolean trackEnergyLevel) {
        this.trackEnergyLevel = trackEnergyLevel;
    }

    
    /**
     * Gets whether the quality of sleep entry is tracked
     * @return Returns whether the quality of sleep entry is tracked
     */
    public boolean isTrackQualityofSleep() {
        return trackQualityofSleep;
    }

    
    /**
     * Sets whether the quality of sleep entry is tracked
     * @param trackQualityofSleep The value to be set to determine if the quality of sleep entry is tracked
     */
    public void setTrackQualityofSleep(boolean trackQualityofSleep) {
        this.trackQualityofSleep = trackQualityofSleep;
    }

    
    /**
     * Gets whether the fitness activity entry is tracked
     * @return Returns whether the fitness activity entry is tracked
     */
    public boolean isTrackFitness() {
        return trackFitness;
    }

    
    /**
     * Sets whether the fitness activity entry is tracked
     * @param trackFitness The value to be set to determine if the fitness activity entry is tracked
     */
    public void setTrackFitness(boolean trackFitness) {
        this.trackFitness = trackFitness;
    }

    
    /**
     * Gets whether the nutrition entry is tracked
     * @return Returns whether the nutrition entry is tracked
     */
    public boolean isTrackNutrition() {
        return trackNutrition;
    }

    
    /**
     * Sets whether the nutrition entry is tracked
     * @param trackNutrition The value to be set to determine if the nutrition entry is tracked
     */
    public void setTrackNutrition(boolean trackNutrition) {
        this.trackNutrition = trackNutrition;
    }

    
    /**
     * Gets whether the symptom entry is tracked
     * @return Returns the symptom entry is tracked
     */
    public boolean isTrackSymptom() {
        return trackSymptom;
    }

    
    /**
     * Sets whether the symptom entry is tracked
     * @param trackSymptom The value to be set to determine if the symptom entry is tracked
     */
    public void setTrackSymptom(boolean trackSymptom) {
        this.trackSymptom = trackSymptom;
    }

    
    /**
     * Gets whether the location entry is tracked
     * @return Returns whether the location entry is tracked
     */
    public boolean isTrackLocation() {
        return trackLocation;
    }

    
    /**
     * Sets whether the location entry is tracked
     * @param trackLocation The value to be set to determine if the location entry is tracked
     */
    public void setTrackLocation(boolean trackLocation) {
        this.trackLocation = trackLocation;
    }
}
