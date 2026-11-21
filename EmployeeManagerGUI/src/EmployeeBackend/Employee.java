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
    private int employeeID;
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

    public static int getEmployeeNum() {
        return employeeNum;
    }

    public static void setEmployeeNum(int employeeNum) {
        Employee.employeeNum = employeeNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    protected void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }
    

    
    
    
    public abstract double calcSalary();
    
    
}
