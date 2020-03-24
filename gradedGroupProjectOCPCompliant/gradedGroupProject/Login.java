package gradedGroupProject;

import java.util.List;

public class Login {
	private int pos;
	private String username;
	private String password;
	private BankClient loggedInClient;
	
	
	public BankClient executeLoginDetails(List<BankClient> bankClients) {
		
		provideLoginDetails();
		
		String error = checkLoginTransactionStructure( bankClients );
		
		if( error != null ) {
			printErrorMessage(error);
			loggedInClient=null;
			System.out.println("Bank client credentials were not found.");
		}
		
		else  {
			executeLoginTransaction(bankClients);
		}
		return loggedInClient;
	}
	

	private String checkLoginTransactionStructure(List<BankClient> bankClients) {
		if(username == null || password == null) return "Error with Login";
		
		pos = 0;
		
		for( pos = 0; pos < bankClients.size(); ++pos ) if( bankClients.get( pos ).getUsername().equals( username ) && bankClients.get( pos ).getPassword().equals( password ) ) break;

		if( pos < 0 || pos >= bankClients.size() ) return "Invalid username or password" ;
		
		return null;
		
	}

	private void executeLoginTransaction(List<BankClient> bankClients) {
		
		bankClients.get( pos ).toPrint();
		loggedInClient=bankClients.get(pos);
	}

	private void printErrorMessage(String message) {
		System.err.println(message);
		
	}
	private void provideLoginDetails() {
		KeyInput KeyInput = new KeyInput();
		username = KeyInput.read("username");
		password = KeyInput.read("password");
		
	}
}
