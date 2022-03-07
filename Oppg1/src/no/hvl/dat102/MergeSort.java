package no.hvl.dat102;

public class MergeSort {

	public static <T extends Comparable<? super T>> void sort(T[] array) {
		sort(array, 0, array.length);
	}

	public static <T extends Comparable<? super T>> void sort(T[] input, int start, int end) {
		if (end - start < 2) {
			return;
		}

		int mid = (start + end) / 2;
		sort(input, start, mid);
		sort(input, mid, end);
		merge(input, start, mid, end);
	}

	public static <T extends Comparable<? super T>> void merge(T[] input, int start, int mid, int end) {
		if (input[mid - 1].compareTo(input[mid]) <= 0) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		T[] temp = (T[]) new Comparable[end - start];
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i].compareTo(input[j]) <= 0 ? input[i++] : input[j++];
		}

		moveArrayElements(input, i, input, start + tempIndex, mid - i);
		moveArrayElements(temp, 0, input, start, tempIndex);
	}

	private static <T extends Comparable<? super T>> void moveArrayElements(T[] src, int srcPos, T[] dst, int dstPos, int len) {
		if (srcPos >= src.length)
			return;
		if (dstPos >= dst.length)
			return;
		if (srcPos + len > src.length)
			return;
		if (dstPos + len > dst.length)
			return;

		for (int i = dstPos; i < len + dstPos; i++) {
			dst[i] = src[srcPos++];
		}
	}
}
