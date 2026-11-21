/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

/**
 *
 * @author HP
 */
public class PartTimeEmployee extends Employee {
    
    private double hourlyPaymentRate;
    private int hoursWorked;
    private double totalSalary;

    public PartTimeEmployee(double hourlyPaymentRate, int hoursWorked, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType) {
        super(firstName, lastName, Department, age, employeePosition, employeeType);
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

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    
    
    
    
}
