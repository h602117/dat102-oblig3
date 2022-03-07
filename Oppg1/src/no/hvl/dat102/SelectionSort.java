package no.hvl.dat102;

public class SelectionSort {

	public static <T extends Comparable<? super T>> void sort(T[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0;
                lastUnsortedIndex--) {

            int largest = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[i].compareTo(array[largest]) > 0) {
                    largest = i;
                }
            }

            swap(array, largest, lastUnsortedIndex);

        }
	}

    public static <T extends Comparable<? super T>> void swap(T[] array, int i, int j) {
        if (i == j)
            return;

        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
