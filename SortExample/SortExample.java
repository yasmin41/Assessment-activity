import java.util.Arrays;

/**
 * This class demonstrates sorting algorithms: QuickSort and MergeSort.
 * 
 * @author  YASMIN
 * @version 1.0
 * @since   2025-04-15
 */
public class SortExample {

    /**
     * Main method to test the sorting algorithms.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        quickSort(array1, 0, array1.length - 1);
        System.out.println("Sorted using QuickSort: " + Arrays.toString(array1));

        mergeSort(array2, array2.length);
        System.out.println("Sorted using MergeSort: " + Arrays.toString(array2));
    }

    /**
     * Sorts an array using the QuickSort algorithm.
     * 
     * @param arr  The array to be sorted
     * @param low  The starting index
     * @param high The ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {
        if (arr == null || arr.length == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) quickSort(arr, low, j);
        if (high > i) quickSort(arr, i, high);
    }

    /**
     * Swaps two elements in an array.
     * 
     * @param array The array
     * @param x     Index of the first element
     * @param y     Index of the second element
     */
    public static void swap(Integer[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using the MergeSort algorithm.
     * 
     * @param a The array to be sorted
     * @param n The length of the array
     */
    public static void mergeSort(int[] a, int n) {
        if (n < 2) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) l[i] = a[i];
        for (int i = mid; i < n; i++) r[i - mid] = a[i];

        mergeSort(l, mid);
        mergeSort(r, n - mid);
        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted arrays into a single sorted array.
     * 
     * @param a     The original array
     * @param l     Left half
     * @param r     Right half
     * @param left  Size of left half
     * @param right Size of right half
     */
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) a[k++] = l[i++];
        while (j < right) a[k++] = r[j++];
    }

    /**
     * Checks if an array is sorted in ascending order.
     * 
     * @param x The array to check
     * @return true if sorted, false otherwise
     */
    private static boolean isSorted(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] > x[i + 1]) return false;
        }
        return true;
    }
}
