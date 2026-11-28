/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employeemanagergui;

import DepartmentBackend.DepartmentFileHandling;
import EmployeeBackend.*;
import EmployeeFrontend.*;
import Login.HomeScreen;
import Login.LoginScreen;

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
        DepartmentFileHandling.readFile();
        EmployeeFileHandler.loadFile();   // 1st: fill the list from EmployeeDetails.csv
        //java.awt.EventQueue.invokeLater(() -> new LoginScreen().setVisible(true));
        java.awt.EventQueue.invokeLater(() -> new HomeScreen().setVisible(true));

    }

}
