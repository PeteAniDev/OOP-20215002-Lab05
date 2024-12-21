package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public CompactDisc(String title) {
		super(title);
	}

	@Override
	public String play() {
		String string = "Playing CD: " + this.getTitle() + "\nCD length: " + this.getLength();
		for (Track track : tracks) {
			string += "\n" + track.play();
		}
		return string;
	}

	public void addTrack(Track track) {
		tracks.add(track);
	}

	public void removeTrack(Track track) {
		tracks.remove(track);
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length += track.getLength();
		}
		return length;
	}

	@Override
	public String toString() {
		String cd = "" + id + ": CD";
		if (title != null) {
			cd += " - " + title;
		}
		if (category != null) {
			cd += " - " + category;
		}
		if (director != null) {
			cd += " - " + director;
		}
		if (artist != null) {
			cd += " - " + artist;
		}
		if (getLength() > 0) {
			cd += " - " + getLength();
		}
		if (cost > 0) {
			cd += ": " + cost + "$";
		}
		return cd;
	}

}
