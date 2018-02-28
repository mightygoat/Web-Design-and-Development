/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Education;

import java.util.ArrayList;

/**
 *
 * @author Manish
 */
public class Education {
    private ArrayList<Degree> degreesList;
    
    public Education() {
        degreesList = new ArrayList<>();
    }
    
    public ArrayList<Degree> getDegreesList() {
        return degreesList;
    }
    
    public Degree addDegree() {
        Degree degree = new Degree();
        degreesList.add(degree);
        return degree;
    }
}
