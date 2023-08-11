public class Menu {
    private String food;
    private int quantity;

    public Menu(String food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getFood() {
        return food;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Food: " + food + ", Quantity: " + quantity;
    }
}
//test
