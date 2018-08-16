package com.vn.alg.sort;

/**
 * Created by i841928 on 12/8/16.
 */
public class MergeSortUtil {

    private static void merge(int[] left, int[] right, int[] array) {
        int lIndex = 0, rIndex = 0, index = 0;

       while(lIndex <  left.length && rIndex < right.length) {
           if (left[lIndex] <= right[rIndex]) {
               array[index] = left[lIndex];
               lIndex++;
           } else {
               array[index] = right[rIndex];
               rIndex++;
           }
           index++;
       }

       while (lIndex < left.length) {
           array[index] = left[lIndex];
           index++;
           lIndex++;
       }

       while (rIndex < right.length) {
           array[index] = right[rIndex];
           index++;
           rIndex++;
       }
    }


    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length > 1) {
            int mid = length / 2;
            int[] left = new int[mid];
            int[] right = new int[length - mid];

            for (int i = 0; i < mid; i++) {
                left[i] = array[i];
            }

            for (int i = mid; i < length; i++) {
                right[i-mid] = array[i];
            }

            mergeSort(left);
            mergeSort(right);
            merge(left, right, array);
        }

    }


    public static void main(String args[]) {
        int array[] = {9, 7, 5, 1, 3, 4, 6, 2, 8};

        mergeSort(array);
        print(array);
    }

    private static void print(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


}
