/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;
import Person.Gender;
import Person.Person;

/**
 *
 * @author @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Patient extends Person{
    private int patientId;
    //private VitalSignsHistory vitalSignsHistory;
    private Person personWithHeartDieaseInFamily;
    private int personId;
    //private float myRiskScore;
    public Gender gender;
    
    
    public Patient() {
        personWithHeartDieaseInFamily = null;
    }
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    

    public Person getPersonWithHeartDieaseInFamily() {
        return personWithHeartDieaseInFamily;
    }

    public void setPersonWithHeartDieaseInFamily(Person person) {
        this.personWithHeartDieaseInFamily = person;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }
    
    
    
  
    //----------------------Bhanuja---------------------//
    
    
     
/*
    public void calltheScore() {
            myRiskScore = myScore(age, smoker, gender,
			 diabetic, heredity);
            setMyRiskScore(myRiskScore);
    }

    public void displaytheScore() {
            System.out.println("The risk is " + myRiskScore);
    }
*/
}
