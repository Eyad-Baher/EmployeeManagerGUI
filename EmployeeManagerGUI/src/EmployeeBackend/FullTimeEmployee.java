/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

/**
 *
 * @author HP
 */
public class FullTimeEmployee extends Employee{
    
        private double basicMonthlySalary;
        private double monthlyBonus;
        private double totalSalary;

    public FullTimeEmployee(double basicMonthlySalary, double monthlyBonus, double totalSalary, String firstName, String lastName, String Department, int age, String employeePosition, String employeeType) {
        super(firstName, lastName, Department, age, employeePosition, employeeType);
        this.basicMonthlySalary = basicMonthlySalary;
        this.monthlyBonus = monthlyBonus;
        this.totalSalary = totalSalary;
    }

    public double getBasicMonthlySalary() {
        return basicMonthlySalary;
    }

    public void setBasicMonthlySalary(double basicMonthlySalary) {
        this.basicMonthlySalary = basicMonthlySalary;
    }

    public double getMonthlyBonus() {
        return monthlyBonus;
    }

    public void setMonthlyBonus(double monthlyBonus) {
        this.monthlyBonus = monthlyBonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }
        
        
     
}
