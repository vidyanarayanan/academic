package com.vn.alg.sort;

public class QuickSort {

	public static void quickSort(int data[], int start, int end) {
		if (start < end) {
			int partition = partition(data, start, end);
			quickSort(data, start, partition - 1);
			quickSort(data, partition + 1, end);
		}
	}
	
	private static int partition(int data[], int start, int end) {
		int pivot = data[end];
		int pivotIndex = start;
		for (int i = start; i < end; i++) {
			if (data[i] < pivot) {
				swap(data, i, pivotIndex);
				pivotIndex++;
			}
		}
		swap(data, pivotIndex, end);
		return pivotIndex;
	}

	private static void swap(int data[], int i, int j) {
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}




}

