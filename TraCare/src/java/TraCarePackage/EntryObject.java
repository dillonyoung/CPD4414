package TraCarePackage;

import java.util.Date;

/**
 *
 * @author Dillon
 */
public class EntryObject {

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getSleep() {
        return sleep;
    }

    public void setSleep(float sleep) {
        this.sleep = sleep;
    }

    public float getBloodpressure() {
        return bloodpressure;
    }

    public void setBloodpressure(float bloodpressure) {
        this.bloodpressure = bloodpressure;
    }

    public int getEnergylevel() {
        return energylevel;
    }

    public void setEnergylevel(int energylevel) {
        this.energylevel = energylevel;
    }

    public int getQualityofsleep() {
        return qualityofsleep;
    }

    public void setQualityofsleep(int qualityofsleep) {
        this.qualityofsleep = qualityofsleep;
    }

    public String getFitness() {
        return fitness;
    }

    public void setFitness(String fitness) {
        this.fitness = fitness;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public int getSymptom() {
        return symptom;
    }

    public void setSymptom(int symptom) {
        this.symptom = symptom;
    }

    public String getSymptomdescription() {
        return symptomdescription;
    }

    public void setSymptomdescription(String symptomdescription) {
        this.symptomdescription = symptomdescription;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    
}
