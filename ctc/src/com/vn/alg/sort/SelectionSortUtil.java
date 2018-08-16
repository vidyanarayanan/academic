package com.vn.alg.sort;

/**
 * Created by i841928 on 12/28/16.
 */
public class SelectionSortUtil {

    public static int[] selectionSort(int[]  data) {

        for (int i = 1; i < data.length; i++) {
            int min = data[i - 1];
            int pos = i - 1;

            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
                    min = data[j];
                    pos = j;
                }
            }
            data[pos] = data[i - 1];
            data[i - 1] = min;
        }

        return data;
    }


    public static void main(String args[]) {
        int array[] = {8, 1, 7, 5, 9, 3, 4, 6, 2, 1};
        array = selectionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
