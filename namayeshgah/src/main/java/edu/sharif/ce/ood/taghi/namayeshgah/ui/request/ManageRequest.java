package edu.sharif.ce.ood.taghi.namayeshgah.ui.request;

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

import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

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

public class ManageRequest extends BaseUI {
	private JTextField textField;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageRequest frame = new ManageRequest();
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
	public ManageRequest() {
		super();
		setTitle("مدیریت درخواست ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][grow][][][grow][grow][]"));

		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,alignx right");

		JLabel label_4 = new JLabel("نمایشگاه");
		panel.add(label_4, "cell 2 0");

		JList list = new JList();
		panel.add(list, "cell 1 1,grow");

		JLabel label = new JLabel("درخواست ها");
		panel.add(label, "cell 2 1,aligny top");

		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField, "cell 1 3,growx");
		textField.setColumns(10);

		JLabel label_1 = new JLabel("عنوان");
		panel.add(label_1, "cell 2 3");

		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea, "cell 1 4,grow");

		JLabel label_2 = new JLabel("شرح");
		panel.add(label_2, "cell 2 4,aligny top");

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea_1, "cell 1 5,grow");

		JLabel label_3 = new JLabel("پاسخ");
		panel.add(label_3, "cell 2 5,aligny top");

		JButton button = new JButton("پاسخ");
		panel.add(button, "flowx,cell 1 6");
	}

}
