import java.util.ArrayList;
import java.util.List;

public class Vendor extends User {
    private String contactInfo;
    private String address;
    private List<MenuItem> menus; // Change the data type to List<MenuItem>

    public Vendor(String username, String password, String contactInfo, String address) {
        super(username, password);
        this.contactInfo = contactInfo;
        this.address = address;
        menus = new ArrayList<>(); // Initialize the list
    }

    // Getters and setters for contactInfo and address

    public List<MenuItem> getMenus() {
        return menus;
    }

    public void addMenu(MenuItem menuItem) {
        menus.add(menuItem);
    }

    public void updateMenu(String food, String description, double price, int quantity) {
        // Implement the update logic here
        for (MenuItem menuItem : menus) {
            if (menuItem.getFood().equalsIgnoreCase(food)) {
                menuItem.setDescription(description);
                menuItem.setPrice(price);
                menuItem.setQuantity(quantity);
                break; // Assuming food names are unique, exit loop after updating
            }
        }
    }

    public void deleteMenu(String food) {
        // Implement the delete logic here
        MenuItem menuToRemove = null;
        for (MenuItem menuItem : menus) {
            if (menuItem.getFood().equalsIgnoreCase(food)) {
                menuToRemove = menuItem;
                break; // Assuming food names are unique, exit loop after finding the menu
            }
        }
        if (menuToRemove != null) {
            menus.remove(menuToRemove);
        }
    }

    @Override
    public String toString() {
        return super.getUsername() + "\nVendor: " + super.getUsername() +
               "\nContact: " + contactInfo + "\nAddress: " + address;
    }
}
