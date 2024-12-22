package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame {

	private static final long serialVersionUID = 8359517809609633912L;

	public Cart cart;
	public Container content;
	public MainScreen main;

	private JPanel center;

	public StoreScreen(Cart cart) {
		content = getContentPane();
		content.setLayout(new BorderLayout());
		content.add(createNorth(), BorderLayout.NORTH);
		content.add(createCenter(), BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Store");
		setSize(1024, 768);

		this.cart = cart;
	}

	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createHeader());
		north.add(createMenuBar());
		return north;
	}

	private JMenuBar createHeader() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener((ActionEvent e) -> {
			main.openAddMediaScreen();
			main.addMediaTab(0);
		});
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener((ActionEvent e) -> {
			main.openAddMediaScreen();
			main.addMediaTab(1);
		});
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener((ActionEvent e) -> {
			main.openAddMediaScreen();
			main.addMediaTab(2);
		});
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);

		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View Store"));
		JMenuItem cart = new JMenuItem("View Cart");
		cart.addActionListener((ActionEvent e) -> {
			main.openCartScreen();
		});
		menu.add(cart);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}

	private JPanel createMenuBar() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		JButton cart = new JButton("View Cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		cart.addActionListener((ActionEvent e) -> {
			main.openCartScreen();
		});

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));

		return header;
	}

	private JPanel createCenter() {
		center = new JPanel();
		List<Media> mediaInStore = Store.getItemsInStore();
		center.setLayout(new GridLayout((int) Math.sqrt(mediaInStore.size()) + 1,
				(int) Math.sqrt(mediaInStore.size()) + 1, 5, 5));

		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i), this);
			center.add(cell);
		}
		return center;
	}

	public void updateCenter() {
		content.remove(center);
		content.add(createCenter(), BorderLayout.CENTER);
	}

}
