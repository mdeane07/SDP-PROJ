package gradedGroupProject;

import java.text.SimpleDateFormat;
import java.util.List;


public class BankAdmin extends Person{

	private String name = "Y";

	private List<BankClient> bankClientsToVerify;
	private List<Account> accountsToVerify;

	public BankAdmin(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	
	public Boolean verifyAccount(int clientID, Account account, String choice) {
		System.out.print("Account number = "+account.getAccountNum()+",");
		if(choice.equals("1")) {
			
			System.out.print(" verified: true");
			System.out.println();
			account.setAccountVerified(true);
			return true;
			//Send Message to client confirming account
		}
		if(choice.equals("2")) {
			System.out.print(" verified: false");
			System.out.println();
			account.setAccountVerified(false);
			return false;
			//Send Message to client asking to create another account
		}	
		
		return null;
	}
	public List<Account> getAccountsToVerify() {
		return accountsToVerify;
	}
	public void setAccountsToVerify(List<Account> accountsToVerify) {
		this.accountsToVerify = accountsToVerify;
	}
	public List<BankClient> getBankClientsToVerify() {
		return bankClientsToVerify;
	}
	public void setBankClientsToVerify(List<BankClient> bankClientsToVerify) {
		this.bankClientsToVerify = bankClientsToVerify;
	}
	

}
