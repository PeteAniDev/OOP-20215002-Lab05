package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Disc;
import hust.soict.globalict.aims.media.Media;

public class Store {

	public static final int TYPE_CD = 0;
	public static final int TYPE_DVD = 1;
	public static final int TYPE_BOOK = 2;

	public static List<Media> itemsInStore = new ArrayList<Media>();

	public static void addMedia(Media... medias) {
		for (Media media : medias) {
			itemsInStore.add(media);
		}
	}

	public static void removeMedia(Media... medias) {
		for (Media media : medias) {
			itemsInStore.remove(media);
		}
	}

	public static void printItems() {
		System.out.println("***********************STORE***********************\nItems in store: ");
		for (int i = 0; i < itemsInStore.size(); i++) {
			System.out.println((i + 1) + ". " + itemsInStore.get(i));
		}
		System.out.println("***************************************************");
	}

	public static Media searchMedia(String title) {
		for (Media item : itemsInStore) {
			if (item.isMatch(title)) {
				if (item.getTitle() != null) {
					System.out.println("Found " + item.getTitle());
				}
				if (item.getCategory() != null) {
					System.out.println("Category: " + item.getCategory());
				}
				if (item instanceof Disc) {
					if (((Disc) item).getDirector() != null) {
						System.out.println("Director: " + ((Disc) item).getDirector());
					}
					if (item instanceof CompactDisc) {
						if (((CompactDisc) item).getArtist() != null) {
							System.out.println("Artist: " + ((CompactDisc) item).getArtist());
						}
					}
					if (((Disc) item).getLength() > 0) {
						System.out.println("Length: " + ((Disc) item).getLength());
					}
				}
				if (item instanceof Book) {
					boolean first = true;
					for (String author : ((Book) item).getAuthors()) {
						if (!first) {
							System.out.print(", ");
						} else {
							System.out.print("Authors: ");
						}
						first = true;
						System.out.print(author);
					}
					if (!((Book) item).getAuthors().isEmpty()) {
						System.out.println();
					}
				}
				if (item.getCost() > 0) {
					System.out.println("Cost: " + item.getCost());
				}
				return item;
			}
		}
		System.out.println("Cannot find media with that title in store.");
		return null;
	}

	public static List<Media> getItemsInStore() {
		return itemsInStore;
	}

}
