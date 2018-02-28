/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Role.HumanResourceRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Bhanuja Nagore
 */
public class HRDepartment extends Department {
    
        public HRDepartment() {
        super(Department.Type.HRDeptHead.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new HumanResourceRole());
        return roles;
    }
    
}
