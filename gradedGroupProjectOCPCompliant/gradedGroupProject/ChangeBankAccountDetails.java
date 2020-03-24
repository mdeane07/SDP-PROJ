package gradedGroupProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChangeBankAccountDetails extends Transaction {
	private int pos;
	private int id;
	private String name;
	private String address;
	private String username;
	private String password;
	private Date birthDate;
	private BankClient loggedInClient;
	
	public void executeChangeBankAccountDetails(BankClient loggedInClient) {
		
		provideDetails();
		loggedInClient=loggedInClient;
		String error = checkTransactionStructure();

		if( error != null ) printErrorMessage( error );

		else executeTransaction();
	}
	@Override
	protected void provideDetails() {
		boolean flag=false;
		
		KeyInput KeyInput = new KeyInput();
		username = KeyInput.read("username");
		password = KeyInput.read("password");
		name = KeyInput.read("name");
		address = KeyInput.read( "address" );
	
		while(!flag) {
			try {
				birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(KeyInput.read("Date of Birth in the format dd/MM/yyyy: "));
				flag=true;
			} catch (ParseException e) {		
				System.err.println("Invalid Date");
			}
		}	
	}
	@Override
	protected void printErrorMessage(String message) {
		System.err.println(message);
		
	}
	@Override
	protected String checkTransactionStructure( ) {

		if( address == null || name == null || username == null || password == null || birthDate== null) return "Error change client details transaction";
 
	    else return null;
	}
	@Override
	protected void executeTransaction() {
		
		loggedInClient.changeClientDetails( password,username );
	    loggedInClient.getClientProfile().changeClientProfileDetails(name,address,birthDate);
		
	}

}
