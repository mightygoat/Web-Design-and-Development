package Business;

import Business.EcoSystem.EcoSystem;
import Business.Employee.Employee;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;
import Business.Refugee.Refugee;
/**
 *
 * @author 
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        Employee employee = system.getEmployeeDirectory().createEmployee();
        //Refugee refugee = system.getRefugeeDirectory().createRefugee("REF");
        
        UserAccount ua = system.getUserAccountDirectory().
                createUserAccount("sysadmin", "sysadmin", employee, 
                        new SystemAdminRole());
        
   
        return system;
    }
    
}
