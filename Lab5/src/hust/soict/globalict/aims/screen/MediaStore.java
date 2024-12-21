package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;

public class MediaStore extends JPanel {

	private static final long serialVersionUID = -1878474809049301050L;

	private Media media;

	public MediaStore(Media media, StoreScreen store) {
		this.media = media;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		JButton addCart = new JButton("Add to cart");
		addCart.addActionListener((ActionEvent e) -> {
			store.cart.addMedia(this.media);
			JOptionPane.showMessageDialog(null, "Media has been added to cart", "Media Added",
					JOptionPane.INFORMATION_MESSAGE);
		});
		container.add(addCart);
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			play.addActionListener((ActionEvent e) -> {
				Playable playable = (Playable) this.media;
				JOptionPane.showMessageDialog(null, playable.play(), "Media Player", JOptionPane.INFORMATION_MESSAGE);
			});
			container.add(play);
		}

		add(Box.createVerticalGlue());
		add(title);
		add(cost);
		add(Box.createVerticalGlue());
		add(container);

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
