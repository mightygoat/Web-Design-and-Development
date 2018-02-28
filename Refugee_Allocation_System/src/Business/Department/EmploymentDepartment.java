/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.EmployementHeadRole;
import Business.Role.HumanResourceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class EmploymentDepartment extends Department{

    public EmploymentDepartment() {
        super(Department.Type.EmploymentDeptAdmin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EmployementHeadRole());
        return roles;
    }    

}
