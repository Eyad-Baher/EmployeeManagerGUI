/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

import java.io.*;
import java.lang.ref.Cleaner;

/**
 *
 * @author HP
 */
public class EmployeeFileHandler {
    
    public static int FinalID;

    public static String toCSV(Employee emp) {
        if (emp instanceof FullTimeEmployee) {
            return emp.getEmployeeType().toUpperCase() + "," + emp.getEmployeeID() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
                    + emp.getAge() + "," + emp.getDepartment() + "," + emp.getEmployeePosition() + ","
                    + ((FullTimeEmployee) emp).getBasicMonthlySalary() + "," + ((FullTimeEmployee) emp).getMonthlyBonus() + ","
                    + ((FullTimeEmployee) emp).getTotalSalary();
        } else if (emp instanceof PartTimeEmployee) {
            return emp.getEmployeeType() + "," + emp.getEmployeeID() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
                    + emp.getAge() + "," + emp.getDepartment() + "," + emp.getEmployeePosition() + ","
                    + ((PartTimeEmployee) emp).getHourlyPaymentRate() + "," + ((PartTimeEmployee) emp).getHoursWorked()
                    + ((PartTimeEmployee) emp).getTotalSalary();
        } else {
            return null;
        }
    }

    public static void loadFile() {
        String line;
        try {
            BufferedReader freader = new BufferedReader(new FileReader("EmployeeDeatils.csv"));

            while ((line = freader.readLine()) != null) {
                
                parseDetails(line);

            }
            
            Employee.setEmployeeNum(FinalID);

        } catch (FileNotFoundException ex) {
            System.getLogger(EmployeeFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(EmployeeFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void parseDetails(String details) {
        String[] splitDetails = details.trim().split(",");

        String empType = splitDetails[0];
        int empID = Integer.parseInt(splitDetails[1]);
        String empFName = splitDetails[2];
        String empLName = splitDetails[3];
        int empAge = Integer.parseInt(splitDetails[4]);
        String empDep = splitDetails[5];
        String empPos = splitDetails[6];

        double FullBasicSalary;
        double FullMonthlyBonus;

        double PartHourRate;
        int PartNumHours;

        double empTotalSalary = Double.parseDouble(splitDetails[9]);

        if (empType.equals("FULL")) {
            FullBasicSalary = Double.parseDouble(splitDetails[7]);
            FullMonthlyBonus = Double.parseDouble(splitDetails[8]);

            EmployeeManager.loadEmployee(empID,FullBasicSalary, FullMonthlyBonus, empTotalSalary, empFName, empLName, empDep, empAge, empPos, empType);

        } else if (empType.equals("PART")) {
            PartHourRate = Double.parseDouble(splitDetails[7]);
            PartNumHours = Integer.parseInt(splitDetails[8]);
            
            EmployeeManager.loadEmployee(empID,PartHourRate, PartNumHours, empTotalSalary, empFName, empLName, empDep, empAge, empPos, empType);

        }

        FinalID = empID;
    }

}
