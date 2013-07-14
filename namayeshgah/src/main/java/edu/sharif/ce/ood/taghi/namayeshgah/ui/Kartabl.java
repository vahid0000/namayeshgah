package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Kartabl extends BaseUI {
	private JTextField textField;
	private JTextField textField_1;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kartabl frame = new Kartabl();
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
	public Kartabl() {
		super();
		setTitle("کارتابل");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(10, 0, 0, 0));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][grow][]", "[][]"));

		JLabel label_2 = new JLabel("شرح");
		panel_2.add(label_2, "cell 3 0");

		JButton button_3 = new JButton("تایید");
		panel_2.add(button_3, "cell 0 1");

		JButton button_2 = new JButton("رد");
		panel_2.add(button_2, "cell 1 1");

		textField_1 = new JTextField();
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		textField_1.setColumns(10);
		panel_2.add(textField_1, "cell 2 1,growx");

		JLabel label_3 = new JLabel("پاسخ");
		panel_2.add(label_3, "cell 3 1");

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][grow][]", "[][]"));

		JLabel label_1 = new JLabel("شرح");
		panel_1.add(label_1, "cell 3 0");

		JButton button = new JButton("تایید");
		panel_1.add(button, "cell 0 1");

		JButton button_1 = new JButton("رد");
		panel_1.add(button_1, "cell 1 1");

		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel_1.add(textField, "flowx,cell 2 1,growx");
		textField.setColumns(10);

		JLabel label = new JLabel("پاسخ");
		panel_1.add(label, "cell 3 1");
	}

}
