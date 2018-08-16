package com.vn.alg.sort;

public class CountingSort {
	public static int[] countingSortMoreMemory(int data[]) {
		if (data.length == 0 ) {
			return data;
		}
		int[] sorted = new int[data.length];
		int min = data[0], max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] < min) {
				min = data[i];
			}
			if (data[i] > max) {
				max = data[i];
			}
		}
		
		int[] sumCount = new int[max - min + 1];
		int[] count = new int[max - min + 1];
		
		for (int i = 0; i < data.length; i++) {
			count[data[i] - min]++;
		}
		
		sumCount[0] = count[0];
		for(int i = 1; i < count.length; i++) {
			sumCount[i] = count[i] + sumCount[i - 1];
		}
		
		for (int i = 0; i < data.length; i++) {
			int index = sumCount[data[i]- min] - 1;
			sorted[index] = data[i];
			sumCount[data[i] - min]--;
		}
		return sorted;
	}

	public static int[] countingSort(int data[]) {
		if (data.length <= 1 ) {
			return data;
		}
		int[] sorted = new int[data.length];
		int min = data[0], max = data[0];
		for (int i = 0; i < data.length; i++) {
			if (data[i] < min) {
				min = data[i];
			}
			if (data[i] > max) {
				max = data[i];
			}
		}

		int[] count = new int[max - min + 1];

		for (int i = 0; i < data.length; i++) {
			count[data[i] - min]++;
		}

		for(int i = 1; i < count.length; i++) {
			count[i] = count[i] + count[i - 1];
		}

		for (int i = 0; i < data.length; i++) {
			int index = count[data[i]- min] - 1;
			sorted[index] = data[i];
			count[data[i] - min]--;
		}
		return sorted;
	}


	public static void main(String args[]) {
		int input[] = {89089, 17878, 776, 5434, 9090, 32425, 4111, 6787, 211, 1090, 776,345,76789,90909090};
		int sorted[] = countingSort(input);
		for (int i = 0; i < sorted.length; i++) {
			System.out.println(sorted[i]);
		}
	}
}

