/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.AdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class AdminDepartment extends Department{

    public AdminDepartment() {
        super(Type.Admin.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new AdminRole());
        return roles;
    }
     
}
