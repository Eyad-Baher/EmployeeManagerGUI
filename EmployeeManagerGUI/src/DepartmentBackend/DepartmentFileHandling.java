/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class DepartmentFileHandling {
    public static final String DFILENAME = "DepartmentDetails.csv";
    public static int finalID ;
    
    public static String toCSV(Department department){
        if(department != null)
        return department.getId()+ "," + department.getName();
        else
            return null;
    }
    
    public static void readFile()
    {
         String line;
         DepartmentManager.getDepList().clear();
         finalID=0;
        try {
           
            BufferedReader freader = new BufferedReader(new FileReader(DFILENAME));
            while((line=freader.readLine()) != null){
                parseDetails(line);
                
            }
            Department.setDepNum(finalID);
            freader.close();
            
        } catch (FileNotFoundException ex) {
            return;
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error while loading departments", "Error", JOptionPane.WARNING_MESSAGE);
            }
        
    }
    
    public static void parseDetails(String details){
        String[] splitDetails= details.trim().split(",");
        int departmentID =Integer.parseInt(splitDetails[0]);
        String departmentName= splitDetails[1];
        DepartmentManager.loadDepartment(departmentName, departmentID);
        finalID = departmentID;
        
    }
    
    public static void saveToFile(){
         
        try {
            BufferedWriter fwriter = new BufferedWriter(new FileWriter(DFILENAME));
            for (Department dep: DepartmentManager.getDepList())
            {
                String depDetails = toCSV(dep);
                fwriter.write(depDetails);
                fwriter.newLine();
                
            } fwriter.close();
        } catch (IOException ex) {
            System.getLogger(DepartmentFileHandling.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
    }
    
    public static boolean addDepToFile(Department dep)
    {
        try {
            BufferedWriter fwriter = new BufferedWriter(new FileWriter(DFILENAME,true));
            fwriter.write(dep.getId()+","+dep.getName());
            fwriter.newLine();
            fwriter.close();
            return true;
        } catch (IOException ex) {
            //System.getLogger(DepartmentFileHandling.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            return false;
        }
    }
    
    
}
