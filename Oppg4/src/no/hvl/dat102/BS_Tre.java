package no.hvl.dat102;

import java.util.Iterator;

public class BS_Tre<T extends Comparable<? super T>> implements SoektreInterface<T> {

	private BinaerTreNode<T> rot;

	public BS_Tre() {
		rot = null;
	}

	public BS_Tre(T element) {
		rot = new BinaerTreNode<T>(element);
	}

	/**
	 * S�ker etter et gitt element i treet.
	 *
	 * @param element elementet vi s�ker etter.
	 * @return true om elementet finst, false elles.
	 */
	public boolean inneholder(T element) {
		if (this.rot == null)
			return false;

		BinaerTreNode<T> node = this.rot;
		while (node != null) {
			if (node.getElement().compareTo(element) < 0) {
				node = node.getHogre();
			} else if (node.getElement().compareTo(element) > 0) {
				node = node.getVenstre();
			} else {
				return true;
			}
		}

		return false;
	}

	/**
	 * Henter et element i treet.
	 *
	 * @param element elementet vi leiter etter.
	 * @return Elementet dersom det finst, elles null.
	 */
	public T finn(T element) {
		return finn(element, rot);
	}

	private T finn(T element, BinaerTreNode<T> p) {
		T svar = null;

		// p == null -> tomt tre som er basistille og svar blir null
		if (p != null) {
			int sml = element.compareTo(p.getElement());
			if (sml == 0) {
				svar = p.getElement();
			} else if (sml < 0) {
				svar = finn(element, p.getVenstre());
			} else {
				svar = finn(element, p.getHogre());
			}
		}
		return svar;
	}

	/**
	 * Legg eit element til treet dersom det ikkje finst fr� f�r. Elles etstattar
	 * blir det gamle elementet erstatta med det nye.
	 *
	 * @param nyElement elementet som skal leggast til
	 * @return null om elementet ikkje finst fr� f�r. Elles det element som var i
	 *         treet fr� f�r.
	 */
	public T leggTil(T element) {
		if (this.inneholder(element)) {
			return element;
		}

		if (this.rot == null) {
			this.rot = new BinaerTreNode<T>(element);
		} else {
			BinaerTreNode<T> node = this.rot;
			while (true) {
				if (node.getElement().compareTo(element) < 0) {
					if (node.getHogre() == null) {
						node.setHogre(new BinaerTreNode<T>(element));
						break;
					}
					node = node.getHogre();
				} else {
					if (node.getVenstre() == null) {
						node.setVenstre(new BinaerTreNode<T>(element));
						break;
					}
					node = node.getVenstre();
				}
			}
		}

		return null;
	}

	/**
	 * Fjernar eit element fr� treet.
	 *
	 * @param element elementet som skal fjernast.
	 * @return elementet som vart fjerna eller null om det ikkje finst.
	 */
	public T fjern(T element) {
		return null;
	}

	/**
	 * Lagar ein iterator som g�r gjennom alle element i treet i inorden.
	 *
	 * @return ein iterator som elementa i sortert rekkef�lge.
	 */
	public Iterator<T> getInordenIterator() {
		return null;
	}

	// Oppgave 1
	public int hoyde() {
		return hoydeRek(rot);
	}

	private int hoydeRek(BinaerTreNode<T> node) {
		if (node == null)
			return -1;
		return Math.max(1 + hoydeRek(node.getHogre()), 1 + hoydeRek(node.getVenstre()));
	}

}
