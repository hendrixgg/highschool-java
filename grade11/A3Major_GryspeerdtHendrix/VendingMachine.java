/**
 * Name: Hendrix Gryspeerdt
 * Project Name: A3Major Assignment - The Vending Machine
 * 
 * The Vending Machine class. This models a vending machine
 * containing different types of items that can be bought 
 * and restocked.
 */

import java.text.DecimalFormat;
public class VendingMachine {
  private int bankAmount, changeAmount, numItems, depositAmount;
  private ItemType[] items;
      
  /**
   * Constructor
   * pre: none
   * post: Initializes the float, bankAmount, 
   * depositAmount and the numItems in thevending machine.
   * initializes the ItemType array (items).
   */
  public VendingMachine(){
      items = new ItemType[10];
      changeAmount = 1000;
      bankAmount = 0;
      depositAmount = 0;
      numItems = 0;
  }
  
  /**
   * returns the bank amount in the vending machine
   * (int bankAmount)
   */
  public int getBankAmount(){
      return bankAmount;
  }
  
  /**
   * returns the depositAmount amount in the vending machine
   * (int depositAmount)
   */
  public int getDepositAmount(){
      return depositAmount;
  }
  
  /**
   * returns the amount of change left in the vending machine
   * (int changeAmount)
   */
   public int getChangeAmount(){
      return changeAmount;
  }
  
   /**
    * Adds a new ItemType object to the vending machine
    * pre:none
    * post: if there was space in the vending machine
    * and the price was compatible, the numItems 
    * has been increased by 1 and the ItemType (item) 
    * is added to the items array. Then true is 
    * returned, false otherwise.
    */
  public boolean addItemType(ItemType item){
    if(numItems == 10 || item.getPrice() % 5 != 0)
      return false;
    
    items[numItems] = item;
    numItems++;
    return true;
  }
  
  /**
    * Removes the specified item from the items array and 
    * shifts the other items down the array if necessary
    * pre:none
    * post: if the index was valid (int 0 <= which < 10) the 
    * ItemType was removed and the other items in the array 
    * are shifted accordingly. True is returned if successful,
    * false otherwise.
    */
  public boolean removeItemType(int which){
    //if the last item is to be removed
    if(which == numItems - 1){
     numItems--;
     return true;
     //if an item that is not the last item to be removed
    }else if(which < numItems - 1 && which >= 0){
      numItems--;
      for(int i = which; i < numItems; i++){
        items[i] = items[i+1];
      }
      return true;
    }
    return false;
  }
 
  /**
   * restocks the specified item with the specified quantity (int qty).
   * pre: none
   * post: Returns false if the specified index (int which) 
   * was out of bounds, true otherwise.
   */
  public boolean reStock(int which, int qty){
    try{
      items[which].addQuantity(qty);
    }catch(Exception e){
      return false;
    }
    return true;
  } 
  
  /**
    * Adds to the depositAmount a specified amount (int cents)
    * pre:none
    * post: If the coin value was valid, the depositAmount
    * is increased by that amount (int cents) and true is returned,
    * false otherwise.
    */
  public boolean depositCoin(int cents){
    if(cents == 5 || cents == 10 || cents == 25 || cents == 100 || cents == 200){
      depositAmount += cents;
      return true;
    }
    return false;
  }
  
  /**
    * Dispenses the specified (int which) item from the vending machine
    * pre:none
    * post: if there was stock of the specified item in
    * the vending machine, the change due is returned.
    */
  public int selectItem(int which){
    int cost = 0;
    try{
      if(depositAmount - items[which].getPrice() < 0)
      return -9999;
      
      cost = items[which].getItem();
      if(cost == -9999)
        return cost;
      
    }catch(Exception e){
     return -9999; 
    }

    int changeDue = depositAmount - cost;
    if(changeAmount - changeDue < 0){
      changeDue = changeAmount;
      changeAmount = 0;
      bankAmount += depositAmount;
      depositAmount = 0;
      return changeDue;
    }
    bankAmount += depositAmount;
    depositAmount = 0;
    changeAmount -= changeDue;
    return changeDue;
  }
  
  /**
    * Returns the depositAmount plus the bankAmount subtracted 
    * by the total amount of change given.
    * pre:none
    * post: the changeAmount is restored to 1000 cents. The
    * bankAmount and depositAmount is reset to 0. Then, the bankAmount 
    * subtracted by the difference of 1000 - changeAmount
    * is returned.
    */
  public int clearMoney(){
    int returnAmount = bankAmount - (1000 - changeAmount);
    changeAmount = 1000;
      bankAmount = 0;
      return returnAmount;
  }
  
  // Returns a formatted string of the list of items in the vending machine
  public String toString(){
      String output = "\n" + StringFormatter("IndexID", 10) + 
      StringFormatter("Name", 15) +  StringFormatter("Price", 10) + 
      StringFormatter("Quantity",10);    
      output += "\n***********************************************\n";
      if(numItems < 1){
        output += "Machine not stocked.";
      }else{
        for (int i = 0; i < numItems; i++) {
          output += NumberFormatter(i, 2) + StringFormatter("", 8) 
              + StringFormatter(items[i].getName(), 13)
              + NumberFormatter(items[i].getPrice(), 7) + StringFormatter("", 6)
              + NumberFormatter(items[i].getQuantity(), 5) + "\n";
      }
    }

      // add the items of the vending machine to the output string
    return output;
  }
  /***********************************************************************
    * Do not modify the code below. They are functions to assist you with 
    * this assignment
    ***********************************************************************/
  
  /**
   * this method takes in an integer value and field width. It returns
   * a string of length fWidth with the integer value right justified    
   */
  static public String NumberFormatter(int value, int fWidth) {
    DecimalFormat myFormatter = new DecimalFormat("########");
    String output = myFormatter.format(value); 
    String filler = "";
    if (fWidth - output.length() < 0 ){
      return output.substring(0, fWidth);
    }
    else{
      for(int i=0; i < fWidth - output.length(); i++)
      {
        filler = filler + " ";
      }   
      return filler+output;
    }
  }
  
  /**
   * this method takes in an double value and field width. It returns
   * a string of length fWidth with the double value right justified 
   * with two digits to the right of the the decimal point
   */
  static public String NumberFormatter(double value, int fWidth) {
    DecimalFormat myFormatter = new DecimalFormat("########.00");
    String output = myFormatter.format(value); 
    String filler = "";
    if (fWidth - output.length() < 0 ){
      return output.substring(0, fWidth);
    }
    else{
      for(int i=0; i < fWidth - output.length(); i++)
      {
        filler = filler + " ";
      }   
      return filler+output;
    }
  }
  
  /* this method takes in an string value and field width. It return
   * a string of length fwidth with the string value left justified 
   */
  static public String StringFormatter(String value, int fWidth) {
    String output = value.trim();
    String filler = "";
    if (fWidth - output.length() < 0 ){
      return output.substring(0, fWidth);
    }
    else{
      for(int i=0; i < fWidth - output.length(); i++)
      {
        filler = filler + " ";
      }   
      return output+filler;
    }
  }  
  
}
