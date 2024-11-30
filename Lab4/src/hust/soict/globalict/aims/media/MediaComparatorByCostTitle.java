package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		int compare = Float.compare(o1.getCost(), o2.getCost());
		if (compare == 0) {
			compare = o1.getTitle().compareTo(o2.getTitle());
		}
		return compare;
	}

}
