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


public class FraminghamTown {
    private CommunityDirectory communityDirectory;
    
    public FraminghamTown() {
        communityDirectory = new CommunityDirectory();
    }

    public CommunityDirectory getCommunityDirectory() {
        return communityDirectory;
    }

    public Community addCommunity() {
        Community community = communityDirectory.addCommunity();
        return community;
    }    
}