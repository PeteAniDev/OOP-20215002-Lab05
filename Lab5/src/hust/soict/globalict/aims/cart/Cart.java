package hust.soict.globalict.aims.cart;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {

	public static final int FILTER_NONE = 0;
	public static final int FILTER_BY_ID = 1;
	public static final int FILTER_BY_TITLE = 2;

	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	private int idFilter = -1;
	private String titleFilter = "";

	public void printCart(int filter) {
		if (filter == FILTER_NONE) {
			System.out.println("***********************CART***********************\nOrdered Items: ");
		} else if (filter == FILTER_BY_ID) {
			System.out.println("***************FILTERED CART BY ID****************\nOrdered Items: ");
		} else if (filter == FILTER_BY_TITLE) {
			System.out.println("**************FILTERED CART BY TITLE**************\nOrdered Items: ");
		}
		float cost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (filter == FILTER_BY_ID && itemsOrdered.get(i).getId() != idFilter) {
				continue;
			}
			if (filter == FILTER_BY_TITLE && !itemsOrdered.get(i).isMatch(titleFilter)) {
				continue;
			}
			System.out.println((i + 1) + ". " + itemsOrdered.get(i));
			cost += itemsOrdered.get(i).getCost();
		}
		System.out.println("Total cost: " + cost + "\n***************************************************");
	}

	public void sortCart(Comparator<Media> sorter) {
		itemsOrdered.sort(sorter);
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

	public Media searchMedia(String title) {
		for (Media item : itemsOrdered) {
			if (item.isMatch(title)) {
				System.out.println("Found " + item);
				return item;
			}
		}
		System.out.println("Cannot find dvd with that title in cart.");
		return null;
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

	public int numberOfItems() {
		return itemsOrdered.size();
	}

	public boolean contains(Media item) {
		return itemsOrdered.contains(item);
	}

	public void setIdFilter(int idFilter) {
		this.idFilter = idFilter;
	}

	public void setTitleFilter(String titleFilter) {
		this.titleFilter = titleFilter;
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

}