package no.hvl.dat102;

public class InsertionSort {

    public static <T extends Comparable<? super T>> void sort(T[] arr, int n) {
		sort(arr, 0, n - 1, false);
	}

	public static <T extends Comparable<? super T>> void sort(T[] arr, int n, boolean two) {
		sort(arr, 0, n - 1, two);
	}

	public static <T extends Comparable<? super T>> void sort(T[] arr, int start, int end, boolean two) {
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
