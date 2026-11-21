/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class EmployeeManager {
    
   public static ArrayList<Employee> employees = new ArrayList<>();
    
    public static void addEmployee(Employee emp)
    {
        employees.add(emp);
    }
    
    public static void createFullEmployee(double basicMonthlySalary, double monthlyBonus, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType)
    {
        Employee fullTimeEmp = new FullTimeEmployee(basicMonthlySalary, monthlyBonus, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        addEmployee(fullTimeEmp);
    }
    
    public static void createPartEmployee(double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType)
    {
        Employee partTimeEmp = new PartTimeEmployee(hourlyPaymentRate, hoursWorked, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        addEmployee(partTimeEmp);
    }
    
    public static void loadFullEmployee(int id,double basicMonthlySalary, double monthlyBonus, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType)
    {
        Employee fullTimeEmp = new FullTimeEmployee(basicMonthlySalary, monthlyBonus, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        fullTimeEmp.setEmployeeID(id);
        addEmployee(fullTimeEmp);
    }
    
     public static void loadPartEmployee(int id,double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType)
    {
        Employee partTimeEmp = new PartTimeEmployee(hourlyPaymentRate, hoursWorked, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        partTimeEmp.setEmployeeID(id);
        addEmployee(partTimeEmp);
    }
    
}
