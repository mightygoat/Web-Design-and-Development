/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.CountryHead.CountryHead;
import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.Employee.Employee;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeAllocationWorkQueue;
import Business.Role.DeptHeadRole;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author 
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Refugee refugee;
    private Role role;
    private WorkQueue workQueue;
    private RefugeeAllocationWorkQueue refugeeAllocationWorkQueue;
    private CountryHead countryHead;
    private Department department;
    private DepartmentDirectory departmentDirectory;

    public UserAccount() {
        workQueue = new WorkQueue();
    }

    public Refugee getRefugee() {
        return refugee;
    }

    public void setRefugee(Refugee refugee) {
        this.refugee = refugee;
    }

    public CountryHead getCountryHead() {
        return countryHead;
    }

    public void setCountryHead(CountryHead countryHead) {
        this.countryHead = countryHead;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentDirectory getDepartmentDirectory() {
        return departmentDirectory;
    }

    public void setDepartmentDirectory(DepartmentDirectory departmentDirectory) {
        this.departmentDirectory = departmentDirectory;
    }

    public RefugeeAllocationWorkQueue getRefugeeAllocationWorkQueue() {
        return refugeeAllocationWorkQueue;
    }
    
    
    
    @Override
    public String toString() {
        return username;
    }
    
    
    
}