/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EmployeeFrontend;

import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FrontValidation {

    public static boolean validateName(String name) {
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

    public static boolean validateAnyName(String firstName) {

        if (firstName.isBlank() || firstName.isEmpty() || !validateName(firstName)) {
            JOptionPane.showMessageDialog(null, "please enter valid name");
            return false;
        } else {
            return true;
        }

    }

    public static boolean validateAge(String ageStr) {
        try {
            int age = Integer.parseInt(ageStr);
            if (age <= 0) {
                JOptionPane.showMessageDialog(null, "Enter a valid age");
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid age.");
            return false;
        }

        return true;
    }

    public static boolean validatePosn(String posn) {
        if (posn.isBlank()) {
            JOptionPane.showMessageDialog(null, "Invalid position");
            return false;
        } else {
            return true;
        }

    }

    public static boolean validateNums(String numStr) {
        try {
            double num = Double.parseDouble(numStr);
            if (num < 0) {
                return false;
            }
        } catch (NumberFormatException ex) {

            return false;
        }
        return true;
    }
}
