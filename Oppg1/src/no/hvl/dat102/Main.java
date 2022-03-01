package no.hvl.dat102;

public class Main {

	public static void main(String[] args) {
		Integer[] arr = { 5, 2, 6, 4 };
		printArray(arr);
		insertionSort(arr, arr.length);
		printArray(arr);
	}

	private static <T> void printArray(T[] arr) {
		System.out.print("[ ");
		for (T el : arr)
			System.out.print(el + " ");
		System.out.println("]");
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int n) {
		insertionSort(arr, 0, n - 1);
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] arr, int start, int end) {
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
