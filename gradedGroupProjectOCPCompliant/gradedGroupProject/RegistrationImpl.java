package gradedGroupProject;



public class RegistrationImpl implements RegistrationInterface{
	
	private String username;
	private String password;
	
	
	public BankClient registerBankClient() {		
		System.out.println("Register New Client");

		provideClientInformation();
		if(checkTransactionStructure()) {
			BankClient newClient = executeTransactionStructure();
			returnLoginDetails();
			return newClient;
		}
		else
			printErrorMessage();
		
		return null;
	}
	
	public BankClient executeTransactionStructure() {
		return new BankClient(username, password);
	}
	
	public void provideClientInformation(){
		KeyInput KeyInput = new KeyInput();	
		username = KeyInput.read("client username");
		password = KeyInput.read("client password");

	}
	
	public void returnLoginDetails() {
		System.out.println("Your Login Details; Username: '" + username + "' and Password: '" + password + "'.");
	}
	public boolean checkTransactionStructure() {
		if(username == null || password == null)
			return false;
		else
			return true;
	}
	
	public void printErrorMessage() {
		System.out.println(InvalidInformation());
	}
	
	public String InvalidInformation() {
		return "Invalid Information Provided!";
	}
}
