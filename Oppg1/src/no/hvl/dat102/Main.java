package no.hvl.dat102;

import java.util.Random;

public class Main {

	private final static int COUNT = 10;

	public static void main(String[] args) {

		Integer[] arr = generateArray(32000);

		long[] qs = new long[COUNT];
		long[] is = new long[COUNT];
		long[] ss = new long[COUNT];
		long[] ms = new long[COUNT];

		for (int i = 0; i < COUNT; i++) {
			Integer[] arr1 = arr.clone();
			Integer[] arr2 = arr.clone();
			Integer[] arr3 = arr.clone();
			Integer[] arr4 = arr.clone();

			System.out.println("QuickSort");
			Timer.start();
			QuickSort.sort(arr1);
			qs[i] = Timer.end();

			Timer.start();
			System.out.println("InsertionSort");
			InsertionSort.sort(arr2, arr2.length);
			is[i] = Timer.end();

			Timer.start();
			System.out.println("SelectionSort");
			SelectionSort.sort(arr3);
			ss[i] = Timer.end();

			Timer.start();
			System.out.println("MergeSort");
			MergeSort.sort(arr4);
			ms[i] = Timer.end();
		}

		System.out.println("Average:");
		System.out.println("---------------------------");
		System.out.println("QuickSort: " + avg(qs) + " ms");
		System.out.println("InsertionSort: " + avg(is) + " ms");
		System.out.println("SelectionSort: " + avg(ss) + " ms");
		System.out.println("MergeSort: " + avg(ms) + " ms");

	}

	private static long avg(long[] arr) {
		long sum = 0;

		for (long l : arr) {
			sum += l;
		}

		return sum / COUNT;
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
