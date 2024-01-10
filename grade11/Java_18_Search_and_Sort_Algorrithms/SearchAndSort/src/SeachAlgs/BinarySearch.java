package SeachAlgs;

/**
 * <h4>Searching & Sorting in Java – Binary Search</h4>
 * <p>
 * The <b>binary search</b> algorithm is a fast way of searching through sorted
 * data. This algorithm is an example of a divide and conquer algorithm, of
 * which there are many other examples. This type of algorithm solves a problem
 * by quickly reducing its size. For the binary search, at each stage of the
 * problem we cut the size of the problem roughly in half.
 * <p/>
 * 
 * @see Online <a title="Binary Search PDF" href="https://drive.google.com/file/d/15K_xxwvgmrJsR5BJ3KSbYezUFh4xDYhW/view">For a more detailed explaination</a>
 */
public class BinarySearch {
    
    /**
     * Binary Search method that takes in a in integer and seraches for it in the
     * array.
     * 
     * @param list - the array in which to search
     * @param item - the element to search for
     * @return The {@code index} of the item in the {@codearray}, or {@code -1} if it was
     *         not found
     */
    public static int search(int[] list, int item) {
        //if the list only contains elements of the same value
        if(list[0] == list[list.length-1]) {
            return 0;
        }
        //if list is in ascending order
        if(list[0] < list[list.length-1]) {
            return searchAscending(list, item);
        }
        //if list is in descending order
        return searchDescending(list, item);
    }

    /**
     * Binary Search method that takes in a double and seraches for it in the
     * array.
     * 
     * @param list the array in which to search
     * @param item the element to search for
     * @return The {@code index} of the item in the {@code array}, or {@code -1} if it was
     *         not found
     */
    public static int search(double[] list, double item) {
        //if the list only contains elements of the same value
        if(list[0] == list[list.length-1]) {
            return 0;
        }
        //if list is in ascending order
        if(list[0] < list[list.length-1]) {
            return searchAscending(list, item);
        }
        //if list is in descending order
        return searchDescending(list, item);
    }

    /**
     * Binary Search method that takes in an integer and seraches for it in the
     * array. Although, it will always return an index in bounds.
     * 
     * @param list the array in which to search
     * @param item the element to search for
     * @return the {@code index} of the item in the {@code array}, or the index of
     *         the value {@code nearest} to the item. If there is a tie, the smaller index
     *         is returned.
     */
    public static int searchNearest(int[] list, int item) {
        //if the list only contains elements of the same value
        if(list[0]==list[list.length-1]) {
            return 0;
        }
        //if list is in ascending order
        if(list[0] < list[list.length-1]) {
            return nearestAscending(list, item);
        }
        //if list is in descending order
        return nearestDescending(list, item);
    }

    /**
     * Binary Search method that takes in a double and seraches for it in the
     * array. Although, it will always return an index in bounds.
     * 
     * @param list the array in which to search
     * @param item the element to search for
     * @return the {@code index} of the item in the {@code array}, or the index of
     *         the value {@code nearest} to the item. If there is a tie, the smaller index
     *         is returned.
     */
    public static int searchNearest(double[] list, double item) {
        //if the list only contains elements of the same value
        if(list[0]==list[list.length-1]) {
            return 0;
        }
        //if list is in ascending order
        if(list[0] < list[list.length-1]) {
            return nearestAscending(list, item);
        }
        //if list is in descending order
        return nearestDescending(list, item);
    }

