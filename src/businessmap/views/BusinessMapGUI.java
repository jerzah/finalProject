/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.views;

import businessmap.controllers.Control;
import businessmap.models.Business;
import businessmap.models.Department;
import businessmap.models.Employee;
import businessmap.models.dbConnection;
import java.sql.SQLException;
import businessmap.models.DepartmentIF;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author erode
 */
public class BusinessMapGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        dbConnection dbCon = new dbConnection();
        
        //needs to be implemented correctly
        //Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a db password: ");
        //dbCon.setPassword(reader.toString());
        //String pass = reader.next();
        //reader.nextLine();
       // System.out.println(pass);
        //dbCon.dropEmployeeTable();
        //dbCon.dropDepartmentTable();
        //dbCon.dropBusinessTable();
        //dbCon.dropSocialMediaTable();
        //dbCon.dropdropSocialMediaAccountTable();
        //dbCon.createNewTables();
        
      
        Control aControl = new Control();
        aControl.addBusiness("Huxley");
                System.out.println( aControl.getClass().getProtectionDomain().getCodeSource().getLocation().getPath() );

       
        mainFrame test = new mainFrame();
        test.setVisible(true);


        // TODO code application logic here
  
       
        //Create Tables
        

        System.out.println("========  Social Media Table ========");
        dbCon.checkTable("Social_Media");
        System.out.println("========  Business Table  ========");
        dbCon.checkTable("Business");
        System.out.println("========  Employee Table  ========");
        dbCon.checkTable("Employee");
        System.out.println("========  Department Table ========");
        dbCon.checkTable("Department");
        System.out.println("========  Social Media Account Table ========");
        dbCon.checkTable("Social_Media_User");
        System.out.println("========  Position Table ========");
        dbCon.checkTable("Position");
        System.out.println("========  Personality Table ========");
        dbCon.checkTable("Personality");


    }

}
