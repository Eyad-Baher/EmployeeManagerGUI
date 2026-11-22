/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

import DepartmentBackend.Department;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class EmployeeManager {

    private static ArrayList<Employee> employees = new ArrayList<>();

    public static void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void createFullEmployee(double basicMonthlySalary, double monthlyBonus, double totalSalary, String firstName, String lastName, Department Department, int age, String employeePosition, String employeeType) {
        Employee fullTimeEmp = new FullTimeEmployee(basicMonthlySalary, monthlyBonus, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        addEmployee(fullTimeEmp);
    }

    public static void createPartEmployee(double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, Department Department, int age, String employeePosition, String employeeType) {
        Employee partTimeEmp = new PartTimeEmployee(hourlyPaymentRate, hoursWorked, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        addEmployee(partTimeEmp);
    }

    public static void loadFullEmployee(int id, double basicMonthlySalary, double monthlyBonus, double totalSalary, String firstName, String lastName, Department Department, int age, String employeePosition, String employeeType) {
        Employee fullTimeEmp = new FullTimeEmployee(basicMonthlySalary, monthlyBonus, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        fullTimeEmp.setEmployeeID(id);
        addEmployee(fullTimeEmp);
    }

    public static void loadPartEmployee(int id, double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, Department Department, int age, String employeePosition, String employeeType) {
        Employee partTimeEmp = new PartTimeEmployee(hourlyPaymentRate, hoursWorked, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        partTimeEmp.setEmployeeID(id);
        addEmployee(partTimeEmp);
    }

    public static int findByID(int empID) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmployeeID() == empID) {
                return i;
            }
        }
        return -1;
    }

    public static int findByDepartment(Department empDep) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getDepartment().getDepartmentName().toLowerCase().equals(empDep.getDepartmentName().toLowerCase())) {

                return i;

            }
        }
        return -1;
    }

    public static boolean deleteEmployee(int empID) {
        int index = findByID(empID);

        if (index != -1) {
            employees.remove(index);
            return true;

        } else {
            return false;
        }

    }
    
    public static void saveAll()
    {
        EmployeeFileHandler.saveToFile(employees);
    }
    
    public static void clearAll()
    {
        employees.clear();
    }
    
    public static void modifyEmployee(int empID)
    {
        int index = findByID(empID);
        
        
    }

}
