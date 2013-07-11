package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.Component;
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

public class Financial extends BaseUI {
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
					Financial frame = new Financial();
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
	public Financial() {
		super();
		setTitle("انبار");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[467px]", "[grow][grow 30]"));

		JPanel upPanel = new JPanel();
		upPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(upPanel, "cell 0 0,grow");
		upPanel.setLayout(new MigLayout("", "[][grow][]", "[][][][grow][]"));

		JLabel label = new JLabel("فیش های موجود");
		upPanel.add(label, "cell 1 0,alignx center");

		JComboBox comboBox = new JComboBox();
		upPanel.add(comboBox, "flowx,cell 1 1,alignx center");

		JLabel label_1 = new JLabel("نمایشگاه");
		upPanel.add(label_1, "cell 1 1");

		JButton button = new JButton("جست و جو");
		upPanel.add(button, "flowx,cell 1 2,alignx center");

		JList list = new JList();
		upPanel.add(list, "cell 1 3,grow");

		textField = new JTextField();
		upPanel.add(textField, "cell 1 2");
		textField.setColumns(10);

		JLabel label_2 = new JLabel("شماره پیگیری");
		upPanel.add(label_2, "cell 1 2");

		JButton button_2 = new JButton("پرداخت فیش");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		upPanel.add(button_2, "cell 1 4");

		JPanel downPanel = new JPanel();
		downPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(downPanel, "cell 0 1,grow");
		downPanel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][][grow][]"));

		JLabel label_5 = new JLabel("ثبت فیش جدید");
		downPanel.add(label_5, "cell 1 0,alignx center");

		textField_1 = new JTextField();
		downPanel.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);

		JLabel label_3 = new JLabel("شماره");
		downPanel.add(label_3, "cell 2 1");

		JTextArea textArea = new JTextArea();
		downPanel.add(textArea, "cell 1 2,grow");

		JLabel label_4 = new JLabel("توضیحات");
		downPanel.add(label_4, "cell 2 2");

		JButton button_1 = new JButton("ثبت");
		downPanel.add(button_1, "cell 1 3");
	}

}
