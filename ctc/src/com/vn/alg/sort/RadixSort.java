package com.vn.alg.sort;

import java.util.ArrayList;

public class RadixSort {
	public static final int RADIX = 10;
	public static void radixSort(int[] data) {

		boolean done = false;
		ArrayList<Integer> buckets[] = new ArrayList[RADIX];
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new ArrayList<Integer>();
		}
		int max = data[0];
		for (int i = 1; i < data.length; i++) {
			if (data[i] > max) {
				max = data[i];
			}
		}

		int ndigs = (int) (Math.log10(max));

		for (int i = 1; i <= ndigs; i++) {

			for (int j = 0 ; j < data.length; j++) {
				int bucket = (int) ((int)data[j] % Math.pow(10,i)) / (int) Math.pow(10, i-1);
				buckets[bucket].add(data[j]);
				if (data[i] > max) {
					max = data[i];
				}
			}
			int index = 0;
			for (int k = 0; k < RADIX; k++) {
				for (Integer num: buckets[k]) {
					data[index ++] = num;
				}
				buckets[k].clear();
			}
		}
	}

	public static void main(String args[]) {
		int input[] = {89089, 17878, 776, 5434, 9090, 32425, 4111, 6787, 2110, 1090, 776,345,76789,90909090};
		radixSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}
				
}
