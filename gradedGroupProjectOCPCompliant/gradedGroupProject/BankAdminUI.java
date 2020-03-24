package gradedGroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BankAdminUI {

	
public static void main( String[] args ) throws ParseException {

		BankAdmin bankAdmin = new BankAdmin("X");

		bankAdmin.setBankClientsToVerify(new ArrayList<BankClient>());
		bankAdmin.setAccountsToVerify(new ArrayList<Account>());

		BankClient client1 = new BankClient( "u1", "p1" );
		Account client1Primary= new PrimaryAccount("primary",657);
	    client1.getClientAccounts().add(client1Primary);
		client1.setClientProfile(new Profile("jeff"," 56 tree place" ,new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/12/2000" ) ));
		bankAdmin.getBankClientsToVerify().add( client1 );
		bankAdmin.getAccountsToVerify().add( client1Primary );

		BankClient client2 = new BankClient( "u2", "p2" );
		Account client2Primary= new PrimaryAccount("primary",237);
		client2.getClientAccounts().add(client2Primary);
		client2.setClientProfile(new Profile("Mark"," 23 tree place" ,new SimpleDateFormat( "dd/MM/yyyy" ).parse( "20/08/2000" ) ));
		bankAdmin.getBankClientsToVerify().add( client2 );
		bankAdmin.getAccountsToVerify().add(client2Primary);

	
		while(true) {

	    System.out.println("n0:Exit");
	    System.out.println( "1. Verify Accounts" );
		//verify( accountNumber, true ); //we assume that we are answering to the client with this call
		String choice = read( "choice" );
		
			if( choice.equals( "0" ) ) break;
	
			else if( choice.equals( "1" ) ){ 
				VerifyAccountTransaction object=new VerifyAccountTransaction();	
				object.verifyAccountTransaction(bankAdmin, bankAdmin.getBankClientsToVerify(),bankAdmin.getAccountsToVerify());
				}
			}
		}
			
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}
}

