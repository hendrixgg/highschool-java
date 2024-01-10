package SortAlgs;

/**
 * <p>
 * The {@code Selection Sort} class contains methods used to sort arrays with
 * the {@code Selection Sort} algorithim. Methods include sorting in ascending
 * order, decreasing order and sorting the top k Largest elements where k is the
 * number of elements to sort.
 * </p>
 * <h4>More on the Algorthim</h4>
 * <p>
 * The algorithm divides the input list into two parts: a sorted sublist of
 * items which is built up from left to right at the front (left) of the list
 * and a sublist of the remaining unsorted items that occupy the rest of the
 * list. Initially, the sorted sublist is empty and the unsorted sublist is the
 * entire input list. The algorithm proceeds by finding the smallest (or
 * largest, depending on sorting order) element in the unsorted sublist,
 * exchanging (swapping) it with the leftmost unsorted element (putting it in
 * sorted order), and moving the sublist boundaries one element to the right.
 * </p>
 * 
 * @see <a title="VisualAlgo.Net" href="https://visualgo.net/bn/sorting">visual
 *      explanation</a>
 */
public class SelectionSort {

    /**
     * Sorts an array using the Selection Sort Algorithim in ascending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Ascending(int[] list) {
        int front;
        int curr;
        int temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i] < list[curr])
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts an array using the Selection Sort Algorithim in ascending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Ascending(double[] list) {
        int front;
        int curr;
        double temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i] < list[curr])
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts an array using the Selection Sort Algorithim in ascending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Ascending(String[] list) {
        int front;
        int curr;
        String temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i].compareTo(list[curr]) < 0)
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts an array using the Selection Sort Algorithim in descending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Descending(int[] list) {
        int front;
        int curr;
        int temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i] > list[curr])
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts an array using the Selection Sort Algorithim in descending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Descending(double[] list) {
        int front;
        int curr;
        double temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i] > list[curr])
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts an array using the Selection Sort Algorithim in descending order.
     * 
     * @param list the {@code array} to be sorted
     */
    public static void Descending(String[] list) {
        int front;
        int curr;
        String temp;
        for (front = 0; front < list.length; front++) {
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if ((list[i].compareTo(list[curr]) > 0))
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
        }
    }

    /**
     * Sorts the specified amount of largest elements at the end of the array.
     * 
     * @param list the {@code array} to be sorted
     * @param k    the number of elements to be sorted
     */
    public static void kLargest(int[] list, int k) {
        if (k > list.length) {
            Ascending(list);
        } else {
            int end;
            int curr;
            int temp;
            for (end = list.length - 1; end >= list.length - k; end--) {
                curr = 0;
                for (int i = 1; i <= end; i++) {
                    if (list[i] > list[curr]) {
                        curr = i;
                    }
                }
                temp = list[end];
                list[end] = list[curr];
                list[curr] = temp;
            }
        }
    }

    /**
     * Sorts {@code k} largest elements at the end of the array. If {@code k} is
     * greater than the number of elements, the entire array is sorted.
     * 
     * @param list the {@code array} to be sorted
     * @param k    the number of elements to be sorted
     */
    public static void kLargest(double[] list, int k) {
        if (k > list.length) {
            Ascending(list);
        } else {
            int end;
            int curr;
            double temp;
            for (end = list.length - 1; end >= list.length - k; end--) {
                curr = 0;
                for (int i = 1; i <= end; i++) {
                    if (list[i] > list[curr]) {
                        curr = i;
                    }
                }
                temp = list[end];
                list[end] = list[curr];
                list[curr] = temp;
            }
        }
    }

    public static void graphicalExample() {
        int maxVal = 0;
        int front;
        int curr;
        int temp;
        // generate random array
        int[] list = new int[20];
        // populate array
        for (int i = 0; i < list.length; i++) {
            list[i] = (int) (Math.random() * 70) + 1;// random number from 1-70
        }
        for (int i = 0; i < list.length; i++) {
            maxVal = Math.max(maxVal, list[i]);
        }
        for (front = 0; front < list.length; front++) {
            // prints the array as bars of "*"
            System.out.printf("%n%n%nAfter %2d passes:%n%n", front);
            printGraph(list, front, maxVal);
            curr = front;
            for (int i = front + 1; i < list.length; i++) {
                if (list[i] < list[curr])
                    curr = i;
            }
            temp = list[curr];
            list[curr] = list[front];
            list[front] = temp;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    private static void printGraph(int[] list, int front, int maxVal) {
        for (int row = 0; row < list.length; row++) {
            for (int col = 0; col <= maxVal; col++) {
                if(col == 0) {
                    if(row == front)
                    System.out.printf("front %2d ",row);
                    else
                    System.out.printf("      %2d ",row);
                } else if(list[row] >= col)
                System.out.print("*");
            }
            System.out.println();
        }
    }
}