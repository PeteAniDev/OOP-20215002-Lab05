package aims;

import java.util.ArrayList;
import java.util.List;

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
