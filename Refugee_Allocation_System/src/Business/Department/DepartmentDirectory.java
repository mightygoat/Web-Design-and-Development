/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Department.Department.Type;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class DepartmentDirectory {
    
    private ArrayList<Department> departmentList;

    public DepartmentDirectory() {
        departmentList = new ArrayList<>();
    }

    public ArrayList<Department> getDepartmentList() {
        return departmentList;
    }


    
    public Department createDepartment(Type type){
        Department department = null;
        if (type.getValue().equals(Type.HealthcareDeptAdmin.getValue())){
            department = new HealthCareDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(Type.EmploymentDeptAdmin.getValue())){
            department = new EmploymentDepartment();
            departmentList.add(department);
        }
        else if (type.getValue().equals(Type.EducationDeptAdmin.getValue())){
            department = new EducationDepartment();
            departmentList.add(department);
        }
                else if (type.getValue().equals(Type.HRDeptHead.getValue())){
            department = new HRDepartment();
            departmentList.add(department);
        }
                else if (type.getValue().equals(Type.DeptHead.getValue())){
            department = new CabinetMinistry();
            departmentList.add(department);
        }
        return department;
    }
}