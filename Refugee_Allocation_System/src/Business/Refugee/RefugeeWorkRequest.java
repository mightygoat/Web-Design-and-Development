/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Refugee;

import Business.Citizen.CitizenDirectory;
import Business.Country.Country;

import java.util.Date;

/**
 *
 * @author Rohan
 */
public class RefugeeWorkRequest {
    private String message;
    private Country sender;
    private Country receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private CitizenDirectory citizenDirectory;
    
    public RefugeeWorkRequest(){
        requestDate = new Date();
        citizenDirectory = new CitizenDirectory();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Country getSender() {
        return sender;
    }

    public void setSender(Country sender) {
        this.sender = sender;
    }

    public Country getReceiver() {
        return receiver;
    }

    public void setReceiver(Country receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public CitizenDirectory CitizenDirectory() {
        return citizenDirectory;
    }

    public void setCitizenDirectory(CitizenDirectory citizenDirectory) {
        this.citizenDirectory = citizenDirectory;
    }
    
    
    @Override
    public String toString(){
        return this.message;
    }
}
