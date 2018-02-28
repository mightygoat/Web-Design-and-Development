/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Country;

import Business.CountryHead.CountryHead;
import Business.CountryHead.CountryHeadDirectory;
import Business.Department.Department;
import Business.Department.DepartmentDirectory;
import Business.Department.CabinetMinistry;
import Business.Employee.EmployeeDirectory;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeDirectory;
import Business.Role.CountryHeadRole;

import Business.Role.Role;
import static Business.Role.Role.RoleType.CountryHeadRole;
import Business.Role.UNRepresentativeRole;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Country extends Department{

    private CountryType countryType;
    private RefugeeDirectory intakeRefugees;
    private RefugeeDirectory avalaibleRefugees;
    private CountryHead countryHead;
    private EmployeeDirectory employeeDirectory;
//    private CountryHeadDirectory countryHeadDirectory;
    private CabinetMinistry cabinetMinistry;
    private UserAccountDirectory userAccountDirectory;
    
    public Country(String name) {
        super(name);    
        intakeRefugees = new RefugeeDirectory();
        avalaibleRefugees = new RefugeeDirectory();
//        countryHead = new CountryHead();
        cabinetMinistry = new CabinetMinistry();
  //      countryHeadDirectory = new CountryHeadDirectory(); 
         userAccountDirectory = new UserAccountDirectory();
         employeeDirectory = new EmployeeDirectory();
    }
    
    public void setCountryType(CountryType type) {
        this.countryType = type;
    }

/*
    public CountryHeadDirectory getCountryHeadDirectory() {
        return countryHeadDirectory;
    }
*/
    
    public enum CountryType{
        RefugeeSender("RefugeeSender"), 
        RefugeeReceiver("RefugeeReceiver");

        private String value;

        private CountryType(String value) {
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

    public CountryType getCountryType() {
        return countryType;
    }

    
    public RefugeeDirectory getIntakeRefugees() {
        return intakeRefugees;
    }

    public Refugee addIntakeRefugee() {
        Refugee refugee = new Refugee();
        return intakeRefugees.addRefugee(refugee);
    }

    public RefugeeDirectory getAvalaibleRefugees() {
        return avalaibleRefugees;
    }

    public Refugee addAvalaibleRefugees() {
        Refugee refugee = new Refugee();
        return intakeRefugees.addRefugee(refugee);
    }

    public CountryHead getCountryHead() {
        return countryHead;
    }

    public void setCountryHead(CountryHead countryHead) {
        this.countryHead = countryHead;
    }
    
    public CabinetMinistry getCabinetMinistry() {
        return cabinetMinistry;
    }

    public CabinetMinistry createCabinetMinistry() {
        cabinetMinistry = new CabinetMinistry();
        return cabinetMinistry;
    }
    
   
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new CountryHeadRole());
        roleList.add(new UNRepresentativeRole());
        return roleList;
    }
}