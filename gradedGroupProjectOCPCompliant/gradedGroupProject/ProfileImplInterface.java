package gradedGroupProject;

import java.text.ParseException;

public interface ProfileImplInterface {

	public abstract ProfileInterface createBankClientProfile();
	public Profile executeCreateBankClientProfileTransaction();
	public void provideClientInformation() throws ParseException;
	public boolean checkClientInformation();
	public void printErrorMessage();
	public String invalidInformation();
}
