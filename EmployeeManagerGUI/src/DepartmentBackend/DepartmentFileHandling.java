/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author maria
 */
public class DepartmentFileHandling {
    
    public static int finalID ;
    
    public static void readFile()
    {
         String line;
        try {
           
            BufferedReader freader = new BufferedReader(new FileReader("DepartmentDetails.csv"));
            while((line=freader.readLine()) != null){
                parseDetails(line);
                
            }
            Department.setDepNum(finalID);
            freader.close();
            
        } catch (FileNotFoundException ex) {
            System.getLogger(DepartmentFileHandling.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
                System.getLogger(DepartmentFileHandling.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        
    }
    
    public static void parseDetails(String details){
        String[] splitDetails= details.trim().split(",");
        int departmentID =Integer.parseInt(splitDetails[0]);
        String departmentName= splitDetails[1];
        DepartmentManager.loadDepartment(departmentName, departmentID);
        finalID = departmentID;
        
    }
}
