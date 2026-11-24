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
        fullTimeEmp.calcSalary();
        addEmployee(fullTimeEmp);
    }

    public static void createPartEmployee(double hourlyPaymentRate, double hoursWorked, double totalSalary, String firstName, String lastName, Department Department, int age, String employeePosition, String employeeType) {
        Employee partTimeEmp = new PartTimeEmployee(hourlyPaymentRate, hoursWorked, totalSalary, firstName, lastName, Department, age, employeePosition, employeeType);
        partTimeEmp.calcSalary();
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

    public static void saveAll() {
        EmployeeFileHandler.saveToFile(employees);
    }

    public static void clearAll() {
        employees.clear();
    }

public static boolean modifyEmployee(int id, String newType,
        double basicMonthlySalary, double monthlyBonus,
        double hourlyRate, double hoursWorked,
        String firstName, String lastName, Department dept,
        int age, String position) {

    int index = findByID(id);
    if (index == -1) return false;

    int oldNum = Employee.getEmployeeNum();
    Employee updated;

    if (newType.equals(Employee.FULL)) {
        updated = new FullTimeEmployee(basicMonthlySalary, monthlyBonus, 0,
                firstName, lastName, dept, age, position, Employee.FULL);
    } else if (newType.equals(Employee.PART)) {
        updated = new PartTimeEmployee(hourlyRate, hoursWorked, 0,
                firstName, lastName, dept, age, position, Employee.PART);
    } else {
        return false; // unsupported type
    }

    updated.setEmployeeID(id);
    Employee.setEmployeeNum(oldNum);
    updated.calcSalary();

    employees.set(index, updated);
    saveAll();
    return true;
}

}
