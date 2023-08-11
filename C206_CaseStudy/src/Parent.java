public class Parent extends User {
    private PaymentMethod paymentMethod;

<<<<<<< HEAD
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
=======
    public Parent(String username, String password, PaymentMethod paymentMethod) {
        super(username, password);
        this.paymentMethod = paymentMethod;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy
}
