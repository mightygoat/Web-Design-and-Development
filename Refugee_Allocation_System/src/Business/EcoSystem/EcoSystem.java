package Business.EcoSystem;

import Business.Continent.Continent;
import Business.Continent.ContinentDirectory;
import Business.Department.Department;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Refugee.Refugee;
import Business.Refugee.RefugeeDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Role.UnitedNationsEmployeeRole;
import java.util.ArrayList;

/**
 *
 * @author bhanuja
 */
public class EcoSystem extends Department {

    private static EcoSystem business;
    private ArrayList<Continent> continentList;
    private static ContinentDirectory continentDirectory = new ContinentDirectory();
    
    private static RefugeeDirectory refugeeDirectory = new RefugeeDirectory();
    private static EmployeeDirectory employeeDirectory = new EmployeeDirectory();
    
    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null);
        continentList = new ArrayList<>();
        System.out.println("Un Cons");
        
    }
    
    public ContinentDirectory getContinentDirectory() {
        return continentDirectory;
    }

    public Continent createAndAddContinent() {
        Continent continent = continentDirectory.addContinent();
        return continent;
    }

    public static EcoSystem getBusiness() {
        return business;
    }

    public static void setBusiness(EcoSystem business) {
        EcoSystem.business = business;
    }

    public RefugeeDirectory getRefugeeDirectory() {
        return refugeeDirectory;
    }

    public static void setRefugeeDirectory(RefugeeDirectory refugeeDirectory) {
        EcoSystem.refugeeDirectory = refugeeDirectory;
    }
    
    public static void addRefugee(Refugee refugee) {
        refugeeDirectory.addRefugee(refugee);
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public static Employee addEmployeeDirectory() {
        Employee employee = employeeDirectory.createEmployee();
        return employee;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new UnitedNationsEmployeeRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }
}
