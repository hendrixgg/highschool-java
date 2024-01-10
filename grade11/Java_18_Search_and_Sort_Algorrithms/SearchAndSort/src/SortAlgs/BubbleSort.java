package SortAlgs;

/**
 * <h3>BubbleSort</h3>
 * 
 * <p>
 * Bubble Sort is one of the simplest sorting algorithims to implement.
 * Unfortunately, it is also one of the slowest sorting methods.
 * </p>
 * 
 * <h4>Here's how it works: </h4>
 * 
 * <p>
 * Assume that we have an array of integer numbers to be put into ascending
 * order. An algorithm (plan) for the bubble sort is this:
 * </p>
 * <p>
 * - Go through the array. Start with the first number in the list and compare
 * each number with the number that was after it.
 * </p>
 * <p>
 * - If the two numbers are out of order (current number larger than the next
 * number), swap them.
 * </p>
 * <p>
 * - Continue until we have compared the last number with the second last number
 * in the array.
 * </p>
 * <p>
 * - Go through the list again and again until it is in order.
 * </p>
 * <p>
 * Here is an example of an array of eight numbers to be put into increasing
 * order :
 * </p>
 * <blockquote>
 * 
 * <pre>
 * int[] arr = { 5, 7, 11, 6, 17, 19, 16, 2 };
 * </pre>
 * 
 * </blockquote>
 * <p>
 * Start with the {@code 5} Nothing happens when {@code 5} is compared with
 * {@code 7}, next, when {@code 7} is compared with {@code 11}. The {@code 11}
 * and the {@code 6}, however, are out of order and must be <i>swapped</i>. The
 * array then looks like this:
 * </p>
 * <blockquote>
 * 
 * <pre>
 * int[] arr = { 5, 7, 6, 11, 17, 19, 16, 2 };
 * </pre>
 * 
 * </blockquote>
 * <p>
 * This process is repeated for each element in the array until all elements are
 * sorted. This is one pass.
 * </p> 
 * <blockquote>
 * 
 * <pre>
 * arr = { 5, 7, 6, 11, 17, 19, 16, 2 }; //after first pass
 * </pre>
 * 
 * </blockquote><p>
 * Then the algorithim goes back to the front of the
 * array and repeats.
 * </p>
 * <p>
 * As we keep repeating the process, the list looks like :
 * </p><blockquote>
 * 
 * <pre>
 * arr = { 5, 6, 7, 11, 16, 2, 17, 19}; //after seconnd pass
 * arr = { 5, 6, 7, 11, 2, 16, 17, 19}; //after third pass
 * arr = { 5, 6, 7, 2, 11, 16, 17, 19}; //after fourth pass
 * arr = { 5, 6, 2, 7, 11, 16, 17, 19}; //after fifth pass
 * arr = { 5, 2, 6, 7, 11, 16, 17, 19}; //after sixth pass
 * arr = { 2, 5, 6, 7, 11, 16, 17, 19}; //after seventh pass
 * </pre>
 * 
 * </blockquote>
 * 
 * 
 */
public class BubbleSort {

    /**
     * sort the elements in an array from smallest to largest
     * @param a the int array which will be sorted
     */
    public static void SortAscending(int[] a) {

        int temp;

        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = 0; i < a.length - 1; i++) {
                // if next element is smaller than current, swap elements
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    /**
     * sort the elements in an array from smallest to largest
     * @param a the double array which will be sorted
     */
    public static void SortAscending(double[] a) {

        double temp;

        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = 0; i < a.length - 1; i++) {
                // if next element is smaller than current, swap elements
                if (a[i] > a[i + 1]) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    /**
     * sort the elements in an array from smallest to largest
     * @param a the String array which will be sorted
     */
    public static void SortAscending(String[] a) {

        String temp;
        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = 0; i < a.length - 1; i++) {
                // if next element is smaller than current, swap elements
                if (a[i].compareTo(a[i + 1]) > 0) {
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    /**
     * sort the elements in an array from largest to smallest
     * @param a the int array which will be sorted
     */
    public static void SortDescending(int[] a) {

        int temp;

        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = a.length - 1; i > 0; i--) {
                // if next element is smaller than current, swap elements
                if (a[i] > a[i-1]) {
                    temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
            }
        }
    }

    /**
     * sort the elements in an array from largest to smallest
     * @param a the double array which will be sorted
     */
    public static void SortDescending(double[] a) {

        double temp;

        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = a.length - 1; i > 0; i--) {
                // if next element is smaller than current, swap elements
                if (a[i] > a[i-1]) {
                    temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
            }
        }
    }

    /**
     * sort the elements in an array from largest to smallest
     * @param a the String array which will be sorted
     */
    public static void SortDescending(String[] a) {

        String temp;

        // outer loop that makes (a.length –1)passes in the array
        for (int j = 0; j < a.length - 1; j++) {
            // go through all the elements and swap as needed
            for (int i = a.length - 1; i > 0; i--) {
                // if next element is smaller than current, swap elements
                if (a[i].compareTo(a[i-1]) > 0) {
                    temp = a[i];
                    a[i] = a[i-1];
                    a[i-1] = temp;
                }
            }
        }
    }
}
