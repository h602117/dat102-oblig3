package no.hvl.dat102;

public class QuickSort {

	public static <T extends Comparable<? super T>> void sort(T[] array) {
		sort(array, 0, array.length);
	}

	public static <T extends Comparable<? super T>> void sort(T[] array, int start, int end) {
		if (end - start < 2) {
			return;
		}

		int pivotIndex = partition(array, start, end);
		sort(array, start, pivotIndex);
		sort(array, pivotIndex + 1, end);
	}

	public static <T extends Comparable<? super T>> int partition(T[] input, int start, int end) {
		T pivot = input[start];
		int i = start;
		int j = end;

		while (i < j) {
			while (i < j && input[--j].compareTo(pivot) >= 0)
				;
			if (i < j) {
				input[i] = input[j];
			}

			while (i < j && input[++i].compareTo(pivot) <= 0)
				;
			if (i < j) {
				input[j] = input[i];
			}

		}

		input[j] = pivot;
		return j;
	}
}
