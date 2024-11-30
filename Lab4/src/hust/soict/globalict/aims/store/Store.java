package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {

	public static List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();

	public static void addDVD(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc dvd : dvds) {
			addDVD(dvd);
		}
	}

	public static void addDVD(DigitalVideoDisc dvd) {
		itemsInStore.add(dvd);
	}

	public static void removeDVD(DigitalVideoDisc dvd) {
		itemsInStore.remove(dvd);
	}

}
