package com.vn.alg.sort;

/**
 * Created by i841928 on 12/8/16.
 */
public class QuickSortUtil {


    private static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int pivotIndex = partition(array, start, end);
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
    }


    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pivotIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i] < pivot) {
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(array, pivotIndex, end);
        return pivotIndex;
    }

    private static void swap(int[] array, int i, int pIndex) {
        int temp = array[i];
        array[i] = array[pIndex];
        array[pIndex] = temp;
     }


    public static void main(String args[]) {
        int array[] = {9,7,5,1,3,4,6,2,8};
        quickSort(array, 0, array.length-1);

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }



}
