package com.vn.alg.sort;

/**
 * Created by i841928 on 12/9/16.
 */
public class BubbleSortUtil {




    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    private static void bubbleSort(int[] data) {
        boolean swapped = true;
        for (int i = data.length - 1; i >= 0  && swapped; i --) {
            swapped = false;
            for (int j = 0; j < i ; j ++) {
                if (data[j] > data[j+1]) {
                    swap(data, j, j + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        int array[] = {2, 4, 2, 5, 1, 3, 6, 7, 9, 8, 3};
        bubbleSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
