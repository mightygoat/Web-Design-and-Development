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
public class CommunityDirectory {
    private ArrayList<Community> communitites;

    public CommunityDirectory() {
        communitites = new ArrayList<>();
    }

    public ArrayList<Community> getCommunitites() {
        return communitites;
    }

    public Community addCommunity() {
        Community community = new Community();
        communitites.add(community);
        return community;
    }
} 