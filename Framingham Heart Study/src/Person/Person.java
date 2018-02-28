/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Person;

import Patient.VitalSigns;
import Patient.VitalSignsHistory;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Person {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int age;
    private String genealogicalStatus;
    
    private static int count;
    private boolean diabetes;
    private boolean smoking;
    private boolean hasHeartDiease;
    public Gender gender;
    
    private boolean hasHeredityHeartDisease;
    
    private float averageRiskScore;
    
    private int communityId;
    private int familyId;
    private int houseId;
    
    private int id;
    
    
    // Vital Signs

    private VitalSignsHistory vitalSignsHistory;

    
    public Person() {
        vitalSignsHistory = new VitalSignsHistory();
        count++;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
        
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getGenealogicalStatus() {
        return genealogicalStatus;
    }

    public void setGenealogicalStatus(String genealogicalStatus) {
        this.genealogicalStatus = genealogicalStatus;
    }

    public static int getCount() {
        return count;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public boolean isDiabetic() {
        return diabetes;
    }

    /**Set if patient has diabetes.
     * 
     * @param diabetes true if patient has diabetes, false otherwise.
     */
    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isASmoker() {
        return smoking;
    }

    /**Set if the patient has a habit of smoking.
     * 
     * @param smoking true if patient is a smoker, false otherwise.
     */
    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean hasHeartDiease() {
        return hasHeartDiease;
    }

    /**Set if the patient has heart disease.
     * 
     * @param hasHeartDiease true if patient has heart disease, false otherwise.
     */
    public void setHasHeartDiease(boolean hasHeartDiease) {
        this.hasHeartDiease = hasHeartDiease;
    }

    public boolean hasHeredityHeartDisease() {
        return hasHeredityHeartDisease;
    }

    
    /**Set if heart disease is hereditary or not.
     * 
     * @param hasHeredityHeartDisease true if heart 
     * disease is hereditary, false otherwise.
     */
    
    public void setHasHeredityHeartDisease(boolean hasHeredityHeartDisease) {
        this.hasHeredityHeartDisease = hasHeredityHeartDisease;
    }
    
    public VitalSigns addVitalSigns() {
        return vitalSignsHistory.addVitals();
    }
    
    /*
    
    public double getCholestrolNCEP() {
        return cholestrolNCEP;
    }

    public void setCholestrolNCEP(double cholestrolNCEP) {
        this.cholestrolNCEP = cholestrolNCEP;
    }

    public double getCholestrolLDL() {
        return cholestrolLDL;
    }

    public void setCholestrolLDL(double cholestrolLDL) {
        this.cholestrolLDL = cholestrolLDL;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
    
    public double getCholestrolHDL() {
        return cholestrolHDL;
    }

    public void setCholestrolHDL(double cholestrolHDL) {
        this.cholestrolHDL = cholestrolHDL;
    }
    
    */
    
    
/*    
    public float getMyRiskScore() {
        return myRiskScore;
    }

    public void setMyRiskScore(float myRiskScore) {
        this.myRiskScore = myRiskScore;
    }
*/

    
    public VitalSignsHistory getVitalSignsHistory() {
        return vitalSignsHistory;
    }

    public void setVitalSignsHistory(VitalSignsHistory vitalSignsHistory) {
        this.vitalSignsHistory = vitalSignsHistory;
    }
    
    
    public float getAverageRiskScore() {
        return averageRiskScore;
    }

    public void setAverageRiskScore(float averageRiskScore) {
        this.averageRiskScore = averageRiskScore;
    }

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }
}

