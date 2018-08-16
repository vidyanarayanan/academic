package com.vn.alg;

/**
 * Created by Vidya on 1/3/17.
 */
public class CountSort {

    public static int[] countSort(int[] data) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] > max) {
                max = data[i];
            }
        }

        int count[] = new int[max - min + 1];

        for (int i = 0; i < data.length; i++) {
            count[data[i] - min] ++;
        }

        for(int i=1; i< count.length; i++) {
            count[i]+= count[i -1];
        }

        // 7 4 2 3 2 1 5 9 3
        // 0 1 2 3 4 5 6 7 8 (min 1 max 9)
        // 1 2 3 4 5 6 7 8 9
        // 1 2 2 1 1 0 1 0 1 <= count orig
        // 0 1 3 5 7 6 7 8 8 <= count final
        // 1 2 2 3 3 4 5 7 9  <= sorted

        int[] sorted = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            int index = count[data[i] - min] -1;
            sorted[index] = data[i];
            count[data[i] - min]--;
        }
        return sorted;
    }

    public static final void main(String args[]) {
        int input[] = {89089, 17878, 776, 5434, 9090, 32425, 4111, 6787, 211, 1090, 776,345,76789,90909090};
        int sorted[] = countSort(input);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }

    }
}
