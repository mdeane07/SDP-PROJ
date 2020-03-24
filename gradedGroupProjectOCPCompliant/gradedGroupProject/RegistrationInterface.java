package gradedGroupProject;

public interface RegistrationInterface {

	public abstract BankClient registerBankClient();
	public BankClient executeTransactionStructure();
	public void provideClientInformation();
	public void returnLoginDetails();
	public boolean checkTransactionStructure();
	public void printErrorMessage();
	public String InvalidInformation();
}