    private static int nearestAscending(int[] list, int item) {
        int L = 0;                      // lower bound of searching
        int R = list.length - 1;        // upper bound of searching
        int middle;                     // current search candidate
        boolean found = false;
        int location = -1;              // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item > list[middle]) {
                L = middle + 1;         // look only in R half
            } else {
                R = middle - 1;         // look only in L half
            }
            if (L > R) {
                if (L > list.length - 1) {
                    while (R > 0 && list[R - 1] == list[R]) {
                        R--;
                    }
                    return R;
                }
                if (R < 0) {
                    return L;
                } else {
                    if (Math.abs(item - list[L]) < Math.abs(item - list[R])) {
                        return L;
                    }
                    while (R > 0 && list[R - 1] == list[R]) {
                        R--;
                    }
                    return R;
                }
            }
        }
        return location;
    }
    
    private static int nearestAscending(double[] list, double item) {
        int L = 0;                      // lower bound of searching
        int R = list.length - 1;        // upper bound of searching
        int middle;                     // current search candidate
        boolean found = false;
        int location = -1;              // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item > list[middle]) {
                L = middle + 1;         // look only in R half
            } else {
                R = middle - 1;         // look only in L half
            }
            if(L>R) {
                if(L>list.length-1) {
                    while(R>0 && list[R-1] == list[R]) {
                        R--;
                    }
                    return R;
                }
                if(R<0) {
                    return L;
                }
                else {
                    if(Math.abs(item-list[L]) < Math.abs(item-list[R])) {
                        return L;
                    }
                    while(R>0 && list[R-1] == list[R]) {
                        R--;
                    }
                    return R;
                }
            }
        }
        return location;
    }

    private static int nearestDescending(int[] list, int item) {
        int L = 0;                     // lower bound of searching
        int R = list.length - 1;       // upper bound of searching
        int middle;                    // current search candidate
        boolean found = false;
        int location = -1;             // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item < list[middle]) {
                L = middle + 1; // look only in R half if item is less
            } else {
                R = middle - 1; // look only in L half if item is greater
            }
        }
        if(L>R) {
            if(L>list.length-1) {
                while(R>0 && list[R-1] == list[R]) {
                    R--;
                }
                return R;
            }
            if(R<0) {
                return L;
            }
            else {
                if(Math.abs(item-list[L]) < Math.abs(item-list[R])) {
                    return L;
                }
                while(R>0 && list[R-1] == list[R]) {
                    R--;
                }
                return R;
            }
        }
        return location;
    }

    private static int nearestDescending(double[] list, double item) {
        int L = 0;                     // lower bound of searching
        int R = list.length - 1;       // upper bound of searching
        int middle;                    // current search candidate
        boolean found = false;
        int location = -1;             // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item < list[middle]) {
                L = middle + 1; // look only in R half if item is less
            } else {
                R = middle - 1; // look only in L half if item is greater
            }
        }
        if(L>R) {
            if(L>list.length-1) {
                while(R>0 && list[R-1] == list[R]) {
                    R--;
                }
                return R;
            }
            if(R<0) {
                return L;
            }
            else {
                if(Math.abs(item-list[L]) < Math.abs(item-list[R])) {
                    return L;
                }
                while(R>0 && list[R-1] == list[R]) {
                    R--;
                }
                return R;
            }
        }
        return location;
    }

    private static int searchAscending(int[] list, int item) {
        int L = 0;                      // lower bound of searching
        int R = list.length - 1;        // upper bound of searching
        int middle;                     // current search candidate
        boolean found = false;
        int location = -1;              // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item > list[middle]) {
                L = middle + 1;         // look only in R half
            } else {
                R = middle - 1;         // look only in L half
            }
        }
        return location;
    }

    private static int searchAscending(double[] list, double item) {
        int L = 0;                      // lower bound of searching
        int R = list.length - 1;        // upper bound of searching
        int middle;                     // current search candidate
        boolean found = false;
        int location = -1;              // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item > list[middle]) {
                L = middle + 1;         // look only in R half
            } else {
                R = middle - 1;         // look only in L half
            }
        }
        return location;
    }

    private static int searchDescending(int[] list, int item) {
        int L = 0;                     // lower bound of searching
        int R = list.length - 1;       // upper bound of searching
        int middle;                    // current search candidate
        boolean found = false;
        int location = -1;             // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item < list[middle]) {
                L = middle + 1; // look only in R half if item is less
            } else {
                R = middle - 1; // look only in L half if item is greater
            }
        }
        return location;
    }

    private static int searchDescending(double[] list, double item) {
        int L = 0;                     // lower bound of searching
        int R = list.length - 1;       // upper bound of searching
        int middle;                    // current search candidate
        boolean found = false;
        int location = -1;             // location of item, -1 for failure
        while (L <= R && !found) {
            middle = (L + R) / 2;       // integer division, auto-truncate
            if (list[middle] == item) {
                location = middle;      // success!
                found = true;
            } else if (item < list[middle]) {
                L = middle + 1; // look only in R half if item is less
            } else {
                R = middle - 1; // look only in L half if item is greater
            }
        }
        return location;
    }
}