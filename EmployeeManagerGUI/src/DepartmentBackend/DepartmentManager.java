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
    
    public static void addDepartment(Department department)
    {
        depList.add(department);
    }
    
    public static void loadDepartment(String name, int id){
        Department dep = new Department(name, id);
        dep.setId(id);
        addDepartment(dep);
        
    }
}
