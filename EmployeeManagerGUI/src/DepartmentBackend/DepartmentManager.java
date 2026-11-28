/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

import static DepartmentBackend.DepartmentFileHandling.saveToFile;
import DepartmentBackend.Exceptions.DepartmentInUseException;
import DepartmentBackend.Exceptions.DepartmentNotFoundException;
import EmployeeBackend.Employee;
import EmployeeBackend.EmployeeManager;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class DepartmentManager {
    private static ArrayList<Department> depList  = new ArrayList<>();
    
    
    public static Department getDepartmentById(int id)
    {
        for(Department d: DepartmentManager.depList)
        {
            if(d.getId()==id)
                return d;
        }
        return null;
    }
    
    public static Department getDepartmentByName(String name)
    {
        for(Department d: DepartmentManager.depList)
        {
            if(name.trim().equalsIgnoreCase(d.getName().trim()))
                return d;
        }
        return null;
    }
    public static ArrayList<Department> getDepList()
    {
        return depList;
    }
    
    //mariam's addDepartment:
    public static boolean addDepartment(String name)
    {
        if(name==null || name.trim().equals(""))
            return false;
        else
        {
            name=name.trim();
            for(Department dep:depList)
            {
                if(name.equalsIgnoreCase(dep.getName()))
                    return false;
            }
        }
        
        Department newDepartment = new Department(name );
        depList.add(newDepartment);
        return true;
    }
    
    
    //mariam's loadDepartment:
    public static void loadDepartment(String name, int id){
        
        if(name==null || name.trim().equals(""))
            return;
        Department dep = new Department(name, id);
        depList.add(dep);
        
    }
    
    public static void deleteDepartment(int id){
        Department target = null;
        for ( Department d :depList){
            if (d.getId() == id){
                target = d;
                break;
            }
        }
        if ( target == null)
            throw new DepartmentNotFoundException("Error department with ID: " + id + "was not found!");
        else 
        {
            int found = 0;
            for (Employee e : EmployeeManager.getEmployees())
            {
                if (target.getName().equalsIgnoreCase(e.getDepartment().getName()))
                {
                    found = 1;
                    break;
                }
            }
            if (found==1)
                throw new DepartmentInUseException("Error can't delete the " + target.getName() + "department! \n Department has employee(s) assigned to it.");
        }
        depList.remove(target);
        saveToFile();
    }
    
    
    //mariam's getDepEmps:
    public static ArrayList<Employee> getDepEmps(Department dep)
    {
        ArrayList<Employee> depEmps = new ArrayList();
        for(Employee e: EmployeeManager.getEmployees())
        {
            if(dep.getName().trim().equalsIgnoreCase(e.getDepartment().getName().trim()))
                depEmps.add(e);
        }
        return depEmps;
    }
}
