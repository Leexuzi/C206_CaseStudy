import java.util.ArrayList;
import java.util.List;

public class Order {
    private Parent parent;
    private ArrayList<MenuItem> items;
    private String orderName;
    private boolean isPaid;
    private boolean isDelivered;

    public Order(Parent parent, ArrayList<MenuItem> item, String orderName) {
        this.parent = parent;
        this.items = new ArrayList<>();
        this.orderName = orderName;
        this.isPaid = false;
        this.isDelivered = false;
    }

    public Parent getParent() {
        return parent;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
    
    public String getOrderName() {
    	return orderName;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        isPaid = true;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void markAsDelivered() {
        isDelivered = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Parent: ").append(parent.getUsername()).append("\n");
        sb.append("Items:\n");
        sb.append("Name: ").append(orderName).append("\n");
        for (MenuItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Paid: ").append(isPaid).append("\n");
        sb.append("Delivered: ").append(isDelivered);
        return sb.toString();
    }
}
