/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Education;

import java.util.Date;

/**
 *
 * @author Rohan
 */
public class Degree {
    private String collegeName;
    private Date startDate;
    private Date endDate;
    private String degreeName;
    private String degreeHolderName;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }    

    public String getDegreeHolderName() {
        return degreeHolderName;
    }

    public void setDegreeHolderName(String degreeHolderName) {
        this.degreeHolderName = degreeHolderName;
    }
}
