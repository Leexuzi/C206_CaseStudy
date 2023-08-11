
public class Admin extends User{
	
	private String aSDF;

	public Admin(String username, String password, String aSDF) {
		super(username, password);
		this.aSDF = aSDF;
	}

}
