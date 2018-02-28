/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Country.Country;
import Business.Department.Department;
import Business.Department.CabinetMinistry;
import Business.EcoSystem.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.Cabinet.DeptHeadWorkAreaJPanel;

/**
 *
 * @author Bhanuja Nagore
 */
public class DeptHeadRole extends Role{
    
       @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department department, Country country, EcoSystem business) {
        return new DeptHeadWorkAreaJPanel (userProcessContainer, account, 
                (CabinetMinistry)department, country);
    }
    
    
}
