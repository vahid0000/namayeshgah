package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Inputs extends BaseUI {
	private JTextField nameText;
	private JTextField valueText;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inputs frame = new Inputs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inputs() {
		super();
		setTitle("ورودی دهی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[grow][][][][][][]"));

		JList list = new JList();
		panel.add(list, "cell 1 0,grow");

		JLabel label = new JLabel("لیست ورودی ها");
		panel.add(label, "cell 2 0,aligny top");

		JLabel label_1 = new JLabel("ثبت ورودی جدید");
		panel.add(label_1, "cell 2 3");

		nameText = new JTextField();
		nameText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(nameText, "cell 1 4,growx");
		nameText.setColumns(10);

		JLabel label_2 = new JLabel("نام");
		panel.add(label_2, "cell 2 4");

		valueText = new JTextField();
		valueText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(valueText, "cell 1 5,growx");
		valueText.setColumns(10);

		JLabel label_3 = new JLabel("مقدار");
		panel.add(label_3, "cell 2 5");

		JButton button = new JButton("ذخیره");
		panel.add(button, "cell 1 6");
	}

}
