public class MenuItem {
    private String food;
    private int quantity;

    public MenuItem(String food, int quantity) {
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
//Completed 