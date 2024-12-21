package hust.soict.globalict.aims.screen;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
		media.setItems((ObservableList<Media>) cart.getItemsOrdered());
	}

	@FXML
	void onPlaceOrder(ActionEvent event) {

	}

}
