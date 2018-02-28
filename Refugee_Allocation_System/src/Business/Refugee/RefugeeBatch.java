/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Refugee;

import Business.Country.Country;
import java.util.Date;

/**
 *
 * @author Rohan
 */
public class RefugeeBatch {
    private Country country;
    private RefugeeDirectory refugeeDirectory;
    private Date dateOfReport;
    
    public RefugeeBatch() {
        refugeeDirectory = new RefugeeDirectory();
        dateOfReport = new Date();       
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public RefugeeDirectory getRefugeeDirectory() {
        return refugeeDirectory;
    }

    public void setRefugeeDirectory(RefugeeDirectory refugeeDirectory) {
        this.refugeeDirectory = refugeeDirectory;
    }

    public Date getDateOfReport() {
        return dateOfReport;
    }

    public void setDateOfReport(Date dateOfReport) {
        this.dateOfReport = dateOfReport;
    }
}