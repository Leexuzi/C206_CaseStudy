import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {

    private MenuItem m1;
    private MenuItem m2;

    private ArrayList<MenuItem> menuList;
    private ArrayList<User> userList;

    public C206_CaseStudyTest() {
        super();
    }

    @Before
    public void setUp() throws Exception {
        // prepare test data
        m1 = new MenuItem("Taco", 2);
        m2 = new MenuItem("Ramen", 3);

        menuList = new ArrayList<MenuItem>();
    }

    @Test
    public void testAddMenu() {
        // Item list is not null, so that can add a new item - boundary
        assertNotNull("Test if menu can be added", menuList);
        
        // ... (other testAddMenu assertions)

    }

    @Test
    public void testUpdateMenu() {
        // Item list is not null, so that can add a new item - boundary
        assertNotNull("Test if there is valid menuItem to add to", menuList);
        
        // ... (other testUpdateMenu assertions)

    }

    @Test
    public void testDeleteMenu() {
        // Test if Item list is not null but empty -boundary
        assertNotNull("Test if there is valid Camcorder arraylist to retrieve item", menuList);

        // ... (other testDeleteMenu assertions)

    }

    @Test
    public void testRegisterAccount() {
        assertNotNull("Test if there is valid menuItem to retrieve item from", menuList);
        
        // ... (other testRegisterAccount assertions)

    }

    @Test
    public void testCreateAccount() {
        assertNotNull("test if there is valid menu", menuList);
        
        // ... (other testCreateAccount assertions)

    }

    @Test
    public void testDoAddMenu() {
        assertNotNull("Test if there is valid menuItem to add to", menuList);
        
        // ... (other testDoAddMenu assertions)

    }

    @Test
    public void testDoUpdateMenu() {
        assertNotNull("Test if there is valid menuitem to add to", menuList);
        
        // ... (other testDoUpdateMenu assertions)

    }

    @Test
    public void testDoDeleteMenu() {
        assertNotNull("Check if there is valid menuItem to delete", menuList);
        
        // ... (other testDoDeleteMenu assertions)

    }

    @After
    public void tearDown() throws Exception {
        m1 = null;
        m2 = null;
        menuList = null;
        userList = null;
        // Clean up other variables if needed
    }
}
