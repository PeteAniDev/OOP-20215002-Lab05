package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Disc;
import hust.soict.globalict.aims.media.Media;

public class Store {

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

	public static void searchMedia(String title) {
		for (Media item : itemsInStore) {
			if (item.isMatch(title)) {
				System.out.println("Found " + title);
				System.out.println("Category: " + item.getCategory());
				if (item instanceof Disc) {
					System.out.println("Director: " + ((Disc) item).getDirector());
					if (item instanceof CompactDisc) {
						System.out.println("Artist: " + ((CompactDisc) item).getArtist());
					}
					System.out.println("Length: " + ((Disc) item).getLength());
				}
				if (item instanceof Book) {
					System.out.print("Authors: ");
					boolean first = true;
					for (String author : ((Book) item).getAuthors()) {
						if (!first) {
							System.out.print(", ");
						}
						first = true;
						System.out.print(author);
					}
					System.out.println();
				}
				System.out.println("Cost: " + item.getCost());
				return;
			}
		}
		System.out.println("Cannot find media with that title in store.");
	}

}
