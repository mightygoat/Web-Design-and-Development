/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Community;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil
 */
public class Community {
    
    private String communityName;
    private HouseDirectory houses;
    
    public Community() {
        houses = new HouseDirectory();
    }
    
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }
    
    public HouseDirectory getHouses() {
        return houses;
    }
}
