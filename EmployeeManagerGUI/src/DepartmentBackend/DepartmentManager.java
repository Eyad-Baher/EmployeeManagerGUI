/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class DepartmentManager {
    public static ArrayList<Department> depList  = new ArrayList<>();
    
    public static boolean addDepartment(Department newDepartment)
    {
        if(newDepartment.getName()==null || newDepartment.getName().equals(""))
            return false;
        else
        {
            for(Department dep:depList)
            {
                if(newDepartment.getName().equalsIgnoreCase(dep.getName()))
                    return false;
            }
        }
        depList.add(newDepartment);
        return true;
    }
    
    public static void loadDepartment(String name, int id){
        Department dep = new Department(name);
        dep.setId(id);
        addDepartment(dep);
        
    }
}
