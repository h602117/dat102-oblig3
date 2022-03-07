package no.hvl.dat102;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Integer[] arr1 = generateArray(10);
		Integer[] arr2 = arr1.clone();
		Integer[] arr3 = arr1.clone();
		Integer[] arr4 = arr1.clone();

		System.out.println("QuickSort");
		printArray(arr1);
		QuickSort.sort(arr1);
		printArray(arr1);

		System.out.println("InsertionSort");
		printArray(arr2);
		InsertionSort.sort(arr2, arr2.length);
		printArray(arr2);

		System.out.println("SelectionSort");
		printArray(arr3);
		SelectionSort.sort(arr3);
		printArray(arr3);

		System.out.println("MergeSort");
		printArray(arr4);
		MergeSort.sort(arr4);
		printArray(arr4);
	}

	private static Integer[] generateArray(int n) {
		Integer[] arr = new Integer[n];

		Random randy = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.abs(randy.nextInt()) % n;
		}

		return arr;
	}

	private static <T> void printArray(T[] arr) {
		System.out.print("[ ");
		for (T el : arr)
			System.out.print(el + " ");
		System.out.println("]");
	}

}
