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
        
        InputStreamReader cin = new InputStreamReader(System.in);
        dbCon.setPassword(cin.toString());
        
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
