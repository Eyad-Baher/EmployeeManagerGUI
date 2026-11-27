/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanagergui;
import EmployeeBackend.*;
import EmployeeFrontend.*;

/**
 *
 * @author HP
 */
public class EmployeeManagerGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EmployeeFileHandler.loadFile();   // 1st: fill the list from EmployeeDetails.csv
        java.awt.EventQueue.invokeLater(() -> new OptionEmployeeScreen().setVisible(true));
    }
    
}
