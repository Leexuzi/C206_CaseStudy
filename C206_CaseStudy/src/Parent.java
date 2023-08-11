
<<<<<<< HEAD
public class Parent {
	private String assetTag;
	private String description;
	private String dueDate;
	private boolean isAvailable;

	public Parent(String assetTag, String description) {
		this.assetTag = assetTag;
		this.description = description;
		this.dueDate = "";
		this.isAvailable = true;
	}

	public String getAssetTag() {
		return assetTag;
	}

	public String getDescription() {
		return description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
=======
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
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy.git
	}
}

