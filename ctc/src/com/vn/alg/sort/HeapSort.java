package com.vn.alg.sort;
public class HeapSort {
	public static void heapSort(int data[]) {
		
		int size = data.length;
	 	for (int i = (size / 2) - 1; i >= 0; i--) {
			heapify(data, size, i);
		}	

		// Root has the max.. move it to the end of the array
		for (int i = size - 1; i >= 0; i--) {
			int t = data[i];
			data[i] = data[0];
			data[0] = t;
			
			// now, with the array size reduced by 1, reheapify at position 0
			heapify(data, i, 0);	
		}	
	
	}
	
	private static void heapify(int[] array, int size, int index) {
		//we are max heapifying, put the largest in the root node
		int maxIndex = index;
		int l = (2*index) + 1;
		int r = l + 1;
		
		if (l < size && array[l] > array[maxIndex]) {
			maxIndex = l;
		}
		if (r < size && array[r] > array[maxIndex]) {
			maxIndex = r;
		}
		if (maxIndex != index) {
			int temp = array[maxIndex];
			array[maxIndex] = array[index];
			array[index] = temp;
			
			heapify(array, size, maxIndex);
		}
	}

	public static void main(String args[]) {
		int input[] = {89089, 17878, 776, 5434, 9090, 32425, 4111, 6787, 211, 1090, 776,345,76789,90909090};
		heapSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
		}
	}

}
