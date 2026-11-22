/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

/**
 *
 * @author HP
 */
public class Department {
    
    private String departmentName;
    private int DepartmentID;

    public Department(String departmentName, int DepartmentID) {
        this.departmentName = departmentName;
        this.DepartmentID = DepartmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }
    
    
    
    
}
