import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Account {
    private double balance;
    
    /** Creates a new instance of Account */
    public Account(double initBalance) {
        balance = initBalance;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amt) {
        if ((balance = balance + amt) <= 1000) {
        return true;
        }
        else return false;
    }
    
    public boolean withdraw(double amt) {
        if (balance >= amt) {
            balance = balance - amt;
            return true;
        }
        else return false;
    }


	@Override
	public int hashCode() {
		return new HashCodeBuilder(17,37).append(balance).toHashCode();
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
		Account other = (Account) obj;
		
		return new EqualsBuilder().append(this.balance, other.balance).isEquals();
	}
}
