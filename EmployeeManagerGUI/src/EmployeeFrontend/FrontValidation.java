/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeFrontend;

/**
 *
 * @author HP
 */
public class FrontValidation {
    
    public static boolean validateName(String name)
    {
     if (name == null) {
        return false;
    }
    for (int i = 0; i < name.length(); i++) {
        if (Character.isDigit(name.charAt(i))) {
            return false;
        }
    }
    return true;
    }
    
    
    
    
}
