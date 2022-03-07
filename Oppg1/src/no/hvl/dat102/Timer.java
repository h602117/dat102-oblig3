package no.hvl.dat102;

public class Timer {

	private static long startTime;

	public static void start() {
		startTime = System.nanoTime();
	}

	public static void end() {
		long duration = System.nanoTime() - startTime;
		System.out.println(duration / 1000000000 + " s");
	}

}
