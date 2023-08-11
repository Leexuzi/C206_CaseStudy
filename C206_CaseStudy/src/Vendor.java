public class Vendor extends User {
    private String contactInfo;
    private String address;

    public Vendor(String username, String password, String contactInfo, String address) {
        super(username, password);
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
