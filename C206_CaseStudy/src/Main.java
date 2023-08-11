import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Sample code for demonstrating interactions
        ArrayList<MenuItem> menuItemsList = new ArrayList<>();
        ArrayList<User> usersList = new ArrayList<>();
        ArrayList<School> schoolsList = new ArrayList<>();
        ArrayList<Admin> adminsList = new ArrayList<>();
        ArrayList<Parent> parentsList = new ArrayList<>();
        ArrayList<Vendor> vendorsList = new ArrayList<>();
        ArrayList<Order> ordersList = new ArrayList<>();

        // Additional interactions can be added here

		menuItemsList.add(new MenuItem("Taco", 2));
		usersList.add(new User("ashhhlolol", "Password1234"));
		schoolsList.add(new School("Republic Poly", 4));
		adminsList.add(new Admin("waynerei", "Password1234"));
		parentsList.add(new Parent("mother", "Password1234", "Credit Billing"));
		vendorsList.add(new Vendor("vendor", "Password1234", "11111111", "address"));
		ordersList.add(new Order(parentsList.get(0), "Ramen"));
		
		int option = 0;
		int user = 0;
		
		option = Helper.readInt("a");
		//if login was chosen
		if(option == 2) {
			int result = login();
			if(result == 1) {
				int userOption = 0;
				parentMenu();
				while (userOption!=5) {
					
					option = Helper.readInt("a");

					if(userOption == 1) {
						System.out.println("1");
					}
				}
			}
			else if(result == 2) {
//				vendorMenu();
			}
			else if(result == 3){
//				adminMenu();
			}
			else{
				System.out.println("Login in failed");
			}
		}
    }
    
    public static void mainMenu() {
		Main.setHeader("SCHOOL LUNCH BOX ORDERING SYSTEM");
		System.out.println("1. Sign in");
		System.out.println("2. Log in");
		Helper.line(80, "-");
	}

	public static void parentMenu() {
		Main.setHeader("ORDER PAGE");
		System.out.println("1. See all menus");
		System.out.println("2. Order item");
		System.out.println("3. See orders");
		System.out.println("4. Cancel order");
		System.out.println("5. Logout");
		Helper.line(80, "-");
	}
	
	public static void vendorMenu() {
		Main.setHeader("MANAGE LUNCHES");
		System.out.println("1. See all items");
		System.out.println("2. Add item");
		System.out.println("3. Add item");
		System.out.println("4. Remove item");
		System.out.println("5. See orders");
		System.out.println("6. Logout");
		Helper.line(80, "-");
	}
	
	public static void adminMenu() {
		Main.setHeader("MANAGEMENT");
		System.out.println("1. See all users");
		System.out.println("2. See all vendors");
		System.out.println("3. See all orders");
		System.out.println("4. See all payments");
		System.out.println("5. Add vendor");
		System.out.println("6. Edit vendor");
		System.out.println("7. Remove vendors");
		System.out.println("8. Add school");
		System.out.println("9. Edit school");
		System.out.println("10. Remove school");
		System.out.println("11. Logout");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
    }
	
	//sign up option
	public static int signin() {
		setHeader("SIGN IN");
		
	}
	
	//log in option
	public static int login() {
		
	}
	
	public static void viewAllUsers(ArrayList<User> userList) {
	    setHeader("USER LIST");
	    String output = String.format("%-20s %-20s\n", "USERNAME", "PASSWORD");
	    output += retrieveAllUsers(userList);
	    System.out.println(output);
	}

	public static void viewAllSchools(ArrayList<School> schoolList) {
	    setHeader("SCHOOL LIST");
	    String output = String.format("%-30s %-10s\n", "SCHOOL NAME", "TIER");
	    output += retrieveAllSchools(schoolList);
	    System.out.println(output);
	}

	public static void viewAllAdmins(ArrayList<Admin> adminList) {
	    setHeader("ADMIN LIST");
	    String output = String.format("%-20s %-20s\n", "USERNAME", "PASSWORD");
	    output += retrieveAllAdmins(adminList);
	    System.out.println(output);
	}
	
	public static void viewAllParents(ArrayList<Parent> parentList) {
	    setHeader("PARENT LIST");
	    String output = String.format("%-20s %-20s %-20s\n", "USERNAME", "PASSWORD", "PAYMENT METHOD");
	    output += retrieveAllParents(parentList);
	    System.out.println(output);
	}

	public static void viewAllVendors(ArrayList<Vendor> vendorList) {
	    setHeader("VENDOR LIST");
	    String output = String.format("%-20s %-20s %-20s %-20s\n", "USERNAME", "PASSWORD", "CONTACT", "ADDRESS");
	    output += retrieveAllVendors(vendorList);
	    System.out.println(output);
	}

	public static void viewAllOrders(ArrayList<Order> orderList) {
	    setHeader("ORDER LIST");
	    String output = String.format("%-20s %-20s\n", "PARENT", "ITEM");
	    output += retrieveAllOrders(orderList);
	    System.out.println(output);
	}


	//================================= Option 1 View all Users =================================
	
	
	
	public static int signin(ArrayList<User> usersList) {
	    setHeader("SIGN IN");
	    
	    String username = Helper.readString("Enter a username: ");
	    String password = Helper.readString("Enter a password: ");
	    int userType = Helper.readInt("Enter user type [0 for user, 1 for parent, 2 for vendor, 3 for admin]: ");
	    
	    // Check if the username is already taken or not
	    for (User user : usersList) {
	        if (user.getUsername().equals(username)) {
	            System.out.println("Username already taken. Sign up failed.");
	            return 0;
	        }
	    }
	    
	    // Create a new user based on the user type
	    User newUser;
	    if (userType == 1) {
	        String paymentMethod = Helper.readString("Enter preferred payment method: ");
	        newUser = new Parent(username, password, paymentMethod);
	    } else if (userType == 2) {
	        String contactInfo = Helper.readString("Enter contact info: ");
	        String address = Helper.readString("Enter address: ");
	        newUser = new Vendor(username, password, contactInfo, address);
	    } else if (userType == 3) {
	        newUser = new Admin(username, password);
	    } else {
	        newUser = new User(username, password);
	    }
	    
	    usersList.add(newUser);
	    System.out.println("Sign up successful.");
	    return 1;
	}
	

	public static int login(ArrayList<User> usersList) {
	    setHeader("LOG IN");
	    
	    String username = Helper.readString("Enter your username: ");
	    String password = Helper.readString("Enter your password: ");
	    
	    for (User user : usersList) {
	        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
	            if (user instanceof Parent) {
	                return 1; // Return 1 for parent
	            } else if (user instanceof Vendor) {
	                return 2; // Return 2 for vendor
	            } else if (user instanceof Admin) {
	                return 3; // Return 3 for admin
	            } else {
	                return 0; // Return 0 for user
	            }
	        }
	    }
	    
	    System.out.println("Invalid username or password. Login failed.");
	    return -1; // Return -1 to indicate failure
	}

	
	
	
	
	
	public static void option1View() {
	    int option = 0;

	    while (option != 7) {
	        setHeader("VIEW");
	        System.out.println("1. View all users");
	        System.out.println("2. View all schools");
	        System.out.println("3. View all admins");
	        System.out.println("4. View all parents");
	        System.out.println("5. View all vendors");
	        System.out.println("6. View all orders");
	        System.out.println("7. Back");
	        Helper.line(80, "-");

	        option = Helper.readInt("Enter an option > ");

	        switch (option) {
	            case 1:
	                viewAllUsers(usersList);
	                break;
	            case 2:
	                viewAllSchools(schoolsList);
	                break;
	            case 3:
	                viewAllAdmins(adminsList);
	                break;
	            case 4:
	                viewAllParents(parentsList);
	                break;
	            case 5:
	                viewAllVendors(vendorsList);
	                break;
	            case 6:
	                viewAllOrders(ordersList);
	                break;
	            case 7:
	                return; // Exit the option
	            default:
	                System.out.println("Invalid option. Please choose again.");
	        }
	    }
	}
	
	
	
	public static void parentMenu(ArrayList<Parent> parentsList, ArrayList<MenuItem> menuItemsList, ArrayList<Order> ordersList) {
        int option = 0;

        while (option != 5) {
            setHeader("ORDER PAGE");
            System.out.println("1. See all menus");
            System.out.println("2. Order item");
            System.out.println("3. See orders");
            System.out.println("4. Cancel order");
            System.out.println("5. Logout");
            Helper.line(80, "-");

            option = Helper.readInt("Enter an option > ");

            switch (option) {
                case 1:
                    viewAllMenus(menuItemsList);
                    break;
                case 2:
                    // Order Item
                    break;
                case 3:
                    viewAllOrders(ordersList);
                    break;
                case 4:
                    // Cancel order
                    break;
                case 5:
                    System.out.println("Logging out from Parent Menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
	
	
	public static void vendorMenu(ArrayList<Vendor> vendorsList, ArrayList<MenuItem> menuItemsList, ArrayList<Order> ordersList) {
        int option = 0;

        while (option != 6) {
            setHeader("MANAGE LUNCHES");
            System.out.println("1. See all items");
            System.out.println("2. Add item");
            System.out.println("3. Remove item");
            System.out.println("4. See orders");
            System.out.println("5. Logout");
            Helper.line(80, "-");

            option = Helper.readInt("Enter an option > ");

            switch (option) {
                case 1:
                    viewAllMenus(menuItemsList);
                    break;
                case 2:
                    // Add item
                    break;
                case 3:
                    // Remove item
                    break;
                case 4:
                    viewAllOrders(ordersList);
                    break;
                case 5:
                    System.out.println("Logging out from Vendor Menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
	
	
	 public static void adminMenu(ArrayList<User> usersList, ArrayList<Vendor> vendorsList, ArrayList<Order> ordersList) {
	        int option = 0;

	        while (option != 11) {
	            setHeader("MANAGEMENT");
	            System.out.println("1. See all users");
	            System.out.println("2. See all vendors");
	            System.out.println("3. See all orders");
	            System.out.println("4. See all payments");
	            System.out.println("5. Add vendor");
	            System.out.println("6. Edit vendor");
	            System.out.println("7. Remove vendors");
	            System.out.println("8. Add school");
	            System.out.println("9. Edit school");
	            System.out.println("10. Remove school");
	            System.out.println("11. Logout");
	            Helper.line(80, "-");

	            option = Helper.readInt("Enter an option > ");

	            switch (option) {
	                case 1:
	                    viewAllUsers(usersList);
	                    break;
	                case 2:
	                    viewAllVendors(vendorsList);
	                    break;
	                case 3:
	                    viewAllOrders(ordersList);
	                    break;
	                case 4:
	                    // viewAllPayments
	                    break;
	                case 5:
	                    //  addVendor 
	                    break;
	                case 6:
	                    //  editVendor 
	                    break;
	                case 7:
	                    //  removeVendors 
	                    break;
	                case 8:
	                    //  addSchool 
	                    break;
	                case 9:
	                    //  editSchool 
	                    break;
	                case 10:
	                    //  removeSchool 
	                    break;
	                case 11:
	                    System.out.println("Logging out from Admin Menu.");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	 }
	
	
	
}
