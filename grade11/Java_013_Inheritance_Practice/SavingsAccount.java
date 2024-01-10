public class SavingsAccount extends Account{
    private double interest;
    
    public SavingsAccount(int a) {
        super(a);
        interest = 0.02;
    }

    public void update() {
        System.out.println("Balance has been updated: " + (this.getBalance() + this.getBalance() * interest) 
                        + ". Total interest: " + (this.getBalance() * interest));
        deposit(this.getBalance() + this.getBalance() * interest);
    }       

    public String toString() {
        return "Account number: " + this.getAccountNumber() + " Balance: " + this.getBalance() + " Interest rate: %" + (interest * 100);
    }
    
}
