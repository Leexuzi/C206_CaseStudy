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
        ArrayList<String> paymentsList = new ArrayList<>();

		adminsList.add(new Admin("waynerei", "Password1234"));
		parentsList.add(new Parent("mother", "Password1234", "Credit Billing"));
		vendorsList.add(new Vendor("vendor", "Password1234", "11111111", "address"));
		for(Admin admin : adminsList) {
			usersList.add(admin);
		}
		for(Parent parent: parentsList) {
			usersList.add(parent);
		}
		for(Vendor vendor : vendorsList) {
			usersList.add(vendor);
		}
        
		menuItemsList.add(new MenuItem("Taco", 2));
		schoolsList.add(new School("Republic Poly", 4));
		ordersList.add(new Order(parentsList.get(0), "Ramen"));
		paymentsList.add("Credit card");
		paymentsList.add("Paypal");
		
		
		int option = 0;
		int user = 0;
		
		if(option == 1) {
			signup(usersList);
		}
		else if(option == 2) {
			int result = login(usersList);
			if(result == 1) {
				parentMenu(parentsList, menuItemsList, ordersList);
			}
			else if(result == 2) {
				vendorMenu(vendorsList, menuItemsList, ordersList);
			}
			else if(result == 3){
				adminMenu(parentsList, vendorsList, ordersList);
			}
			else{
				System.out.println("Login in failed");
			}
		}
    
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
	
	public static void viewAllPayments(ArrayList<String> paymentsList) {
	    setHeader("ORDER LIST");
	    String output = String.format("%-20s %-20s\n", "PARENT", "ITEM");
	    output += retrieveAllOrders(orderList);
	    System.out.println(output);
	}
	
	public static void addSchool(ArrayList<School> schoolsList) {
		setHeader("ADD SCHOOL");
		String name = Helper.readString("Enter school name: ");
		int id = schoolsList.size();
		School newSchool = new School(name, id);
	}
	
	public static void removeSchool(ArrayList<School> schoolsList) {
		
	}
	
	public static void addPayment(ArrayList<String> paymentsList) {
		
	}
	
	public static void removePayment(ArrayList<String> paymentsList) {
		
	}
	
	public static int signup(ArrayList<User> usersList) {
	    setHeader("SIGN UP");
	    
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
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
    
	public static void mainMenu() {
		Main.setHeader("SCHOOL LUNCH BOX ORDERING SYSTEM");
		System.out.println("1. Sign in");
		System.out.println("2. Log in");
		Helper.line(80, "-");
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
                    orderItem(menuItemsList, ordersList);
                    break;
                case 3:
                    viewAllOrders(ordersList);
                    break;
                case 4:
                    cancelOrder(ordersList);
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
                    addItem(ordersList);
                    break;
                case 3:
                    removeItem(ordersList);
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
	
	
	 public static void adminMenu(ArrayList<Parent> parentsList, ArrayList<Vendor> vendorsList, ArrayList<Order> ordersList, ArrayList<String> paymentsList, ArrayList<School> schoolsList) {
	        int option = 0;

	        while (option != 10) {
	            setHeader("MANAGEMENT");
	            System.out.println("1. See all parents");
	            System.out.println("2. See all vendors");
	            System.out.println("3. See all schools");
	            System.out.println("4. See all orders");
	            System.out.println("5. See all payments");
	            System.out.println("6. Add school");
	            System.out.println("7. Remove school");
	            System.out.println("8. Add payment");
	            System.out.println("9. Remove payment");	            
	            System.out.println("10. Logout");
	            Helper.line(80, "-");

	            option = Helper.readInt("Enter an option > ");

	            switch (option) {
	                case 1:
	                    viewAllParents(parentsList);
	                    break;
	                case 2:
	                    viewAllVendors(vendorsList);
	                    break;
	                case 3:
	                    viewAllOrders(ordersList);
	                    break;
	                case 4:
	                    viewAllPayments(paymentsList);
	                    break;
	                case 5:
	                    addSchool(schoolsList);
	                    break;
	                case 6:
	                    removeSchool(schoolsList);
	                    break;
	                case 7:
	                    addPayment(paymentsList);
	                    break;
	                case 8:
	                    removePayment(paymentsList);
	                    break;
	                case 9:
	                    System.out.println("Logging out from Admin Menu.");
	                    return;
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	 }
	
	
	
}
