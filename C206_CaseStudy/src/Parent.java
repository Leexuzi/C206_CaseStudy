
public class Parent extends User{
	private String paymentPreferred;

	public Parent(String username, String password, String paymentPreferred) {
		super(username, password);
		this.paymentPreferred = paymentPreferred;
	}
	
	public String getPaymentMethod() {
		return paymentPreferred;
	}
	
	public void setPaymentMethod(String paymentPreferred) {
		this.paymentPreferred = paymentPreferred;
	}
}

