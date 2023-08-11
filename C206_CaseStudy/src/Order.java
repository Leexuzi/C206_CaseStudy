public class Order extends Parent {
    private String os;
    private List<Menu> menuItems;  // List of Menu items in an order

    public Order(String assetTag, String description, String os) {
        super(assetTag, description);
        this.os = os;
        this.menuItems = new ArrayList<>();  // Initialize the list of menu items
    }

    public String getOs() {
        return os;
    }

    public void addMenuItem(Menu menuItem) {
        menuItems.add(menuItem);  // Add a menu item to the order
    }

    public List<Menu> getMenuItems() {
        return menuItems;  // Return the list of menu items in the order
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Order Information:\n");
        output.append("Asset Tag: ").append(getAssetTag()).append("\n");
        output.append("Description: ").append(getDescription()).append("\n");
        output.append("OS: ").append(os).append("\n");
        output.append("Menu Items:\n");

        for (Menu menuItem : menuItems) {
            output.append(menuItem.toString()).append("\n");
        }

        return output.toString();
    }
}
