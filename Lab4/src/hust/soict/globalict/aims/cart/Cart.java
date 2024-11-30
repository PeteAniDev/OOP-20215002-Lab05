package hust.soict.globalict.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Media;

public class Cart {

	private List<Media> itemsOrdered = new ArrayList<Media>();

	public void printCart() {
		System.out.println("***********************CART***********************\nOrdered Items: ");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.println((i + 1) + ". " + itemsOrdered.get(i));
		}
		System.out.println("Total cost: " + totalCost() + "\n***************************************************");
	}

	public void searchMedia(int id) {
		for (Media item : itemsOrdered) {
			if (id == item.getId()) {
				System.out.println("Found " + item);
				return;
			}
		}
		System.out.println("Cannot find dvd with that id in cart.");
	}

	public void searchMedia(String title) {
		for (Media item : itemsOrdered) {
			if (item.isMatch(title)) {
				System.out.println("Found " + item);
				return;
			}
		}
		System.out.println("Cannot find dvd with that title in cart.");
	}

	public void addMedia(Media... items) {
		for (Media item : items) {
			itemsOrdered.add(item);
		}
	}

	public void removeMedia(Media... items) {
		for (Media item : items) {
			itemsOrdered.remove(item);
		}
	}

	public float totalCost() {
		float total = 0;
		for (Media item : itemsOrdered) {
			total += item.getCost();
		}
		return total;
	}

}