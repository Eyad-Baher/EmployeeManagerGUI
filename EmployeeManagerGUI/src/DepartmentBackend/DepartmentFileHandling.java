/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

/**
 *
 * @author maria
 */
public class DepartmentFileHandling {
    
    public static void readFile()
    {
        
    }
    
    public static void parseDetails(String details){
        String[] splitDetails= details.trim().split(",");
        int departmentID =Integer.parseInt(splitDetails[0]);
        String departmentName= splitDetails[1];
        DepartmentManager.loadDepartment(departmentName, departmentID);
        
        
    }
}
