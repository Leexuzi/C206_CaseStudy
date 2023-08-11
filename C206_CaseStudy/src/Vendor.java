
public class Vendor extends User {
    private String contactInfo;
    private String address;
    private String menus;

    public Vendor(String username, String password, String contactInfo, String address) {
        super(username, password);
        this.contactInfo = contactInfo;
        this.address = address;
        menus = new ArrayList<MenuItem>();
    }

    // Getters and setters for contactInfo and address

    public List<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void updateMenu(String food, String description, double price, int quantity) {
        // Update logic here
    }

    public void deleteMenu(String food) {
        // Delete logic here
    }

    @Override
    public String toString() {
        return super.getUsername() + "\nVendor: " + super.getUsername() +
               "\nContact: " + contactInfo + "\nAddress: " + address;
    }
}

