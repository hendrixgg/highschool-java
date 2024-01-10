package SortAlgs;

// Performs an insertion sort on elements of a[] with the given gap.
// If gap == 1, performs an ordinary insertion sort.
// If gap >= length, does nothing.
public class ShellSort {

    public static void ascending(int[] arr) {
        /*
         * gaps[] should approximate a [geometric progression].
         * The following sequence is the best known in terms of     
         * the average number of key comparisons made
         */
        int[] gaps= new int[10];    
        // creates the gap pattern 1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524
        gaps[0] = 1;
        for (int i = 1; i < gaps.length-1; i++) {
            gaps[i] = 3 * gaps[i - 1] + 1;
        }

        for (int sizeIndex = gaps.length - 1; sizeIndex >= 0; sizeIndex--) {
            sortPhaseAscending(arr, gaps[sizeIndex]);
        }
    }

    public static void ascendingBest(int[] arr) {
        /*
         * gaps[] should approximate a [geometric progression].
         * The following sequence is the best known in terms of     
         * the average number of key comparisons made
         */
        int[] gaps = new int[15];    
        // creates the gap pattern 1, 5, 19, 41, 109, ...
        gaps[0] = 1;
        for (int i = 1; i < gaps.length; i++) {
            if((i) % 2 == 0) {
                gaps[i] = (int)(9*(Math.pow(2, i) - Math.pow(2, (i)/2)) + 1);
            }else {
                gaps[i] = (int)(8*Math.pow(2, i) - 6*Math.pow(2, (i+1)/2) + 1);
            }
        }

        for (int sizeIndex = gaps.length - 1; sizeIndex >= 0; sizeIndex--) {
            sortPhaseAscending(arr, gaps[sizeIndex]);
        }
    }

    private static void sortPhaseAscending(int a[], int gap) {
        for (int i = gap; i < a.length; ++i) {
            int value = a[i];
            int j;
            for (j = i - gap; j >= 0 && a[j] > value; j -= gap) {
                a[j + gap] = a[j];
            }
            a[j + gap] = value;
        }
    }
}
