import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private MenuItem m1;
    private User u1;
    private School s1;
    private Order o1;
    private Parent p1;
    private Admin a1;
    private Vendor v1;
    private PaymentMethod pm1;
    

    private ArrayList<MenuItem> menuList;
    private ArrayList<User> userList;
    private ArrayList<School> schoolList;
    private ArrayList<Order> orderList;
    private ArrayList<Vendor> vendorList;
    private ArrayList<PaymentMethod> paymentMethodList;

    public C206_CaseStudyTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // prepare test data
        m1 = new MenuItem("Taco", 2);
        u1= new User("ashhhlolol", "Password1234");
		s1 = new School("Republic Poly", 4);
		a1= new Admin("waynerei", "Password1234");
		p1 = new Parent("mother", "Password1234", "Credit Billing");
		v1 =new Vendor("vendor", "Password1234", "11111111", "address");
		o1 = new Order(parentMenu.get(0), "Ramen");

        menuList = new ArrayList<MenuItem>();
    }

    @Test
    public void testAddMenu() {
        // Item list is not null, so that can add a new item - boundary
        assertNotNull("Test if menu can be added", menuList);
        
        // ... (other testAddMenu assertions)
       Main.addMenu(menuList, m1);
		assertEquals("Check that Menu arraylist size is 1", 1, menuList.size());
		assertSame("Check that Menu is added",m1, menuList.get(0));

    }

    @Test
    public void testUpdateMenu() {
        // Item list is not null, so that can add a new item - boundary
        assertNotNull("Test if there is valid menuItem to add to", menuList);
        
        // ... (other testUpdateMenu assertions)
        Main.updateMenu(menuList, m1);
		assertEquals("Check that Menu arraylist size is 1", 1, menuList.size());
		assertSame("Check that Menu is added",m1, menuList.get(0));


    }

    @Test
    public void testDeleteMenu() {
        // Test if Item list is not null but empty -boundary
        assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", menuList);

        // ... (other testDeleteMenu assertions)
        Main.deleteMenu(menuList, m1);
		assertEquals("Check that Menu arraylist size is 1", 1, menuList.size());
		assertSame("Check that Menu is added",m1, menuList.get(0));


    }
    
    @Test
    public void testDeleteOrder() {
        assertNotNull("Test if there is a valid orderList to delete", orderList);

        Main.removeOrder(orderList, o1); // Modify the second argument based on your order ID
        assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
        assertSame("Check that Order is added", o1, orderList.get(0));
    }

    @Test
    public void testAddAccount() {
        assertNotNull("Test if there is valid addAccount to retrieve account from", userList);
        
        // ... (other testRegisterAccount assertions)
        Main.addAccount(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that Account is added",a1, userList.get(0));


    }


    @Test
    public void testDoAddMenu() {
        assertNotNull("Test if there is valid menuItem to add to", menuList);
        
        // ... (other testDoAddMenu assertions)
        Main.addMenu(menuList, m1);
		// normal
		Boolean ok = Main.doAddMenu(menuList,"Taco", 2);
		assertTrue("Test if an available item is ok to add?", ok);
		//error condition
		ok = Main.doAddMenu(menuList,"Taco", 2);
		assertFalse("Test if an same item is NOT ok to add again?", ok);	
		//error condition
		Main.addMenu("Taco", 2);	
		m1.setIsAvailable(false);
		ok = Main.doAddMenu(menuList,"Taco", 2);
		assertFalse("Test that un-available item is NOT ok to add?", ok);
		//error condition
		ok = Main.doAddMenu(menuList,"Taco", 2);
		assertFalse("Test that non-esiting item is NOT ok to add?", ok);

    }

    @Test
    public void testDoUpdateMenu() {
        assertNotNull("Test if there is valid menuitem to update to", menuList);
        
        // ... (other testDoUpdateMenu assertions)
        Main.updateMenu(menuList, m1);
		// normal
		Boolean ok = Main.doUpdateMenu(menuList,"Taco", 2);
		assertTrue("Test if an available item is ok to update?", ok);
		//error condition
		ok = Main.doUpdateMenu(menuList,"Taco", 2);
		assertFalse("Test if an same item is NOT ok to update again?", ok);	
		//error condition
		Main.updateMenu("Taco", 2);	
		m1.setIsAvailable(false);
		ok = Main.doUpdateMenu(menuList,"Taco", 2);
		assertFalse("Test that un-available item is NOT ok to update?", ok);
		//error condition
		ok = Main.doUpdateMenu(menuList,"Taco", 2);
		assertFalse("Test that non-esiting item is NOT ok to update?", ok);

    }

    @Test
    public void testDoDeleteMenu() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.deleteMenu(menuList, m1);
		// normal
		Boolean ok = Main.doDeleteMenu(menuList,"Taco", 2);
		assertTrue("Test if an available item is ok to update?", ok);
		//error condition
		ok = Main.doDeleteMenu(menuList,"Taco", 2);
		assertFalse("Test if an same item is NOT ok to update again?", ok);	
		//error condition
		Main.deleteMenu("Taco", 2);	
		m1.setIsAvailable(false);
		ok = Main.doDeleteMenu(menuList,"Taco", 2);
		assertFalse("Test that un-available item is NOT ok to delete?", ok);
		//error condition
		ok = Main.doDeleteMenu(menuList,"Taco", 2);
		assertFalse("Test that non-esiting item is NOT ok to delete?", ok);
        
    }
    
    @Test
    public void testDoDeleteOrder() {
        assertNotNull("Check if there is a valid menuList to delete", menuList);

        Main.removeOrder(menuList, "Taco"); // Modify the second argument based on your order ID

        // Normal
        boolean ok = Main.doDeleteOrder(menuList, "Taco", 2);
        assertTrue("Test if an available order is ok to update?", ok);

        // Error conditions
        ok = Main.doDeleteOrder(menuList, "Taco", 2);
        assertFalse("Test if the same order is NOT ok to update again?", ok);

        ok = Main.doDeleteOrder(menuList, "Taco", 2);
        assertFalse("Test that unavailable order is NOT ok to delete?", ok);
    }
    
    
    @Test
    public void testAddUser() {
        assertNotNull("Check if there is valid user to add", userList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.addUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added",u1, userList.get(0));

    }
    
    
    @Test
    public void testDeleteUser() {
        assertNotNull("Check if there is valid user to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.deleteUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added",u1, userList.get(0));

    }
    @Test
    public void testViewUser() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.viewUser(userList, u1);
		assertEquals("Check that User arraylist size is 1", 1, userList.size());
		assertSame("Check that User is added",u1, userList.get(0));

    }
    
    @Test
    public void testViewOrder() {
        assertNotNull("Check if there is a valid orderList to view", orderList);

        // Create sample order(s) for testing
        Order sampleOrder1 = createSampleOrder("Item A", "Processing");
        Order sampleOrder2 = createSampleOrder("Item B", "Order Completed");
        orderList.add(sampleOrder1);
        orderList.add(sampleOrder2);

        Main.viewAllOrders(orderList);

        String expectedOutput = generateExpectedOutput(sampleOrder1, sampleOrder2);
        String actualOutput = systemOutRule.getLog().trim();

        assertEquals("Check if printed output matches expected output", expectedOutput, actualOutput);
    }
    

    
    
    @Test
    public void testAddSchool() {
        assertNotNull("Check if there is valid schoolList to add", schooList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.addSchool(schoolList, s1);
		assertEquals("Check that School arraylist size is 1", 1, schoolList.size());
		assertSame("Check that School is added",s1, schoolList.get(0));

    }
    public void testViewSchool() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.viewSchool(schoolList, s1);
		assertEquals("Check that School arraylist size is 1", 1, schoolList.size());
		assertSame("Check that School is added",s1, schoolList.get(0));

    }
    public void testDeleteSchool() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.deleteSchool(schoolList, s1);
		assertEquals("Check that School arraylist size is 1", 1, schoolList.size());
		assertSame("Check that School is added",s1, schoolList.get(0));

    }
    
    @Test
    public void testAddOrder() {
        assertNotNull("Check if there is a valid orderList to add orders to", orderList);
        
        int initialSize = orderList.size();
        
        Main.addOrder(orderList, o1);

        assertEquals("Check that orderList size increased by 1", 1, orderList.size());
        assertTrue("Check that the order was added to orderList", orderList.contains(o1));
    }

    
    
    @Test
    public void testUpdateOrder() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.updateOrder(orderList, o1);
		assertEquals("Check that Order arraylist size is 1", 1, orderList.size());
		assertSame("Check that Order is added",o1, orderList.get(0));
    }
    
    @Test
    public void testAddPayment() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)
        Main.addPayment(paymentMethodList, pm1);
		assertEquals("Check that Payment Method arraylist size is 1", 1, paymentMethodList.size());
		assertSame("Check that Payment Method is added",pm1, paymentMethodList.get(0));

    }

