/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem.EcoSystem;
import Business.Country.Country;
import Business.Department.Department;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        Doctor("Doctor"),
        DoctorAssistant("DoctorAssistant"),
        HealthcareDeptAdmin("HealthcareDeptAdmin"),
        EmploymentDeptAdmin("EmploymentDeptAdmin"),
        EmploymentDeptHead("EmploymentDeptHead"),
        EducationDeptAdmin("EducationDeptAdmin"),
        Teacher("Teacher"),
        DeptHead("DeptHead"),
        HRDeptHead("HRDeptHead"),   
        EducationDeptHead("EducationDeptHead"),
        UnitedNationsEmployeeRole("UnitedNationsEmployeeRole"),
        CountryHeadRole("CountryHeadRole");
        
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, 
            UserAccount account, 
            Department department, 
            Country country, 
            EcoSystem business);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}