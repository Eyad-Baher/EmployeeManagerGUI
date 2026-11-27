/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBackend;

import java.util.ArrayList;

/**
 *
 * @author Lina Islam
 */
public class AdminManager {
    public static ArrayList<Admin> admins = new ArrayList<>();
    
    public static void loadAdmins(String name , String password){
        if((name==null || password == null) || (name.isEmpty() || password.isEmpty()))
            return;
        Admin admin = new Admin(name,password);
        admins.add(admin);
    }
    
    
    
}
