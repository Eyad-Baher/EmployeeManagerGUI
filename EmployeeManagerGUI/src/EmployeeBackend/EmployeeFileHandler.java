/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;
import DepartmentBackend.Department;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class EmployeeFileHandler {

    private static final String FILE_NAME = "EmployeeDetails.csv";
    public static int FinalID;

    public static String toCSV(Employee emp) {
        if (emp instanceof FullTimeEmployee) {
            return emp.getEmployeeType().toUpperCase() + "," + emp.getEmployeeID() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
                    + emp.getAge() + "," + emp.getDepartment().getDepartmentName() + ","+emp.getDepartment().getDepartmentID()+"," + emp.getEmployeePosition() + ","
                    + ((FullTimeEmployee) emp).getBasicMonthlySalary() + "," + ((FullTimeEmployee) emp).getMonthlyBonus() + ","
                    + emp.calcSalary();
        } else if (emp instanceof PartTimeEmployee) {
            return emp.getEmployeeType().toUpperCase() + "," + emp.getEmployeeID() + "," + emp.getFirstName() + "," + emp.getLastName() + ","
                    + emp.getAge() + "," + emp.getDepartment().getDepartmentName() + ","+emp.getDepartment().getDepartmentID()+"," + emp.getEmployeePosition() + ","
                    + ((PartTimeEmployee) emp).getHourlyPaymentRate() + "," + ((PartTimeEmployee) emp).getHoursWorked() + ","
                    + emp.calcSalary();
        } else {
            return null;
        }
    }

    public static void loadFile() {
        String line;
        try {
            BufferedReader freader = new BufferedReader(new FileReader(FILE_NAME));

            while ((line = freader.readLine()) != null) {

                parseDetails(line);

            }

            Employee.setEmployeeNum(FinalID);
            freader.close();

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
        String empDepName = splitDetails[5];
        int empDepID = Integer.parseInt(splitDetails[6]);
        String empPos = splitDetails[7];
        
        Department empDep = new Department(empDepName, empDepID);
        
        double FullBasicSalary;
        double FullMonthlyBonus;

        double PartHourRate;
        double PartNumHours;

        double empTotalSalary = Double.parseDouble(splitDetails[10]);

        if (empType.equals("FULL")) {
            FullBasicSalary = Double.parseDouble(splitDetails[8]);
            FullMonthlyBonus = Double.parseDouble(splitDetails[9]);

            EmployeeManager.loadFullEmployee(empID, FullBasicSalary, FullMonthlyBonus, empTotalSalary, empFName, empLName, empDep, empAge, empPos, empType);

        } else if (empType.equals("PART")) {
            PartHourRate = Double.parseDouble(splitDetails[8]);
            PartNumHours = Double.parseDouble(splitDetails[9]);

            EmployeeManager.loadPartEmployee(empID, PartHourRate, PartNumHours, empTotalSalary, empFName, empLName, empDep, empAge, empPos, empType);

        }

        if (Employee.getEmployeeNum() == 0) {
            FinalID = 0;
        } else {
            FinalID = empID + 1;

        }

    }

    public static void saveToFile(ArrayList<Employee> employees) {
        try {
            BufferedWriter fwriter = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Employee employee : employees) {

                String empDetails = toCSV(employee);
                fwriter.write(empDetails);
                fwriter.newLine();
            }
            fwriter.close();

        } catch (IOException ex) {
            System.getLogger(EmployeeFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void addToFile(Employee emp) {
        try {
            BufferedWriter fwriter = new BufferedWriter(new FileWriter(FILE_NAME, true));

            fwriter.write(toCSV(emp));
            fwriter.newLine();
            fwriter.close();
        } catch (IOException ex) {
            System.getLogger(EmployeeFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
