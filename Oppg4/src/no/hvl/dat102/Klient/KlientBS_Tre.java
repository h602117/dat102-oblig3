package no.hvl.dat102.Klient;

import java.util.Random;

import no.hvl.dat102.BS_Tre;

public class KlientBS_Tre {

	public static void main(String[] args) {
		randomTre(1024, 100);
	}

	private static void randomTre(int antNoder, int antTre) {
		int minHoyde = antNoder - 1;
		int maksHoyde = 0;
		int avgHoyde = 0;

		for (int i = 0; i < antTre; i++) {
			BS_Tre<Integer> bsTre = new BS_Tre<>();

			for (int j = 0; j < antNoder; j++) {
				bsTre.leggTil(terning.nextInt());
			}

			int hoyde = bsTre.hoyde();
			avgHoyde += hoyde;

			if (minHoyde > hoyde) {
				minHoyde = hoyde;
			}

			if (maksHoyde < hoyde) {
				maksHoyde = hoyde;
			}
		}

		double avgHoydeEK = avgHoyde / (double) antTre;

		System.out.println("Antall noder: " + antNoder);
		System.out.println("Teoretisk minimal hoyde: " + minHoyde(antNoder));
		System.out.println("Teoretisk maksimal hoyde: " + (antNoder - 1));
		System.out.println("Minimal hoyde etter kjoring: " + minHoyde);
		System.out.println("Maksimal hoyde etter kjoring: " + maksHoyde);
		System.out.println("Gjennomsnittlig hoyde etter kjoring: " + avgHoydeEK);
	}

	static Random terning = new Random();

	private static int minHoyde(int antall) {
		if (antall == 0) {
			return -1;
		}

		int hoyde = -1;
		int noder = antall;
		while (noder != 0) {
			hoyde++;
			noder /= 2;
		}

		return hoyde;
	}
}
