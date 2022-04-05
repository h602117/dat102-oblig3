package no.hvl.dat102.haug.tabell;

import javax.naming.TimeLimitExceededException;

public class TabellHaug<T extends Comparable<T>> {

	private T[] data;
	private int antall;

	private static final int STDK = 100;

	public TabellHaug() {
		data = (T[]) new Comparable[STDK];
		antall = 0;
	}

	public void leggTilElement(T el) {
		if (antall == data.length)
			utvidTabell();
		data[antall] = el;
		antall++;
		if (antall > 1)
			reparerOpp();
	}

	private void utvidTabell() {
		int lengde = data.length;
		T[] ny = (T[]) new Comparable[2 * lengde];
		for (int i = 0; i < antall; i++)
			ny[i] = data[i];
		data = ny;
	}

	private void reparerOpp() {
		if (antall <= 1)
			return;

		int barn = antall - 1;
		int bror = barn % 2 == 0 ? barn - 1 : -1;
		int forelder = barn % 2 == 0 ? (barn - 2) / 2 : (barn - 1) / 2;

		while (barn > 0) {
			int tilFlytting = barn;
			if (bror != -1)
				tilFlytting = data[barn].compareTo(data[bror]) < 0 ? barn : bror;

			if (data[tilFlytting].compareTo(data[forelder]) >= 0)
				return;

			T tmp = data[forelder];
			data[forelder] = data[tilFlytting];
			data[tilFlytting] = tmp;

			barn = forelder;
			bror = barn % 2 == 0 ? barn - 1 : -1;
			forelder = barn % 2 == 0 ? (barn - 2) / 2 : (barn - 1) / 2;
		}
	}

	public T fjernMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
			data[0] = data[antall - 1];
			reparerNed();
			antall--;
		}
		return svar;
	}

	public T finnMinste() {
		T svar = null;
		if (antall > 0) {
			svar = data[0];
		}
		return svar;
	}

	private void reparerNed() {
		T hjelp;

		boolean ferdig = false;
		int forelder = 0;
		int minbarn;
		int vbarn = forelder * 2 + 1;
		int hbarn = vbarn + 1;
		while ((vbarn < antall) && !ferdig) {
			minbarn = vbarn;

			if ((hbarn < antall) && ((data[hbarn]).compareTo(data[vbarn]) < 0))
				minbarn = hbarn;

			if ((data[forelder]).compareTo(data[minbarn]) <= 0) {
				ferdig = true;
			} else {
				hjelp = data[minbarn];
				data[minbarn] = data[forelder];
				data[forelder] = hjelp;
				forelder = minbarn;
				vbarn = forelder * 2 + 1;
				hbarn = vbarn + 1;
			}
		}
	}

	public boolean erTom() {
		return antall == 0;
	}

	public void skrivTab() {
		for (int i = 0; i < antall; i++)
			System.out.print(data[i] + " ");
		System.out.println();
	}
}
