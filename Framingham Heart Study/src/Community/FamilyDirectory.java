/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

import java.util.ArrayList;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class FamilyDirectory {
    private ArrayList<Family> families;
    
    public FamilyDirectory(){
        families = new ArrayList<>();
    }
    
    public ArrayList<Family> getFamilies() {
        return families;
    }

    public void setFamilies(ArrayList<Family> families) {
        this.families = families;
    }
    
    public Family addFamily() {
        Family family = new Family();
        families.add(family);
        return family;
    }
}
