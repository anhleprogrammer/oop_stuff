package Sort;

import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
        int[] arr = new int[]{64, 25, 12, 22, 11};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void selectionSort(int[] arr) {
        //2 parts: unsorted and sorted subarray
        //Find the min or max value from unsorted and move to last element of sorted subarray
        //ascending order ---> find min
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] <= arr[minIndex]) {
                    minIndex = j; //find index of minVal/maxVal
                }
            }
            if(i != minIndex) { //swap last number of sorted with minVal
                int num = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = num;
            }
        }
        //i index point at last number of sorted array,
        // j index point at first number of unsorted array
        //increment i after each swap to update sorted subarray
    }
    public static void insertionSort(int[] arr) {

    }
}
