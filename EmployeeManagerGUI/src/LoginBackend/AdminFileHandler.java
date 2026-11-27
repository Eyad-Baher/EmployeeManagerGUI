/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LoginBackend;

import static LoginBackend.AdminManager.admins;
import static LoginBackend.AdminManager.loadAdmins;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Lina Islam
 */
public class AdminFileHandler {
    
    public static final String AFILENAME ="AdminDetails.csv";
    
    public static void loadFile()
    {
        BufferedReader freader = null;
        try {
            String line;
            admins.clear();
            freader = new BufferedReader(new FileReader(AFILENAME));
            while((line=freader.readLine()) != null)
            {
                parseDetails(line);
            }
            freader.close();
        } catch (FileNotFoundException ex) {
            System.getLogger(AdminFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        
            } catch (IOException ex) {
                System.getLogger(AdminFileHandler.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        
    }
    
    public static void parseDetails(String details){
        String[] splitDetails = details.trim().split(",");
        String adminName= splitDetails[0];
        String adminPassword = splitDetails[1];
        loadAdmins(adminName,adminPassword);
        
    }
    
}
