/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Country.Country;
import Business.Department.Department;
import Business.UserAccount.UserAccount;
import userinterface.AdministrativeRole.SystemAdminWorkAreaJPanel;
import javax.swing.JPanel;
import userinterface.UNRepresentativeRole.UNRepresentativeWorkAreaJPanel;
import userinterface.UnitedNations.UNWorkAreaJPanel;

/**
 *
 * @author 
 */
public class UnitedNationsEmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
            Department department, Country country, EcoSystem unitedNations) {
        return new UNWorkAreaJPanel(userProcessContainer);
        //return new JPanel();
    }

    
    
}
