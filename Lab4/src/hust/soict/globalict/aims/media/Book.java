package hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title) {
		super(title);
	}

	public void addAuthor(String author) {
		authors.add(author);
	}

	public void removeAuthor(String author) {
		authors.remove(author);
	}

	public List<String> getAuthors() {
		return authors;
	}

}
