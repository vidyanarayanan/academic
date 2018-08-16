package com.vn.alg.sort;

public class MergeSort {

	public static void mergeSort(int[] data) {
		if (data.length > 1) {
			int m = data.length/2;
			int[] left = new int[m];
			int[] right = new int[data.length - m];
			System.arraycopy(data, 0, left, 0, m);
			System.arraycopy(data, m, right, 0, data.length - m);
			mergeSort(left);
			mergeSort(right);
			merge(left, right, data);
		}
	}

	private static void merge(int[] left, int[] right, int[] output) {
		int l = 0, r = 0, k = 0;
		while (l < left.length && r < right.length) {
			if (left[l] <= right[r]) {
				output[k++] = left[l++];
			} else {
				output[k++] = right[r++];
			}	
		}
		while (l < left.length) {
			output[k++] = left[l++];
		}
		while (r < right.length) {
			output[k++] = right[r++];
		}
	}


	public static void main(String args[]) {
		int array[] = {8, 1, 7, 5, 9, 3, 4, 6, 2, 1};
		mergeSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
