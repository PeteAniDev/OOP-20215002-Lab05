package hust.soict.globalict.aims.store;

import java.util.ArrayList;
import java.util.List;

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

}
