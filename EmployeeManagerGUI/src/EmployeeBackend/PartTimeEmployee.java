/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

import DepartmentBackend.Department;

/**
 *
 * @author HP
 */
public class PartTimeEmployee extends Employee {
    
    private double hourlyPaymentRate;
    private double hoursWorked;
    private double totalSalary;

    public PartTimeEmployee(double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, Department department, int age, String employeePosition, String employeeType) {
        super(firstName, lastName, department, age, employeePosition, employeeType);
        this.hourlyPaymentRate = hourlyPaymentRate;
        this.hoursWorked = hoursWorked;
        this.totalSalary = totalSalary;
    }



    public double getHourlyPaymentRate() {
        return hourlyPaymentRate;
    }

    public void setHourlyPaymentRate(double hourlyPaymentRate) {
        this.hourlyPaymentRate = hourlyPaymentRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    @Override
    public double calcSalary() {
        totalSalary = hourlyPaymentRate * hoursWorked;
        
        return totalSalary;
    }

    
    
    
    
}
