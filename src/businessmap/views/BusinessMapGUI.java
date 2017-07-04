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
    public static void main(String[] args) throws SQLException {
        dbConnection dbCon = new dbConnection();
        
        //needs to be implemented correctly
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a db password: ");
        dbCon.setPassword(reader.toString());
       // String pass = reader.next();
       // reader.nextLine();
       // System.out.println(pass);
       
        mainFrame test = new mainFrame();
        test.setVisible(true);


        // TODO code application logic here
  
       /*
        Create Tables
        */
        //dbCon.createNewTables();
        Control aControl = new Control();
        //aControl.addBusiness("Husxley");
        
        System.out.println("========  Business Table  ========");
        dbCon.checkTable("Business");
        System.out.println("========  Employee Table  ========");
        dbCon.checkTable("Employee");
        System.out.println("========  Department Table ========");
        dbCon.checkTable("Department");
        
        /*
        Delete tables
        */
        //dbCon.dropEmployeeTable();
        //dbCon.dropDepartmentTable();
        //dbCon.dropBusinessTable();

    }

}
