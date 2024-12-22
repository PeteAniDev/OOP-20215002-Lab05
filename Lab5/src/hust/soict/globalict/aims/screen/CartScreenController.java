package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exceptions.PlayerException;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

	@FXML
	private ToggleGroup filterCategory;
	@FXML
	private TableView<Media> media;
	@FXML
	private TableColumn<Media, String> mediaCategory;
	@FXML
	private TableColumn<Media, String> mediaTitle;
	@FXML
	private TableColumn<Media, Float> mediaCost;
	@FXML
	private Label totalCost;
	@FXML
	private Button buttonPlay;
	@FXML
	private Button buttonRemove;
	@FXML
	private TextField filter;

	private Cart cart;
	private CartScreen screen;

	public CartScreenController(Cart cart, CartScreen screen) {
		super();
		this.cart = cart;
		this.screen = screen;
	}

	@FXML
	private void initialize() {
		mediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
		mediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
		mediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
		media.setItems(cart.getItemsOrdered());

		buttonPlay.setVisible(false);
		buttonRemove.setVisible(false);

		media.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
			@Override
			public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
				if (newValue != null) {
					updateButtonBar(newValue);
				}
			}
		});

		totalCost.textProperty().setValue("" + cart.totalCost() + " $");

		filter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				showFilteredMedia(newValue);
			}
		});
	}

	private void updateButtonBar(Media media) {
		buttonRemove.setVisible(true);
		buttonPlay.setVisible(media instanceof Playable);
	}

	@FXML
	void onPlaceOrder(ActionEvent event) {
		cart.clear();
		JOptionPane.showMessageDialog(null, "An order has been created.", "Place order",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@FXML
	void onPlay(ActionEvent event) {
		Playable playable = (Playable) media.getSelectionModel().getSelectedItem();
		try {
			JOptionPane.showMessageDialog(null, playable.play(), "Media Player", JOptionPane.INFORMATION_MESSAGE);
		} catch (PlayerException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal DVD Length", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void onRemove(ActionEvent event) {
		cart.removeMedia(media.getSelectionModel().getSelectedItem());
		updateTotal();
	}

	public void updateTotal() {
		totalCost.textProperty().setValue("" + cart.totalCost() + " $");
	}

	private void showFilteredMedia(String filter) {
		if (!filter.isBlank()) {
			try {
				cart.setIdFilter(Integer.parseInt(filter));
			} catch (Exception e) {
				cart.setIdFilter(-1);
			}
			cart.setTitleFilter(filter);
			media.setItems(cart.getFilteredItemsOrdered());
		} else {
			media.setItems(cart.getItemsOrdered());
		}
	}

	@FXML
	void sortById(ActionEvent event) {
		cart.setFilterMode(Cart.FILTER_BY_ID);
	}

	@FXML
	void sortByTitle(ActionEvent event) {
		cart.setFilterMode(Cart.FILTER_BY_TITLE);
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

}
