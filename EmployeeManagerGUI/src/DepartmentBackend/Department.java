/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend;

/**
 *
 * @author maria
 */
public class Department {
    private static int depNum=0;
    private String name;
    private int id;

    public Department(String name) {
        this.name = name;
        depNum++;
        this.id = depNum;
        
    }
    
    public Department(String name, int id) {   
    this.name = name;
    this.id = id;
}

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public static int getDepNum() {
        return depNum;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    protected void setId(int id) {
        this.id = id;
    }

    public static void setDepNum(int depNum) {
        Department.depNum = depNum;
    }
   
}
