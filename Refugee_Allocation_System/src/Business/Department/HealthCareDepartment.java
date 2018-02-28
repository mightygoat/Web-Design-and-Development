/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.DoctorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class HealthCareDepartment extends Department{

    public HealthCareDepartment() {
        super(Department.Type.HealthcareDeptAdmin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DoctorRole());
        return roles;
    }
     
}