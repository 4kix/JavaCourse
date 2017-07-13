
public class Customer {
	
	public String firstName;
	public String lastName;
	public Account account;
	
	Customer() {
		
	}
	
	Customer(String f, String l) {
		firstName = f;
		lastName = l;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account acct) {
		account = acct;
	}
	
	
	@Override
	public String toString() {
	
		return firstName+ " " +lastName;
	}
	
}
