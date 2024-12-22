package hust.soict.globalict.aims.screen;

import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddMediaScreen extends JFrame {

	private static final long serialVersionUID = -2628106200218605850L;

	public MainScreen main;
	public AddMediaController controller;

	public JFXPanel fxPanel;
	public FXMLLoader loader;
	public Parent root;
	public Scene scene;
	public Container content;

	public AddMediaScreen() {
		super();

		content = getContentPane();
		fxPanel = new JFXPanel();
		content.add(fxPanel);
		setTitle("Add Media");
		setSize(1024, 768);
		run();
	}

	public void run() {
		Platform.runLater(() -> {
			try {
				loader = new FXMLLoader(getClass().getResource("/hust/soict/globalict/aims/screen/AddMedia.fxml"));
				controller = new AddMediaController(this);
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
