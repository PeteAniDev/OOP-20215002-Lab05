package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class Media {

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

	private static int nbMedia = 0;

	protected int id = nbMedia++;
	protected String title = null;
	protected String category = null;
	protected float cost = 0;

	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public Media(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public float getCost() {
		return cost;
	}

	public boolean isMatch(String title2) {
		return title.toUpperCase().matches(title2.toUpperCase());
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Media) {
			Media media = (Media) o;
			return isMatch(media.getTitle());
		}
		return false;
	}

}
