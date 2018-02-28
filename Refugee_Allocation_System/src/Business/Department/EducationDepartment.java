/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;


import Business.Role.EducationHeadRole;
import Business.Role.Role;
import Business.Role.TeacherRole;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class EducationDepartment extends Department{

    public EducationDepartment() {
        super(Department.Type.EducationDeptAdmin.getValue());  
    }

   @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EducationHeadRole());
        return roles;
    }    
}
