package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hust.soict.globalict.aims.media.Media;

public class MediaStore extends JPanel {

	private static final long serialVersionUID = -1878474809049301050L;

	private Media media;

	public MediaStore(Media media) {
		this.media = media;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);

		JLabel cost = new JLabel("" + media.getCost() + " $");
		cost.setAlignmentX(CENTER_ALIGNMENT);

		JLabel container = new JLabel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));

		container.add(new JButton("Play"));

		add(Box.createVerticalGlue());
		add(title);
		add(cost);
		add(Box.createVerticalGlue());
		add(container);

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
