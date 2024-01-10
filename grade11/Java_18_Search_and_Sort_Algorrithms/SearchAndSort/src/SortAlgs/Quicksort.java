package SortAlgs;

public class Quicksort {

    public static void quicksortAscending(int[] arr, int l, int r ) {
        if (l >= r)
            return;

        // This will partition the array in 2
        int i = l - 1, pivot = arr[r], t;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++; // increment i
                // swap values at i and j
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        t = arr[i+1];
        arr[i + 1] = arr[r];
        arr[r] = t;
        int p = i + 1; // the index of the pivot

        quicksortAscending(arr, l, p - 1);
        quicksortAscending(arr, p + 1, r);
    }

}