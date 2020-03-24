package gradedGroupProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient extends Person {

	public static final AtomicInteger clientCount = new AtomicInteger( 0 );
	public static final AtomicInteger accountCount = new AtomicInteger( 0 );

	private int clientID;
	
	//Profile Content
	private Profile profile;

	//Client Content
	private String username;
	private String password;
	
	private List<Account> clientAccounts= new ArrayList<>();

	private List<Appointment> clientAppointments= new ArrayList<>();

	
	public BankClient( String username, String password ){
		
		if( username == null || password == null ) System.err.println( "Error: Missing Username or Password" ); 
		if( username.substring(0,1).equals("$")) System.err.println("Error: Fake username");
		if( password.substring(password.length()-1).equals(".")) System.err.println("Error: Fake password");
		else
		{
			
			this.username = username;
			this.password = password;
			this.clientID=clientCount.incrementAndGet();
			
		}	
	}
	public int getClientID() {
		return clientID;
	}
	
	public List<Account> getClientAccounts(){
		return clientAccounts;
	}
	
	public List<Appointment> getClientAppointments(){
		return clientAppointments;
	}
	
	public Profile getClientProfile() {
		return profile;
	}
	
	public void setClientProfile(ProfileInterface profile)
	{
		this.profile=(Profile) profile;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username= username;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	public boolean askForVerification( int clientID, int accountNumber, String adminName ){

		//Assume we sent a message to bank admin
		return true;
	}
	public void verify( int accountNumber, boolean verified ){
		//int pos = 0;
	//	for (pos = 0; pos < accountNumbers.size(); ++ pos) if (accountNumber == accountNumbers.get(pos)) break;	
		//if (pos < 0 || pos >= accountNumbers.size() ) System.err.println("Error account number");
		//else accountVerified.set(pos, verified);
	}
	public void changeClientDetails( String password, String username ){
		this.username = username;
		this.password = password;
	}
	public void toPrint() {
		System.out.println();
		System.out.println("Client Details: \n -----------------------");
		System.out.println("clientID = " + clientID);
		System.out.println("username = " + username);
		System.out.println("password = "+ password);
		profile.toPrint();
		printAccounts();
		printAppointments();
	}	
	public void printAppointments() {
		System.out.println();
		System.out.println("Appointments: \n -----------------------");
		for ( int i = 0; clientAppointments != null && i < clientAppointments.size(); ++ i) {
		System.out.println("Appointment ID: " + clientAppointments.get(i).getAppointmentId());
		System.out.println("Appointment Date: " + clientAppointments.get(i).getAppointmentDate());
		System.out.println("Employee Name: " + clientAppointments.get(i).getEmployeeName()+"\n");
		}
			
	}
	public void toPrintAccount( int accountNumber ) {
		for ( int i = 0; clientAccounts != null && i < clientAccounts.size(); ++ i)
			if (clientAccounts.get(i).getAccountNum() == accountNumber) {
				System.out.println();
				System.out.println("Account Details: \n -----------------------");
				System.out.println("accountNumber: " + clientAccounts.get(i).getAccountNum());
				System.out.println("accountType: " + clientAccounts.get(i).getAccountType());
				System.out.println("accountVerified: " + clientAccounts.get(i).getAccountVerified());
				System.out.println("accountBalances: " + clientAccounts.get(i).getAccountBalance()+"\n");
			}
			else {
				System.err.println("Invalid account number");
			}
	}
	public void printAccounts() {
		System.out.println();
		System.out.println("Accounts: \n -----------------------");
		for ( int i = 0; clientAccounts != null && i < clientAccounts.size(); ++ i) {
			System.out.println("accountNumber: " + clientAccounts.get(i).getAccountNum()) ;
			System.out.println("accountType: " + clientAccounts.get(i).getAccountType() );
			System.out.println("accountVerified: " + clientAccounts.get(i).getAccountVerified() );
			System.out.println("accountBalance: " + clientAccounts.get(i).getAccountBalance() );
			System.out.println();
		}
	}
	public void deleteAccount( int accountNumber ) {
		for ( int i = 0; clientAccounts != null && i < clientAccounts.size(); ++ i)
			
			if (clientAccounts.get(i).getAccountNum() == accountNumber) {
				clientAccounts.remove(i);
				System.out.println("Account removed");
			}
			else {
				System.err.println("Invalid account number");
			}
	}
	public void transfer( int fromAccountNumber, int toAccountNumber, double amount ) {
		boolean flag=false;
		int TransfereeAccountPos=-1;
		for( int pos = 0; pos < clientAccounts.size(); ++pos ) {
			if(clientAccounts.get(pos).getAccountNum()==fromAccountNumber) {
				double currentBalance=clientAccounts.get(pos).getAccountBalance();
				double newBalance=currentBalance-amount;
				if(newBalance<0) {
					System.err.println("Error:Insufficient funds not enough in the source account ");
					break;
				}
				else {
					clientAccounts.get(pos).setAccountBalance(newBalance);
					flag=true;		
				}
			}
			if(clientAccounts.get(pos).getAccountNum()==toAccountNumber) {
				TransfereeAccountPos=pos;
			}
			if( flag=true && TransfereeAccountPos != -1) {
				
				double newBalance=clientAccounts.get(TransfereeAccountPos).getAccountBalance()+amount;
				clientAccounts.get(TransfereeAccountPos).setAccountBalance(newBalance);
			}
		}
	}																								
	public boolean askForSchedulingAppointment( Date date, String employeeName ){
		//Pretend that message is sent to the Employee to confirm appointment 
		return true;
	}
	public void bookAppointment( Date date, String  employeeName, boolean scheduled ){
		Appointment newAppoint = new Appointment(employeeName,date,scheduled,clientID);
		clientAppointments.add(newAppoint);
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.profile.getName();
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		profile.setName(name);
	}
}