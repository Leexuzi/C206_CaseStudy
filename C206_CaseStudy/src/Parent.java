//
//public class Parent extends User{
//	private String paymentPreferred;
//
//	public Parent(String username, String password, String paymentPreferred) {
//		super(username, password);
//		this.paymentPreferred = paymentPreferred;
//	}
//	
//	public String getPaymentMethod() {
//		return paymentPreferred;
//	}
//	
//	public void setPaymentMethod(String paymentPreferred) {
//		this.paymentPreferred = paymentPreferred;
//	}
//}

public class Parent extends User {
    private String paymentPreferred;
    private List<String> dietaryPreferences;
    private List<String> allergies;
    private List<Order> orders;

    public Parent(String username, String password, String paymentPreferred) {
        super(username, password);
        this.paymentPreferred = paymentPreferred;
        this.dietaryPreferences = new ArrayList<>();
        this.allergies = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        // Add orders
    }

    public void trackOrders() {
        // Track orders
    }

    public void addDietaryPreference(String preference) {
        dietaryPreferences.add(preference);
    }

    public void addAllergy(String allergy) {
        allergies.add(allergy);
    }
}
