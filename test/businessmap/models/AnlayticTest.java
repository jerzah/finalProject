/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessmap.models;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author erode
 */
public class AnlayticTest {
    
    
    @Test
    public void testCreateObj() 
    {
          Business bus = new Business("Test Business");
          Analytics analytic = new Analytics(bus);
          assertNotNull(analytic);
    }


    /**
     * Test of setName method
     */
    @Test
    public void testSetBusiness() 
    {
        Business bus = new Business("Test Business");
        Analytics analytic = new Analytics();
        assertNull(analytic.getBusiness());
        analytic.setBusiness(bus);
        assertEquals(analytic.getBusiness(), bus);
        analytic.setBusiness(new Business("testBusiness"));
        bus =  analytic.getBusiness();
        assertEquals(analytic.getBusiness(),bus);
    }
    
    @Test
    public void TestcountDept()
    {
        Business aBus = new Business("Huxley");
        aBus.isSaved();
        aBus.populateDepartments();
        int size = aBus.getDepartments().size();
        
        Analytics testAn = new Analytics();
        testAn.setBusiness(aBus);
        assertEquals(testAn.getBusiness(), aBus);
     //   assertEquals(testAn.countDept(), size);
    }
    
    @Test
    public void TestiniCount()
    {
        Business aBus = new Business("Huxley");
        Analytics testAn = new Analytics();
        assertEquals(testAn.getBusiness(), null);
        testAn.setBusiness(aBus);
        assertEquals(testAn.getBusiness(), aBus);

        aBus.isSaved();
        aBus.populateDepartments();
        assertEquals(testAn.getBusiness(), aBus);
        Map<String, Integer> aMap = new HashMap<>();
        Integer busCount = 1;
        Integer empCount = 2;

        assertEquals(testAn.iniCount().getClass(), aMap.getClass());
        assertEquals(testAn.iniCount().containsKey("Departments"),true);
        assertEquals(testAn.iniCount().containsKey("Employees"),true);
        
        assertEquals(testAn.iniCount().get("Departments"), busCount );
        assertEquals(testAn.iniCount().get("Employees"), empCount );



    }

    
}
