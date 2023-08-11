
public class Parent extends User{
	private String paymentMethod;

	public Parent(String username, String password, String paymentMethod) {
		super(username, password);
		this.paymentMethod = paymentMethod;
	}
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
}

