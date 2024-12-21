package hust.soict.globalict.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

	private static final long serialVersionUID = 2365399685206168477L;

	private Cart cart;

	public CartScreen(Cart cart) {
		super();
		this.cart = cart;

		JFXPanel fxPanel = new JFXPanel();
		add(fxPanel);
		setTitle("Cart");
		setSize(1024, 768);
		setVisible(true);

		Platform.runLater(() -> {
			try {
				FXMLLoader loader = new FXMLLoader(
						getClass().getResource("/hust/soict/globalict/aims/screen/Cart.fxml"));
				CartScreenController controller = new CartScreenController(cart);
				loader.setController(controller);
				Parent root = loader.load();
				fxPanel.setScene(new Scene(root));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
