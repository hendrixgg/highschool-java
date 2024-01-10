class AccountDriver{
 
  public static void main(String[] args){
    
    Account[] myAccounts = new Account[5];
    
    myAccounts[0] = new Account(1234);
    myAccounts[1] = new CurrentAccount(5678);
    myAccounts[2] = new SavingsAccount(9101);
    myAccounts[3] = new Account(1213);
    myAccounts[4] = new CurrentAccount(1415);   
    
    updateAccounts(myAccounts);
    
  }
  public static void updateAccounts(Account[] myAccounts){
    for (int i = 0; i<myAccounts.length; i++)
    {
      
      Account n = ((Account)(myAccounts[i]));
        n.update();
      //System.out.println(myAccounts[i]);
      
    }
    
  }
  
  
}