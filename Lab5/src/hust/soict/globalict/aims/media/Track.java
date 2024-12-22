package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exceptions.PlayerException;

public class Track implements Playable {

	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	@Override
	public String play() throws PlayerException {
		if (getLength() <= 0) {
			throw new PlayerException("ERROR: Track length is non-positive");
		}
		String string = "Playing DVD: " + this.getTitle() + "\nDVD length: " + this.getLength();
		System.out.println(string);
		return string;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Track) {
			Track track = (Track) o;
			return title.toUpperCase().matches(track.getTitle().toUpperCase()) && track.getLength() == length;
		}
		return false;
	}

}
