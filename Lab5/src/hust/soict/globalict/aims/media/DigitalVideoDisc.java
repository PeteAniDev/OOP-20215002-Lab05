package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exceptions.PlayerException;

public class DigitalVideoDisc extends Disc {

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	@Override
	public String play() throws PlayerException {
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: DVD length is non-positive");
		}
		String string = "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
		System.out.println(string);
		return string;
	}

	@Override
	public String toString() {
		String dvd = "" + id + ": DVD";
		if (title != null) {
			dvd += " - " + title;
		}
		if (category != null) {
			dvd += " - " + category;
		}
		if (director != null) {
			dvd += " - " + director;
		}
		if (length > 0) {
			dvd += " - " + length;
		}
		if (cost > 0) {
			dvd += ": " + cost + "$";
		}
		return dvd;
	}

}