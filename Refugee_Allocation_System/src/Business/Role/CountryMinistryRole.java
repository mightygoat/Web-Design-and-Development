/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Country.Country;
import Business.Department.CabinetMinistry;
import Business.Department.Department;
import Business.EcoSystem.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Cabinet.DeptHeadWorkAreaJPanel;
import userinterface.HealthDepartment.NurseWorkAreaPanel;

/**
 *
 * @author Manish Patil
 */
public class CountryMinistryRole extends Role {
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, 
            Department organization, Country enterprise, EcoSystem business) {
        return new DeptHeadWorkAreaJPanel(userProcessContainer,account, (CabinetMinistry)organization,enterprise);
    }
}