package SeachAlgs;

public class SequentialSearch {
    
    /**
     * A sequential search is a systematic technique where you begin your search at
     * the beginning (of the array), and stop your search once you reach the desired
     * value.
     * <p>
     * For example, the following code performs a sequential search on an array of
     * intvalues, looking for the value matching item. If the search is successful,
     * it returns the location of itemin the array list. If the search fails, the
     * method returns -1.
     * <p/>
     * 
     * @param item - the integer to serach for in the list.
     * @param list - the array in which to search.
     * @return the location of the item in the list if found, -1 otherwise.
     */
    public static int seqSearch1(int[] list, int item) {
        int location = -1;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == item)
                location = i;
        }
        return location;
    }

    /*
     ****************************************************************************
     * Note that the variable location is initialized to reflect an unsuccessful
     * search. If item is not found, the method will return this default value to
     * indicate a failed search.
     ****************************************************************************
     */

     /**
     * Although the above method works, it is not as efficient as we could make it.
     * Even if it finds the search value, it continues through the entire array. It
     * would be more efficient to stop the search once we had found the search
     * value.
     * <p>
     * We can accomplish this improvement through the use of a boolean variable
     * {@code found}.
     * <p/>
     * 
     * @param item - the integer to serach for in the list.
     * @param list - the array in which to search.
     * @return the location of the item in the list if found, -1 otherwise. 
     */
      public static int seqSearch2(int[] list, int item) {
         int location = -1;
         boolean found = false;
         for (int i = 0; i < list.length && !found; i++) {
             if (list[i] == item) {
                 location = i;
                 found = true;
             }
         }
         return location;
     }
}
