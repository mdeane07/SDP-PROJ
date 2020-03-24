package gradedGroupProject;

public abstract class Transaction {
	String message;
	public void processTransaction(){
		provideDetails(); 
		String error = checkTransactionStructure(); 
		if( error!=null ) printErrorMessage(message); 
		else executeTransaction(); 
	} 

	protected  abstract void provideDetails(); 
	protected  abstract String checkTransactionStructure(); 
	protected  abstract void printErrorMessage(String message); 
	protected  abstract void executeTransaction();
}

