package hust.soict.globalict.aims.media;

public class Track implements Playable {

	private String title;
	private int length;

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

}