@Test
public void testViewPayment() {
    assertNotNull("Check if there is valid menuItem to delete", menuList);
    
    // ... (other testDoDeleteMenu assertions)
    Main.viewPayment(paymentMethodList, pm1);
	assertEquals("Check that Payment Method arraylist size is 1", 1, paymentMethodList.size());
	assertSame("Check that Payment Method is added",pm1, paymentMethodList.get(0));

}

@Test
public void testDeletePayment() {
    assertNotNull("Check if there is valid menuItem to delete", menuList);
    
    // ... (other testDoDeleteMenu assertions)
    Main.deletePayment(paymentMethodList, pm1);
	assertEquals("Check that Payment Method arraylist size is 1", 1, paymentMethodList.size());
	assertSame("Check that Payment Method is added",pm1, paymentMethodList.get(0));

}
@Test
public void testViewVendor() {
    assertNotNull("Check if there is valid menuItem to delete", menuList);
    
    // ... (other testDoDeleteMenu assertions)
    Main.viewVendor(vendorList, v1);
	assertEquals("Check that Vendor arraylist size is 1", 1, vendorList.size());
	assertSame("Check that Vendor is added",v1,vendorList.get(0));

}
@Test
public void testDeleteVendor() {
    assertNotNull("Check if there is valid menuItem to delete", menuList);
    
    // ... (other testDoDeleteMenu assertions)
    Main.deleteVendor(vendorList, v1);
	assertEquals("Check that Vendor arraylist size is 1", 1, vendorList.size());
	assertSame("Check that Vendor is added",v1,vendorList.get(0));

}


@Test
public void testAddVendor() {
    assertNotNull("Check if there is valid vendorList to add", vendorList);
    
    Main.addVendor(vendorList, v1);
	assertEquals("Check that Vendor arraylist size is 1", 1, vendorList.size());
	assertSame("Check that Vendor is added",v1,vendorList.get(0));
}

    

    @After
    public void tearDown() throws Exception {
        m1 = null;
        u1 = null;
        s1 = null;
        o1 = null;
        pm1 = null;
        v1 = null;
        a1 = null;
        
        menuList = null;
        userList = null;
        schoolList=null;
        paymentMethodList=null;
        vendorList=null;
        orderList=null;
        
        // Clean up other variables if needed
        //Ashley
    }
}
