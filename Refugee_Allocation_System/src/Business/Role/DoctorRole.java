/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Country.Country;
import Business.Department.HealthCareDepartment;
import Business.Department.Department;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.HealthDepartment.NurseWorkAreaPanel;

/**
 *
 * @author 
 */
public class DoctorRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Department organization, Country enterprise, EcoSystem business) {
        return new NurseWorkAreaPanel();
    }
    
    
}
