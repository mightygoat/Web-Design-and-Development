/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Patient;

import java.util.Date;

/**
 *
 * @author Rohan Jahagirdar, Bhanuja Nagore, Manish Patil 
 */
public class VitalSigns {
    
    private Date date;
    
    private double temperature;
    private int pulse;
    private double cholestrolNCEP;
    private double cholestrolLDL;
    
    private double cholestrolHDL;
    private int bloodPressureLow;
    private int bloodPressureHigh;
    
    private float riskScore;

    
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

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCholestrolHDL() {
        return cholestrolHDL;
    }

    public void setCholestrolHDL(double cholestrolHDL) {
        this.cholestrolHDL = cholestrolHDL;
    }

    public int getBloodPressureLow() {
        return bloodPressureLow;
    }

    public void setBloodPressureLow(int bloodPressureLow) {
        this.bloodPressureLow = bloodPressureLow;
    }

    public int getBloodPressureHigh() {
        return bloodPressureHigh;
    }

    public void setBloodPressureHigh(int bloodPressureHigh) {
        this.bloodPressureHigh = bloodPressureHigh;
    }

    public float getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(float riskScore) {
        this.riskScore = riskScore;
    }
}