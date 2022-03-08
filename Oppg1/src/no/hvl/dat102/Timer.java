package no.hvl.dat102;

public class Timer {

	private static long startTime;

	public static void start() {
		startTime = System.nanoTime();
	}

	public static long end() {
		long duration = (System.nanoTime() - startTime) / 1000000;
		System.out.println(duration + " ms");
		return duration;
	}

}
