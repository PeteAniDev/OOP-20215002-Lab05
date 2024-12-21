package hust.soict.globalict.swing;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {

	private static final long serialVersionUID = 4489122552323916178L;

	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;

	public SwingAccumulator() {
		setLayout(new GridLayout(2, 2));

		add(new Label("Enter an Integer: "));
		tfInput = new JTextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener());

		add(new Label("The Accumulated Sum is: "));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		add(tfOutput);

		setTitle("Swing Accumulator");
		setSize(350, 120);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingAccumulator();
	}

	private class TFInputListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int numberIn = Integer.parseInt(tfInput.getText());
				sum += numberIn;
				tfInput.setText("");
				tfOutput.setText("" + sum);
			} catch (Exception x) {
				// Ignore
			}
		}

	}

}
