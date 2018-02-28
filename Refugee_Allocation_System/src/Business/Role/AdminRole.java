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

/**
 *
 * @author 
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,
            Department department, Country country, EcoSystem business) {
        return new SystemAdminWorkAreaJPanel(userProcessContainer);
        //return new JPanel();
    }

    
    
}
