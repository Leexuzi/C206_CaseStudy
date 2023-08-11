<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy.git

public class Vendor extends User {
    private String contactInfo;
    private String address;
<<<<<<< HEAD
    private List<Menu> menus;  // Corrected the type and initialization
=======
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy.git

    public Vendor(String username, String password, String contactInfo, String address) {
        super(username, password);
        this.contactInfo = contactInfo;
        this.address = address;
<<<<<<< HEAD
        menus = new ArrayList<>();  // Corrected the initialization
=======
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy.git
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
<<<<<<< HEAD

    @Override
    public String toString() {
        return super.getUsername() + "\nVendor: " + super.getUsername() +
               "\nContact: " + contactInfo + "\nAddress: " + address;
    }
=======
>>>>>>> branch 'master' of https://github.com/Leexuzi/C206_CaseStudy.git
}
