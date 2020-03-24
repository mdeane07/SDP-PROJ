package gradedGroupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class ProfileImpl implements ProfileImplInterface{

	private String name;
	private String address;
	private Date birthDate;
	
	public ProfileInterface createBankClientProfile() {
		
		System.out.println("Create Bank Client Profile");
		try {
			provideClientInformation();
		}
		catch(Exception e) {
			printErrorMessage();
		}
		
		if(checkClientInformation()) {
			ProfileInterface newProfile = executeCreateBankClientProfileTransaction();
			return newProfile;
		}
		else
			printErrorMessage();
		return null;
	}
	
	public Profile executeCreateBankClientProfileTransaction() {
		return new Profile(name, address, birthDate);
	}
	
	public void provideClientInformation() throws ParseException {
		KeyInput KeyInput = new KeyInput();		
		name = KeyInput.read("full Name: ");
		address = KeyInput.read("full Address: ");
		birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(KeyInput.read("Date of Birth in the format dd/MM/yyyy: "));
	}
	
	public boolean checkClientInformation() {
		if(name == null || address == null || birthDate == null)
			return false;
		else			
			return true;
	}
	
	public void printErrorMessage() {
		System.out.println(invalidInformation());
	}
	
	public String invalidInformation() {
		return "Invalid Information Provided!";
	}
	
}
