
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

		while (option != 5) {

			Main.mainMenu();
			option = Helper.readInt("Enter an option > ");

			if(option == 1) {
				Main.signin();
			}
			else {
				Main.login();
			}
//			if (option == 1) {
//				// View all items
//				Main.viewAllUser(usersList);
//				Main.viewAllMenuItem(menuItemsList);
//				Main.viewAllSchool(schoolsList);
//				Main.viewAlParents(parentsList);
//				Main.viewAllOrder(ordersList);
//				Main.viewAllVendor(vendorsList);
//				Main.viewAllAdmin(adminsList);
//				//Ashley
//				
//			} else if (option == 2) {
//				// Add a new item
//				ResourceCentre.setHeader("ADD");			
//				ResourceCentre.setHeader("ITEM TYPES");
//				System.out.println("1. Camcorder");
//				System.out.println("2. Chromebook");
//				
//				int itemType = Helper.readInt("Enter option to select item type > ");
//
//				if (itemType == 1) {
//					// Add a camcorder
//					Camcorder cc = inputCamcorder();
//					ResourceCentre.addCamcorder(camcorderList, cc);
//					System.out.println("Camcorder added");
//
//				} else if (itemType == 2) {
//					// Add a Chromebook
//					Chromebook cb = inputChromebook();
//					ResourceCentre.addChromebook(chromebookList, cb);
//					System.out.println("Chromebook added");
//
//				} else {
//					System.out.println("Invalid type");
//				}
//
//			} else if (option == 3) {
//				// Loan item
//				ResourceCentre.setHeader("LOAN");			
//				ResourceCentre.setHeader("ITEM TYPES");
//				System.out.println("1. Camcorder");
//				System.out.println("2. Chromebook");
//				
//				int itemType = Helper.readInt("Enter option to select item type > ");
//
//				if (itemType == 1) {
//					// Loan camcorder
//					ResourceCentre.loanCamcorder(camcorderList);
//				} else if (itemType == 2) {
//					// Loan Chromebook
//					ResourceCentre.loanChromebook(chromebookList);
//				} else {
//					System.out.println("Invalid type");
//				}
//
//			} else if (option == 4) {
//				// Return item
//				ResourceCentre.setHeader("RETURN");				
//				ResourceCentre.setHeader("ITEM TYPES");
//				System.out.println("1. Camcorder");
//				System.out.println("2. Chromebook");
//				
//				int itemType = Helper.readInt("Enter option to select item type > ");
//				if (itemType == 1) {
//					// Return camcorder
//					ResourceCentre.returnCamcorder(camcorderList);
//				} else if (itemType == 2) {
//					// Return Chromebook
//					ResourceCentre.returnChromebook(chromebookList);
//				} else {
//					System.out.println("Invalid type");
//				}
//
//			} else if (option == 5) {
//				System.out.println("Bye!");
//			} else {
//				System.out.println("Invalid option");
//			}
//
//		}
//	}
    
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

	//================================= Option 1 View items (CRUD- Read) =================================
	public static String retrieveAllCamcorder(ArrayList<Camcorder> camcorderList) {
		String output = "";

		for (int i = 0; i < camcorderList.size(); i++) {
			if (camcorderList.get(i).getIsAvailable()) {
				output += String.format("%-10s %-30s %-10s %-10s %-20d\n", camcorderList.get(i).getAssetTag(),
					camcorderList.get(i).getDescription(), 
					ResourceCentre.showAvailability(camcorderList.get(i).getIsAvailable()),
					camcorderList.get(i).getDueDate(),camcorderList.get(i).getOpticalZoom());
			}
		}
		return output;
	}
	
	public static void viewAllCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.setHeader("CAMCORDER LIST");
		String output = String.format("%-10s %-30s %-10s %-10s %-20s\n", "ASSET TAG", "DESCRIPTION",
				"AVAILABLE", "DUE DATE","OPTICAL ZOOM");
		 output += retrieveAllCamcorder(camcorderList);	
		System.out.println(output);
	}

	public static String retrieveAllChromebook(ArrayList<Chromebook> chromebookList) {
		String output = "";
		// write your code here
		return output;
	}
	public static void viewAllChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
		String output = retrieveAllChromebook(chromebookList);
		System.out.println(output);
	}

	//================================= Option 2 Add an item (CRUD - Create) =================================
	public static Camcorder inputCamcorder() {
		String tag = Helper.readString("Enter asset tag > ");
		String description = Helper.readString("Enter description > ");
		int zoom = Helper.readInt("Enter optical zoom > ");

		Camcorder cc= new Camcorder(tag, description, zoom);
		return cc;
		
	}
	public static void addCamcorder(ArrayList<Camcorder> camcorderList, Camcorder cc) {
		Camcorder item;
		for(int i = 0; i < camcorderList.size(); i++) {
			item = camcorderList.get(i);
			if (item.getAssetTag().equalsIgnoreCase(cc.getAssetTag()) )
				return;
		}
		if ((cc.getAssetTag().isEmpty()) || (cc.getDescription().isEmpty()) ) {
			return;
		}
		
		camcorderList.add(cc);
	}
	
	public static Chromebook inputChromebook() {	
		Chromebook cb =null;
		// write your code here

		return cb;
		
	}	
	public static void addChromebook(ArrayList<Chromebook> chromebookList, Chromebook cb) {
		// write your code here
		Chromebook item;
		for(int i = 0; i < chromebookList.size(); i++) {
			item = chromebookList.get(i);
			if (item.getAssetTag().equalsIgnoreCase(cb.getAssetTag()) )
				return;
		}
		if ((cb.getAssetTag().isEmpty()) || (cb.getDescription().isEmpty()) ) {
			return;
		}
	}
	
	//================================= Option 3 Loan an item (CRUD - Update) =================================
	public static boolean doLoanCamcorder(ArrayList<Camcorder> camcorderList, String tag, String dueDate) {
		
		boolean isLoaned = false;

		if (tag.isEmpty() || dueDate.isEmpty())
			return false;
		
		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == true) {
				
				camcorderList.get(i).setIsAvailable(false);
				camcorderList.get(i).setDueDate(dueDate);
				
				isLoaned = true;
			}
		}
		return isLoaned;
	}
	public static void loanCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.viewAllCamcorder(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		String due = Helper.readString("Enter due date > ");
		Boolean isLoaned =doLoanCamcorder(camcorderList, tag, due);
		if (isLoaned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " loaned out");
		}
	}
	
	public static boolean doLoanChromebook(ArrayList<Chromebook> chromebookList, String tag, String dueDate) {
		// write your code here
		return true;
	}
	public static void loanChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here		
	}
	
	//================================= Option 4 Return an item (CRUD - Update)=================================
	public static boolean doReturnCamcorder(ArrayList<Camcorder> camcorderList,String tag) {
		boolean isReturned = false;

		if (tag.isEmpty())
			return false;
		
		for (int i = 0; i < camcorderList.size(); i++) {
			if (tag.equalsIgnoreCase(camcorderList.get(i).getAssetTag())
					&& camcorderList.get(i).getIsAvailable() == false) {
				camcorderList.get(i).setIsAvailable(true);
				camcorderList.get(i).setDueDate("");
				isReturned = true;
				
			}
		}
		return isReturned;
		
	}
	public static void returnCamcorder(ArrayList<Camcorder> camcorderList) {
		ResourceCentre.viewAllCamcorder(camcorderList);
		String tag = Helper.readString("Enter asset tag > ");
		Boolean isReturned = doReturnCamcorder(camcorderList, tag);
		
		if (isReturned == false) {
			System.out.println("Invalid asset tag");
		} else {
			System.out.println("Camcorder " + tag + " returned");
		}
	}

	public static boolean doReturnChromebook(ArrayList<Chromebook> chromebookList,String tag){
		boolean isReturned = false;
		// write your code here
		return isReturned;
	}
	public static void returnChromebook(ArrayList<Chromebook> chromebookList) {
		// write your code here
	}

}