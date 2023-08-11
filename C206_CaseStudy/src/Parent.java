public class Parent extends User {
    private PaymentMethod paymentMethod;

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
}
