package edu.sharif.ce.ood.taghi.namayeshgah.ui.report;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

public class AddReport extends BaseUI {
	private JTextField textField;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReport frame = new AddReport();
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
	public AddReport() {
		super();
		setTitle("گزارش مردمی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px,grow 3][]",
				"[grow][][][][][][][][grow][]"));

		JList list = new JList();
		panel.add(list, "cell 1 0,grow");

		JLabel label = new JLabel("گزارشات");
		panel.add(label, "cell 2 0,aligny top");

		JLabel label_1 = new JLabel("ثبت گزارش جدید");
		panel.add(label_1, "cell 1 3,alignx center");

		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 4,alignx right");

		JLabel label_4 = new JLabel("نمایشگاه");
		panel.add(label_4, "cell 2 4");

		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "cell 1 5,alignx right");

		JLabel label_5 = new JLabel("سالن");
		panel.add(label_5, "cell 2 5");

		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2, "cell 1 6,alignx right");

		JLabel label_6 = new JLabel("غرفه");
		panel.add(label_6, "cell 2 6");

		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField, "cell 1 7,growx");
		textField.setColumns(10);

		JLabel label_2 = new JLabel("نام و نام خانوادگی");
		panel.add(label_2, "cell 2 7");

		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea, "cell 1 8,grow");

		JLabel label_3 = new JLabel("شرح گزارش");
		panel.add(label_3, "cell 2 8,aligny top");

		JButton button = new JButton("ذخیره");
		panel.add(button, "cell 1 9,alignx center");
	}

}
