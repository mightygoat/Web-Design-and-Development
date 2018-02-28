/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Employee.EmployeeDirectory;
import Business.Role.DeptHeadRole;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Bhanuja Nagore
 */

public class CabinetMinistry extends Department{
    private DepartmentDirectory departmentDirectory;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    
    public CabinetMinistry() {
        super(Department.Type.DeptHead.getValue());
        departmentDirectory = new DepartmentDirectory();
    }
    
    public DepartmentDirectory getDepartmentDirectory() {
        return departmentDirectory;
    }
    
    public DepartmentDirectory addDepartments() {
        departmentDirectory.createDepartment(Type.HealthcareDeptAdmin);
        departmentDirectory.createDepartment(Type.EducationDeptAdmin);
        departmentDirectory.createDepartment(Type.EmploymentDeptAdmin);
        return departmentDirectory;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new DeptHeadRole());
        return roles;
    }
}
