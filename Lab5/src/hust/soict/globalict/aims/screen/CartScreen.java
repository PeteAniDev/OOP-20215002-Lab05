package hust.soict.globalict.aims.screen;

import java.awt.Container;
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

	public Cart cart;
	public MainScreen main;
	public CartScreenController controller;

	public JFXPanel fxPanel;
	public FXMLLoader loader;
	public Parent root;
	public Scene scene;
	public Container content;

	public CartScreen(Cart cart) {
		super();
		this.cart = cart;

		content = getContentPane();
		fxPanel = new JFXPanel();
		content.add(fxPanel);
		setTitle("Cart");
		setSize(1024, 768);
		run();
	}

	public void run() {
		Platform.runLater(() -> {
			try {
				loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/Cart.fxml"));
				controller = new CartScreenController(cart, this);
				loader.setController(controller);
				root = loader.load();
				scene = new Scene(root);
				fxPanel.setScene(scene);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}

}
