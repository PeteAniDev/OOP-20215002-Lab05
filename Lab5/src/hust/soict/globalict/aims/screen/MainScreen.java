package hust.soict.globalict.aims.screen;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javafx.application.Platform;

public class MainScreen extends JFrame {

	private static final long serialVersionUID = -3219216303111237818L;

	public StoreScreen store;
	public CartScreen cart;
	public AddMediaScreen addMedia;
	public JPanel cardPanel;

	public MainScreen(StoreScreen store, CartScreen cart, AddMediaScreen addMedia) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		cardPanel = new JPanel(new CardLayout());
		cardPanel.add(store.content);
		cardPanel.add(cart.content);
		cardPanel.add(addMedia.content);
		add(cardPanel);

		this.store = store;
		this.cart = cart;
		this.addMedia = addMedia;
		store.main = this;
		cart.main = this;
		addMedia.main = this;
		openStoreScreen();
	}

	public void openStoreScreen() {
		CardLayout layout = (CardLayout) cardPanel.getLayout();
		layout.first(cardPanel);
		setTitle("Store");
		setSize(1024, 768);
	}

	public void openCartScreen() {
		CardLayout layout = (CardLayout) cardPanel.getLayout();
		layout.first(cardPanel);
		layout.next(cardPanel);
		setTitle("Cart");
		setSize(1024, 768);
		Platform.runLater(() -> {
			cart.controller.updateTotal();
		});
	}

	public void openAddMediaScreen() {
		CardLayout layout = (CardLayout) cardPanel.getLayout();
		layout.last(cardPanel);
		setTitle("Add Media");
		setSize(1024, 768);
	}

	public void addMediaTab(int i) {
		addMedia.controller.setTab(i);
	}

}
