package SortAlgs;

/**
 * <p>
 * This class contains methods that use the {@code Insertion Sort} sorting
 * algorithim.
 * </p>
 * <p>
 * For a detailed explaination follow this
 * <a href="https://en.wikipedia.org/wiki/Insertion_sort#Algorithm">link</a> to
 * the wikipedia page.
 * 
 */
public class InsertionSort {

    public static void ascending(int[] list) {
        int curr, temp;

        // start from the second item in the array
        for (int front = 1; front < list.length; front++) {
            // copy the unsorted item to a temporary location
            temp = list[front];
            curr = front;
            // shift items to the right if temp item is smaller
            // than previous item
            while (curr > 0 && list[curr - 1] > temp) {
                    list[curr] = list[curr - 1];
                    curr--;
            }
            list[curr] = temp;
        }
    }

}
