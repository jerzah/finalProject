/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author erode
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({businessmap.models.dbConnectionTest.class, businessmap.models.BusinessTest.class, businessmap.models.DepartmentTest.class, businessmap.models.EmployeeTest.class})
public class ModelsSuite {
    
}
