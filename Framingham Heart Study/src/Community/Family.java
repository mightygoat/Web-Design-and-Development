/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import Person.PersonDirectory;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Family {
    private PersonDirectory personDirectory;
    private String familyName;
    private static int id;
    
    
    
    public Family() {
        personDirectory = new PersonDirectory();
        id++;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }
  
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public static int getId() {
        return id;
    }
}
