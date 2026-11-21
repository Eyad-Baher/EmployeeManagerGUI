/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeBackend;

/**
 *
 * @author HP
 */
public abstract class Employee {
    
    private static int employeeNum = 0;
    private final int employeeID;
    private String firstName;
    private String lastName;
    private String Department;
    private int age;
    private String employeePosition;
    private String employeeType;

    public Employee(String firstName, String lastName, String Department, int age, String employeePosition, String employeeType) {
       
        this.employeeID = employeeNum;
        employeeNum++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Department = Department;
        this.age = age;
        this.employeePosition = employeePosition;
        this.employeeType = employeeType;
    }
    
    
    
    
}
