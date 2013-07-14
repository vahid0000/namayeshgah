package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class RequestSaloon extends BaseUI {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RequestSaloon frame = new RequestSaloon();
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
	public RequestSaloon() {
		super();
		setTitle("درخواست شرکت در نمایشگاه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][][][][][][grow][][]"));

		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,alignx right");

		JLabel label_7 = new JLabel("نمایشگاه");
		panel.add(label_7, "cell 2 0");

		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);

		JLabel label = new JLabel("نام متقاضی");
		panel.add(label, "cell 2 1");

		textField_1 = new JTextField();
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("نام شرکت");
		panel.add(label_1, "cell 2 2");

		textField_2 = new JTextField();
		textField_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);

		JLabel label_2 = new JLabel("شماره تلفن");
		panel.add(label_2, "cell 2 3");

		textField_3 = new JTextField();
		textField_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);

		JLabel label_3 = new JLabel("شماره موبایل");
		panel.add(label_3, "cell 2 4");

		textField_4 = new JTextField();
		textField_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);

		JLabel label_4 = new JLabel("ایمیل");
		panel.add(label_4, "cell 2 5");

		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea, "cell 1 6,grow");

		JLabel label_5 = new JLabel("شرح");
		panel.add(label_5, "cell 2 6");

		JButton btnBrowse = new JButton("browse");
		panel.add(btnBrowse, "flowx,cell 1 7");

		textField_5 = new JTextField();
		textField_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_5, "cell 1 7,growx");
		textField_5.setColumns(10);

		JLabel label_6 = new JLabel("فایل");
		panel.add(label_6, "cell 2 7");

		JButton button = new JButton("ذخیره");
		panel.add(button, "cell 1 8");
	}

}
