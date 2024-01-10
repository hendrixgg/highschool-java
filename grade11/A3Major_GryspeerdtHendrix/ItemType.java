/**
 * Name: Hendrix Gryspeerdt
 * Project Name: A3Major Assignment - The Vending Machine
 * 
 * This is the ItemType class. It models an item that 
 * may be in a vending machine. The item type encapsulates
 * a non-negative quantity of items of the type, some
 * maximum for this quantity, a name for the type, and a
 * price for and item of the type.
 * 
 */

public class ItemType {
  private static final int maximum = 10;
  private int quantity, price;
  private String name;

  /**
   * Constructor
   * pre: none
   * post: A new ItemType object is created
   * with the name and price specified. If 
   * the price inputted was 0 or less, the 
   * price is set to 5 cents.
   */
  public ItemType(String n, int p) {
    if (p > 0)
      price = p;
    else
      price = 5;
    name = n;
    quantity = 0;
  }

  /**
   * Returns the name of the ItemType object
   * pre: none
   * post: The name as a String is returned.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the price of the ItemType object
   * pre: none
   * post: The price as an int is returned.
   */
  public int getPrice() {
    return price;
  }

  /**
   * Returns the Quantity of the ItemType object
   * pre: none
   * post: The quantity as an int is returned.
   */
  public int getQuantity() {
    return quantity;
  }

  /**
   * Adds the specified amount to the quantity of an ItemType object
   * pre: none
   * post: The quantity not added (rejected) is returned or -9999
   * is returned if a negative number was inputted.
   */
  public int addQuantity(int n) {
    if (n < 0)
      return -9999;

    if (quantity + n > maximum) {
      quantity = 10;
      return (n - maximum);
    }

    quantity += n;
    return 0;
  }

  /**
   * subtracts one from the quantity and
   * returns the price of the ItemType object.
   * pre: none
   * post: If the quantity was 0, -9999 was 
   * returned and nothing was subtracted. If 
   * the quantity was greater than 0, then 
   * quantity is decreased by 1 and the price is returned.
   */
  public int getItem() {
    if (quantity == 0)
      return -9999;

    quantity--;
    return price;
  }

}
