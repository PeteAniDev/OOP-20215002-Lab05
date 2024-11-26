package aims;

public class DigitalVideoDisc {

	private static int nbDigitalVideoDiscs = 0;

	private int id = nbDigitalVideoDiscs++;
	private String title = null;
	private String category = null;
	private String director = null;
	private int length = Integer.MIN_VALUE;
	private float cost = Float.MIN_VALUE;

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title) {
		this.title = title;
	}

	public boolean isMatch(String title2) {
		return title.toUpperCase().matches(title2.toUpperCase());
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

	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

	public float getCost() {
		return cost;
	}

	@Override
	public String toString() {
		String dvd = "DVD";
		if (title != null) {
			dvd += " - " + title;
		}
		if (category != null) {
			dvd += " - " + category;
		}
		if (director != null) {
			dvd += " - " + director;
		}
		if (length != Integer.MIN_VALUE) {
			dvd += " - " + length;
		}
		if (cost != Float.MIN_VALUE) {
			dvd += ": " + cost + "$";
		}
		return dvd;
	}

}