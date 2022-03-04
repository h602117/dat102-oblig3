package no.hvl.dat102;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		// Integer[] arr = generateArray(50000);
		Integer[] arr = { 5, 3, 4, 1, -6 };

		// long startTime = System.nanoTime();
		printArray(arr);
		insertionSort(arr, arr.length, true);
		printArray(arr);
		// long endTime = System.nanoTime();
		// System.out.println((endTime - startTime) / 1000000000 + " s");
	}

	private static Integer[] generateArray(int n) {
		Integer[] arr = new Integer[n];

		Random randy = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randy.nextInt();
		}

		return arr;
	}

	private static <T> void printArray(T[] arr) {
		System.out.print("[ ");
		for (T el : arr)
			System.out.print(el + " ");
		System.out.println("]");
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int n) {
		insertionSort(arr, 0, n - 1, false);
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int n, boolean two) {
		insertionSort(arr, 0, n - 1, two);
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int start, int end, boolean two) {
		if (two) {
			for (int i = start + 1; i <= end - 1; i++) {
				T tmp1 = arr[i];
				T tmp2 = arr[i + 1];
				int j = i - 1;
				boolean done = false;
				while (!done && j >= 0) {
					if (tmp2.compareTo(arr[j]) < 0) {
						if (tmp1.compareTo(arr[j]) < 0) {
							arr[j + 2] = arr[j];
							arr[j] = tmp1;
							arr[j + 1] = tmp2;
							j--;
						} else {
							arr[j + 2] = tmp1;
							arr[j + 1] = arr[j];
							arr[j] = tmp2;
							tmp1 = arr[j];
							tmp2 = arr[j + 1];
							j--;
						}
					} else if (tmp1.compareTo(arr[j]) < 0) {
						arr[j + 1] = arr[j];
						arr[j] = tmp1;
						tmp2 = arr[j + 1];
						j--;
					} else {
						done = true;
					}
				}
			}
		} else {
			for (int i = start + 1; i <= end; i++) {
				T temp = arr[i];
				int j = i - 1;
				boolean done = false;
				while (!done && j >= 0) {
					if (temp.compareTo(arr[j]) < 0) {
						arr[j + 1] = arr[j];
						j--;
					} else {
						done = true;
					}
				}
				arr[j + 1] = temp;
			}
		}
	}

}
