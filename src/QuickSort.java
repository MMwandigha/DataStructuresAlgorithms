public class QuickSort {

    public static void swapOrder(int[] array, int x, int y) {
        double temp = array[x];
        array[x] = array[y];
        array[y] = (int) temp;
    }
    public static void sort(int[] array) { // goes to call the recursive method
        quicksort(array, 0, array.length-1);
    }

    public static void quicksort(int[] array, int left, int right) {
        if (left>=right) {
            return;
        }
        int pivot = array[(left+right) / 2];
        int index = divide(array, left, right, pivot); // returns partition point
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }
    public static int divide(int[] array, int left, int right, int
            pivot) { // returns int
        while (left <= right) { // track movement of left pointer till it gets to the mid
            while (array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swapOrder(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] lamp_heights = {2, 7, 1, 3, 8, 9, 4};
        sort(lamp_heights);
        for (int i = 0; i<lamp_heights.length; i++) {
            System.out.println(lamp_heights[i]);
        }

    }
}
