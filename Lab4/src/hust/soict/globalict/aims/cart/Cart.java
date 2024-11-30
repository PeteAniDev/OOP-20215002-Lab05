package hust.soict.globalict.aims.cart;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;

	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void printCart() {
		System.out.println("***********************CART***********************\nOrdered Items: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemsOrdered[i]);
		}
		System.out.println("Total cost: " + totalCost() + "\n***************************************************");
	}

	public void searchDVD(int id) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (id == itemsOrdered[i].getId()) {
				System.out.println("Found " + itemsOrdered[i]);
				return;
			}
		}
		System.out.println("Cannot find dvd with that id in cart.");
	}

	public void searchDVD(String title) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].isMatch(title)) {
				System.out.println("Found " + itemsOrdered[i]);
				return;
			}
		}
		System.out.println("Cannot find dvd with that title in cart.");
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvds) {
		for (DigitalVideoDisc dvd : dvds) {
			addDigitalVideoDisc(dvd);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED - 2) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added.");
		} else if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added, the cart is almost full.");
		} else if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added, the cart is now full.");
		} else {
			System.out.println("Failed to add " + dvd.getTitle() + " to cart, the cart is already full.");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		int removed = MAX_NUMBERS_ORDERED;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == dvd) {
				removed = i;
				break;
			}
		}
		for (int i = removed; i < qtyOrdered; i++) {
			itemsOrdered[i] = (i == MAX_NUMBERS_ORDERED - 1) ? null : itemsOrdered[i + 1];
		}
		if (removed != MAX_NUMBERS_ORDERED) {
			qtyOrdered--;
			System.out.println(dvd.getTitle() + " has been removed.");
		} else {
			System.out.println("Your cart doesn't have " + dvd.getTitle());
		}
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}

}