package com.vn.alg;

import java.util.ArrayList;

/**
 * Influenced by Kadane's algorithm
 */
public class MaximumSumSubArray {


    public static int[] getMaxSumSubArrayBF(int[] data) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int size = 1; size <= data.length; size++) {
            for (int i = 0; i + size <= data.length; i++) {
                int curIterationSum = 0;
                for (int j = i; j < i + size; j++) {
                    curIterationSum += data[j];
                }
                if (curIterationSum > max) {
                    max = curIterationSum;
                    start = i;
                    end = i + size - 1;
                }
            }
        }

        System.out.println(" sum " + max + " start " + start + " " + end);
        int output[] = new int[end - start + 1];
        System.arraycopy(data, start, output, 0, end - start + 1);
        return output;

    }

    public static int getMaxSumSubArray(int[] data) {
        int localSum = 0;
        int sum = 0;
        int index = 0;
//        int start = 0, end = 0;
        ArrayList<Integer> sub = new ArrayList<>();


        while (index < data.length) {

            localSum += data[index];
            if (localSum > 0) {
                sum = Math.max(localSum, sum);
                sub.add(data[index]);
            } else {
                sub.clear();
                localSum = 0;
            }
            index++;
        }

        return sum;

    }

    public static int[] getMaxSumSubArrayONSquare(int[] data) {
        int max = Integer.MIN_VALUE;
        int s = 0, e = 0;


        for (int startIndex = 0; startIndex < data.length; startIndex++) {
            int cumulativeSum = 0;

            for (int size = 1; size <= data.length && startIndex + size <= data.length; size++) {
                cumulativeSum += data[startIndex + size - 1];
                if (cumulativeSum >= max) {
                    max = cumulativeSum;
                    s = startIndex;
                    e = startIndex + size - 1;
                }
            }

        }

        System.out.println(" sum " + max + " start " + s + " " + e);
        int output[] = new int[e - s + 1];
        System.arraycopy(data, s, output, 0, e - s + 1);
        return output;
    }

    public static void main(String args[]) {
//        int[] data = {1, -1, 2, -3, 2, 1};
        int[] data = {1, -2, 2, 4, -3, 2, 1, 4, -1};
//        int max = getMaxSumSubArray(data);
//
//        System.out.print("{");
//        for(Integer val : output) {
//            System.out.print(val + " , ");
//        }
//        System.out.println("\b}");

         System.out.println(getMaxSumSubArray(data));
    }
}
