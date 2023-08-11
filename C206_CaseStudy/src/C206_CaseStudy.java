import java.util.ArrayList;

public class C206_CaseStudy {

    public static void main(String[] args) {
        // Sample code for demonstrating interactions
        ArrayList<MenuItem> menusList = new ArrayList<>();
        ArrayList<User> usersList = new ArrayList<>();
        ArrayList<School> schoolsList = new ArrayList<>();
        ArrayList<Admin> adminsList = new ArrayList<>();
        ArrayList<Parent> parentsList = new ArrayList<>();
        ArrayList<Vendor> vendorsList = new ArrayList<>();
        ArrayList<Order> ordersList = new ArrayList<>();

        // Creating instances of different objects and adding them to respective lists
        menusList.add(new MenuItem("Taco", 2));
        usersList.add(new User("ashhhlolol", "Password1234"));
        schoolsList.add(new School("Republic Poly", 4));
        adminsList.add(new Admin("waynerei", "Password1234"));
        parentsList.add(new Parent("mother", "Password1234", "Credit Billing"));
        vendorsList.add(new Vendor("vendor", "Password1234", "11111111", "address"));
        ordersList.add(new Order(parentsList.get(0), "Ramen"));

        int option = 0;

        while (option != 5) {
            menu();
            option = Helper.readInt("Enter an option > ");

            if (option == 1) {
                // View all items
                viewAllUsers(usersList);
                viewAllMenuItems(menusList);
                viewAllSchools(schoolsList);
                viewAllParents(parentsList);
                viewAllOrders(ordersList);
                viewAllVendors(vendorsList);
                viewAllAdmins(adminsList);
            }
            // Add more options here...

        }

    }

    public static void menu() {
        // Display menu options
    }

    public static void viewAllUsers(ArrayList<User> users) {
        // Display all users
    }

    public static void viewAllMenuItems(ArrayList<MenuItem> menuItems) {
        // Display all menu items
    }

   
