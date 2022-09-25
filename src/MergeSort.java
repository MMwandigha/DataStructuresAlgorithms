import java.util.concurrent.TimeUnit;

public class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    public void merge(int array[], int l, int midpoint, int r)
    {
        // Find sizes of two subarrays to be merged

        int n1 = midpoint - l + 1;
        int n2 = r - midpoint;

        /* Create temp arrays */
        int LEFTSIDE[] = new int[n1];
        int RIGHTSIDE[] = new int[n2];

        // Copy values to temp arrays,
        for (int i = 0; i < n1; ++i)
            LEFTSIDE[i] = array[l + i];
        for (int j = 0; j < n2; ++j)
            RIGHTSIDE[j] = array[midpoint + 1 + j];

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (LEFTSIDE[i] <= RIGHTSIDE[j]) {
                array[k] = LEFTSIDE[i];
                i++;
            }
            else {
                array[k] = RIGHTSIDE[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = LEFTSIDE[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = RIGHTSIDE[j];
            j++;
            k++;
        }
    }

    // SORT
    void sort(int array[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves

            sort(array, l, m); // sort the left side
            sort(array, m + 1, r); // sort the left side
            merge(array, l, m, r);
        }
    }

    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    // Driver method
    public static void main(String args[]) throws InterruptedException
    {
        long startTime = System.nanoTime();
        int data[] = {12, 34, 1, 24, 45, 11, 8, 7, 2};
        MergeSort object = new MergeSort();
        object.sort(data, 0, data.length - 1);
        System.out.print("\nSorted : ");
        printArray(data);

        TimeUnit.SECONDS.sleep(1);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in nanoseconds: " +
                timeElapsed);

    }


}
