package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.cart.Cart;
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

	private Cart cart;

	public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
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
	}

	private void updateButtonBar(Media media) {
		buttonRemove.setVisible(true);
		buttonPlay.setVisible(media instanceof Playable);
	}

	@FXML
	void onPlaceOrder(ActionEvent event) {

	}

	@FXML
	void onPlay(ActionEvent event) {
		Playable playable = (Playable) media.getSelectionModel().getSelectedItem();
		JOptionPane.showMessageDialog(null, playable.play(), "Media Player", JOptionPane.INFORMATION_MESSAGE);
	}

	@FXML
	void onRemove(ActionEvent event) {
		cart.removeMedia(media.getSelectionModel().getSelectedItem());
	}

}
