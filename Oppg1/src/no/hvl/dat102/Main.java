package no.hvl.dat102;

import java.util.Random;

public class Main {

	private final static int RUN_TIMES = 5;
	private final static int COUNT = 32000;

	private enum Algorithm {
		INSERTION, SELECTION, QUICK, MERGE
	}

	public static void main(String[] args) {

		long[] is = new long[RUN_TIMES];
		long[] ss = new long[RUN_TIMES];
		long[] qs = new long[RUN_TIMES];
		long[] ms = new long[RUN_TIMES];

		for (int i = 0; i < RUN_TIMES; i++) {
			is[i] = run(Algorithm.INSERTION);
			ss[i] = run(Algorithm.SELECTION);
			qs[i] = run(Algorithm.QUICK);
			ms[i] = run(Algorithm.MERGE);
		}

		System.out.println("Average:");
		System.out.println("---------------------------");
		System.out.println("QuickSort: " + avg(qs) + " ms");
		System.out.println("InsertionSort: " + avg(is) + " ms");
		System.out.println("SelectionSort: " + avg(ss) + " ms");
		System.out.println("MergeSort: " + avg(ms) + " ms");

	}

	private static long run(Algorithm algo) {
		Integer[] arr = generateArray(COUNT);
		long sTime;
		long dur = 0;

		switch (algo) {
			case INSERTION:
				System.out.println("Insertion");
				sTime = System.nanoTime();
				InsertionSort.sort(arr, arr.length);
				dur = (System.nanoTime() - sTime) / 1000000;
				break;
			case SELECTION:
				System.out.println("Selection");
				sTime = System.nanoTime();
				SelectionSort.sort(arr);
				dur = (System.nanoTime() - sTime) / 1000000;
				break;
			case QUICK:
				System.out.println("Quick");
				sTime = System.nanoTime();
				QuickSort.sort(arr);
				dur = (System.nanoTime() - sTime) / 1000000;
				break;
			case MERGE:
				System.out.println("Merge");
				sTime = System.nanoTime();
				MergeSort.sort(arr);
				dur = (System.nanoTime() - sTime) / 1000000;
				break;
		}

		System.out.println("Duration: " + dur + " ms");
		return dur;
	}

	private static long avg(long[] arr) {
		long sum = 0;

		for (long l : arr) {
			sum += l;
		}

		return sum / RUN_TIMES;
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
