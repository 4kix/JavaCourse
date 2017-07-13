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
}
