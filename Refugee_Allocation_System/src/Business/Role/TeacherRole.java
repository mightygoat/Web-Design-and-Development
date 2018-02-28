/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Country.Country;
import Business.Department.Department;
import Business.EcoSystem.EcoSystem;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userinterface.EducationDepartment.TeacherWorkAreaPanel;

/**
 *
 * @author Manish
 */
public class TeacherRole extends Role{
    
    public TeacherRole(){
        
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Department department, Country country, EcoSystem business) {
        return new TeacherWorkAreaPanel(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
