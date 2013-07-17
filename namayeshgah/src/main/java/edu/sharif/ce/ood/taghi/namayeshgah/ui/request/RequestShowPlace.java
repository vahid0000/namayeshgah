package edu.sharif.ce.ood.taghi.namayeshgah.ui.request;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

import net.miginfocom.swing.MigLayout;

public class RequestShowPlace extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestShowPlace frame = new RequestShowPlace();
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
	public RequestShowPlace() {
		super();
		setTitle("درخواست سالن یا غرفه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][grow][grow][grow][]"));

		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,alignx right");

		JLabel label = new JLabel("نمایشگاه");
		panel.add(label, "cell 2 0");

		JList list = new JList();
		panel.add(list, "cell 1 1,grow");

		JLabel label_1 = new JLabel("سالن");
		panel.add(label_1, "cell 2 1,aligny top");

		JList list_1 = new JList();
		panel.add(list_1, "cell 1 2,grow");

		JLabel label_2 = new JLabel("غرفه");
		panel.add(label_2, "cell 2 2,aligny top");

		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea, "cell 1 3,grow");

		JLabel label_3 = new JLabel("توضیحات");
		panel.add(label_3, "cell 2 3,aligny top");

		JButton button = new JButton("ذخیره");
		panel.add(button, "cell 1 4");
	}

}
