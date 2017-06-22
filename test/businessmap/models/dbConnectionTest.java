/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author erode
 */
public class dbConnectionTest {
    
    private dbConnection connection;
    
    public dbConnectionTest() {
    }

    
    @Before
    public void setUp(){
        try {
            this.connection = new dbConnection();
        } 
        catch (SQLException ex) {
        Logger.getLogger(dbConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void finish() {
        try {
            this.connection.con.close();
        } 
        catch (SQLException ex) {
            Logger.getLogger(dbConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Test of getConnection method, of class dbConnection.
     */
    @Test
    public void testGetConnection() {
        assertNotNull(this.connection);
        assertEquals(this.connection.username,"businessApp");
    }

    /**
     * Test of createNewTables method, of class dbConnection.
     */
    @Test
    public void testCreateNewTables() throws Exception {
    }

    /**
     * Test of dropBusinessTable method, of class dbConnection.
     */
    @Test
    public void testDropBusinessTable() {
    }

    /**
     * Test of checkTable method, of class dbConnection.
     */
    @Test
    public void testCheckTable() throws Exception {
    }
    
}
