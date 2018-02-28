/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Department;

import Business.Employee.EmployeeDirectory;
import Business.Refugee.RefugeeAllocationWorkQueue;
import Business.Refugee.RefugeeDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public abstract class Department {

    private String name;
    private WorkQueue workQueue;
    private RefugeeAllocationWorkQueue refugeeAllocationWorkQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private RefugeeDirectory refugeeDirectory;
    private int departmentID;
    private static int counter;
    
    public enum Type{
        Admin("Admin Department"), 
        Country("Country Department"), 
        HealthcareDeptAdmin("Healthcare Department"), 
        EducationDeptAdmin("Education Department"),
        EmploymentDeptAdmin("Employment Department"),
        DeptHead("DeptHead"),
        HRDeptHead("HRDeptHead");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Department(String name) {
        this.name = name;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        refugeeDirectory = new RefugeeDirectory();
        departmentID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getDepartmentID() {
        return departmentID;
    }


    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public RefugeeDirectory getRefugeeDirectory() {
        return refugeeDirectory;
    }


    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public RefugeeAllocationWorkQueue getRefugeeAllocationWorkQueue() {
        return refugeeAllocationWorkQueue;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

    @Override
    public String toString() {
        return name;
    }
}