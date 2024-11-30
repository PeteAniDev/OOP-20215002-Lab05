package hust.soict.globalict.aims.media;

public class Media {

	private static int nbMedia = 0;

	protected int id = nbMedia++;
	protected String title = null;
	protected String category = null;
	protected float cost = Float.MIN_VALUE;

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

}
