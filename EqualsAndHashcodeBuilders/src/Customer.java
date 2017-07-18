import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Customer {
	
	private String firstName;
	private String lastName;
	private Account account;
	
	Customer() {
		
	}
	
	Customer(String f, String l) {
		firstName = f;
		lastName = l;
	}
	
	

	public Customer(String firstName, String lastName, Account account) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.account = account;
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
		return firstName+ " " +lastName + " " + account.getBalance();
	}

	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37)
				.append(this.firstName)
				.append(this.lastName)
				.append(this.account)
				.toHashCode();
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Customer other = (Customer) obj;
		
		return new  EqualsBuilder().reflectionEquals(this, other);
	}
	
}
