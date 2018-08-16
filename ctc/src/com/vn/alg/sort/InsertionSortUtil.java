package com.vn.alg.sort;

/**
 * Created by i841928 on 12/9/16.
 */
public class InsertionSortUtil {


    //4 3 5 1 2
//    public static void insertionSort(int[] data) {
//
//        for (int i = 1; i < data.length; i++) {
//            int val = data[i];
//            for (int j = 0;  j < i; j++) {
//                if (data[j] > val) {
//                    System.arraycopy(data, j, data, j + 1, i - 1);
//                    data[j] = val;
//                }
//            }
//        }
//    }


    public static void insertionSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int val = data[i];
            for (int j = 0; j < i; j++) {
                if (data[j] > val) {
                    System.arraycopy(data, j, data,j + 1, i - j);
                    data[j] = val;
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        int array[] = {2, 4, 2, 5, 1, 3, 6, 7, 9, 8};
        insertionSort(array);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
