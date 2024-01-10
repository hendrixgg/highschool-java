public class CurrentAccount extends Account{
    private double overdraftLimit;

    public CurrentAccount(int a) {
        super(a);
    }

    public void setOverdraftLimit(double limit) {
        overdraftLimit = limit;
    }

    public void update() {
        if(this.getBalance() < 0) {
            System.out.println("Your account: " + this.getAccountNumber() + " is in overdraft. Balance: " + this.getBalance());
        }else {
            System.out.println("Your account: " + this.getAccountNumber() + " is not in overdraft. Balance: " + this.getBalance());
        }
    }

    public String toString() {
        return "Account number: " + this.getAccountNumber() + "Balance: " + this.getBalance() + " Overdraft limit: " + overdraftLimit;
    }
    
}
