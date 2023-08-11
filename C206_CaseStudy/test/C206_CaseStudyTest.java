import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudy {
	private MenuItem m1;
	private MenuItem m2;

	private User u1;
	private User u2;

	
	private ArrayList<MenuItem> menuList;
	private ArrayList<User> userList;
	
	public C206_CaseStudy() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		// prepare test data
		m1 = new Menu("Taco", 2);
		m2 = new Menu("Ramen", 3);
		

		menuItem= new ArrayList<Menu>();
		
	}

	
	@Test
	public void test testAddMenu() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if menu can be added", menuItem);
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ResourceCentre.addMenu(menuItem, m1);
		assertEquals("Check that menuItem size is 1", 1, menuItem.size());
		assertSame("Check that menu is added", m1, menuItem.get(0));
		
		//Add another item. test The size of the list is 2? -normal
		//The item just added is as same as the second item of the list
		ResourceCentre.addMenu(menuItem, m2);
		assertEquals("Check that menuItem size is 2", 2, menuItem.size());
		assertSame("Check that menu is added", m2, menuItem.get(1));
	}
	@Test
	public void testUpdateMenu() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid menuItem to add to", menuItem);
		
		//Given an empty list, after adding 1 item, the size of the list is 1 - normal
		//The item just added is as same as the first item of the list
		ResourceCentre.addMenu(menuItem, m1);		
		assertEquals("Test that menuItem size is 1", 1, menuItem.size());
		assertSame("Test that menu is added", m1, menuItem.get(0));
		
		//Add another item. test The size of the list is 2? - normal
		//The item just added is as same as the second item of the list
		ResourceCentre.addMenu(menuItem, m2);
		assertEquals("Test that menuItem size is 2", 2, menuItem.size());
		assertSame("Test that menuItem is added", m2, menuItem.get(1));
	}
	
	@Test
	public void testDeleteMenu() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", camcorderList);
		
		//test if the list of camcorders retrieved from the SourceCentre is empty - boundary
		String allMenuItem= ResourceCentre.retrieveAllMenu(menuItem);
		String testOutput = "";
		assertEquals("Check that ViewAllMenuItem", testOutput, allMenu);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ResourceCentre.addMenuItem(menuItem, m1);
		ResourceCentre.addMenuItem(menuItem, m2);
		assertEquals("Test that menuItem size is 2", 2, menuItem.size());
		
		//test if the expected output string same as the list of camcorders retrieved from the SourceCentre	
		allMenu= ResourceCentre.retrieveAllMenu(menuItem);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","", "Taco", "", "", "2");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","", "Ramen", "", "", "3" );
	
		assertEquals("Test that ViewAllMenuItem", testOutput, allMenu);
		
	}
	@Test
	public void testRegisterAccount() {
		//fail("Not yet implemented");
		// Test if Item list is not null but empty - boundary
		assertNotNull("Test if there is valid menuItem to retrieve item from", menuItem);
		
		//test if the list of Chromebook retrieved from the SourceCentre is empty - boundary
		String allMenu= ResourceCentre.retrieveAllMenuItem(menuItem);
		String testOutput = "";
		assertEquals("Test that the retrieved menu is empty?", testOutput, allMenu);
		
		//Given an empty list, after adding 2 items, test if the size of the list is 2 - normal
		ResourceCentre.addMenu(menuItem, m1);
		ResourceCentre.addMenu(menuItem, m2);
		assertEquals("Test that menuItem size is 2", 2, menuItem.size());
		
		//test if the expected output string same as the list of menuItems retrieved from the SourceCentre	
		allMenu= ResourceCentre.retrieveAllMenu(menuItem);
		testOutput = String.format("%-10s %-30s %-10s %-10s %-20s\n","", "Taco", "", "", "2");
		testOutput += String.format("%-10s %-30s %-10s %-10s %-20s\n","", "Ramen", "", "", "3" );
		assertEquals("Test that ViewAllMenuItem", testOutput, menuItem);
	}

	@Test
	public void testCreateAccount() {
		//boundary
		assertNotNull("test if there is valid menu", menuItem);
		
		ResourceCentre.addMenu(menuItem, m1);
		// normal
		Boolean ok = ResourceCentre.doMenu(menuItem, "", "" );
		assertTrue("Test if item is available?", ok);
		//error condition
		ok = ResourceCentre.doMenu(menuItem, "", "" );
		assertFalse("Test if there are no same item?", ok);	
		//error condition
		ResourceCentre.addMenu(menuItem, m2);	
		m2.setIsAvailable(false);
		ok = ResourceCentre.doMenu(menuItem, "", "" );
		assertFalse("Test that there are unavailable item?", ok);
		//error condition
		ok = ResourceCentre.doMenu(menuItem, "", "" );
		assertFalse("Test if there is the same item?", ok);	
		
	}
	
	@Test
	public void testDoAddMenu() {
		//boundary
		assertNotNull("Test if there is valid menuItem to add to", menuItem);
		ResourceCentre.addMenu(menuItem, m1);
		//normal
		Boolean ok = ResourceCentre.doLoanMenu(menuItem, "Taco", "" );
		assertTrue("Test if item is available", ok);		
		//error condition
		ok = ResourceCentre.doMenu(menuItem, "Ramen", "" );
		assertFalse("Test if there is the same item?", ok);	
		//error
		ResourceCentre.addMenu(menuItem, m2);
		m2.setIsAvailable(false);
		ok = ResourceCentre.doMenu(menuItem, "Taco", "" );
		assertFalse("Test that there are unavailable items?", ok);
		//error condition
		ok = ResourceCentre.doMenu(menuItem, "Ramen", "" );
		assertFalse("Test that there are non-existing items?", ok);
		
	}
	
	@Test
	public void testDoUpdateMenu() {
		//boundary
		assertNotNull("Test if there is valid menuitem to add to", menuItem);
		ResourceCentre.addMenu(menuItem, m1);
		//error
		Boolean isReturned = ResourceCentre.doReturnCamcorder(menuItem, "Taco");
		assertFalse("Test if available taco is changed -false?", isReturned);		
		//normal
		ResourceCentre.addMenu(menuItem, m2);
		m2.setIsAvailable(false);
		isReturned = ResourceCentre.doReturnMenu(menuItem, "Ramen");
		assertTrue("Test if Ramen is changed- true", isReturned);
		//error
		isReturned = ResourceCentre.doReturnMenu(menuItem, "Ramen");
		assertFalse("Test if non-existing Ramen is changed - false?", isReturned);
		
	}
	@Test
	public void testDoDeleteMenu() {
		//boundary
		assertNotNull("Check if there is valid menuItem to delete", menuItem);
		ResourceCentre.deleteMneu(menuItem, m1);

		//error
		Boolean isDeleted = ResourceCentre.doDeletemenu(menuItem, "Taco");
		assertFalse("Check that available Taco is deleted - false?", isDeleted);		
		//normal
		ResourceCentre.addMenuItem(menuItem,m2);
		m2.setIsAvailable(false);
		isDeleted = ResourceCentre.doDeleteMenu(menuItem, "Ramen");
		assertTrue("Check that ramen is deleted - true", isDeleted);
		//error
		isDeleted = ResourceCentre.doDeleteMenu(menuItem, "Ramen");
		assertFalse("Check that non-existing ramen  is returned - false?", isDeleted);
	}
	@After
	public void tearDown() throws Exception {
		m1 = null;
		m2 = null;
	
	

	}

}
