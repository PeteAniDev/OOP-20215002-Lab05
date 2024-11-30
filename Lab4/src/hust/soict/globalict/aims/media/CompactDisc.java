package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {

	private String artist;
	private List<Track> tracks = new ArrayList<Track>();

	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}

	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}

	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}

	public CompactDisc(String title) {
		super(title);
	}

	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("CD length: " + this.getLength());
		for (Track track : tracks) {
			track.play();
		}
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

}
