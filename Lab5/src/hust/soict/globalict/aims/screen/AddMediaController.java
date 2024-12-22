package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.exceptions.NonPositiveNumberException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class AddMediaController {

	@FXML
	private TextField bookAuthors;
	@FXML
	private TextField bookCategory;
	@FXML
	private TextField bookCost;
	@FXML
	private TextField bookTitle;
	@FXML
	private TextField cdArtist;
	@FXML
	private TextField cdCategory;
	@FXML
	private TextField cdCost;
	@FXML
	private TextField cdDirector;
	@FXML
	private TextField cdTitle;
	@FXML
	private TextField dvdCategory;
	@FXML
	private TextField dvdCost;
	@FXML
	private TextField dvdDirector;
	@FXML
	private TextField dvdLength;
	@FXML
	private TextField dvdTitle;
	@FXML
	private TabPane tab;

	private AddMediaScreen screen;

	public AddMediaController(AddMediaScreen screen) {
		super();
		this.screen = screen;
	}

	@FXML
	void addBook(ActionEvent event) {
		if (!bookTitle.getText().isBlank()) {
			try {
				float cost = parseFloat(bookCost.getText());
				Store.addMedia(new Book(bookTitle.getText(), bookCategory.getText(), cost));
				screen.main.store.updateCenter();
				JOptionPane.showMessageDialog(null, "Book has been added", "DVD ADDED",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Book title must not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void addCD(ActionEvent event) {
		if (!cdTitle.getText().isBlank()) {
			try {
				float cost = parseFloat(cdCost.getText());
				Store.addMedia(new CompactDisc(cdTitle.getText(), cdCategory.getText(), cdDirector.getText(), cost));
				screen.main.store.updateCenter();
				JOptionPane.showMessageDialog(null, "CD has been added", "DVD ADDED", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "CD title must not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void addDVD(ActionEvent event) {
		if (!dvdTitle.getText().isBlank()) {
			if (dvdLength.getText().isBlank()) {
				try {
					float cost = parseFloat(dvdCost.getText());
					Store.addMedia(new DigitalVideoDisc(dvdTitle.getText(), dvdCategory.getText(),
							dvdDirector.getText(), cost));
					screen.main.store.updateCenter();
					JOptionPane.showMessageDialog(null, "DVD has been added", "DVD ADDED",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				try {
					int length = parseInt(dvdLength.getText());
					try {
						float cost = parseFloat(dvdCost.getText());
						Store.addMedia(new DigitalVideoDisc(dvdTitle.getText(), dvdCategory.getText(),
								dvdDirector.getText(), length, cost));
						screen.main.store.updateCenter();
						JOptionPane.showMessageDialog(null, "DVD has been added", "DVD ADDED",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Invalid cost", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid length", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "DVD title must not be empty", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void viewCart(ActionEvent event) {
		screen.main.openCartScreen();
	}

	@FXML
	void viewStore(ActionEvent event) {
		screen.main.openStoreScreen();
	}

	@FXML
	void viewAddBook(ActionEvent event) {
		screen.main.openAddMediaScreen();
		screen.main.addMediaTab(0);
	}

	@FXML
	void viewAddCD(ActionEvent event) {
		screen.main.openAddMediaScreen();
		screen.main.addMediaTab(1);
	}

	@FXML
	void viewAddDVD(ActionEvent event) {
		screen.main.openAddMediaScreen();
		screen.main.addMediaTab(2);
	}

	public void setTab(int i) {
		tab.getSelectionModel().select(i);
	}

	private float parseFloat(String s) throws NonPositiveNumberException, NumberFormatException, NullPointerException {
		float f = Float.parseFloat(s);
		if (f <= 0) {
			throw new NonPositiveNumberException();
		}
		return f;
	}

	private int parseInt(String s) throws NonPositiveNumberException, NumberFormatException, NullPointerException {
		int f = Integer.parseInt(s);
		if (f <= 0) {
			throw new NonPositiveNumberException();
		}
		return f;
	}

}
