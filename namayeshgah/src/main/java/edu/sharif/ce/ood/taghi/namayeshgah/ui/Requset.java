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

import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Requset extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Requset frame = new Requset();
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
	public Requset() {
//		super();
		setTitle("درخواست شرکت در نمایشگاه");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][][][][][][grow][]"));
		
		textField = new JTextField();
		panel.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel label = new JLabel("نام متقاضی");
		panel.add(label, "cell 2 0");
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 1,growx");
		
		JLabel label_6 = new JLabel("نمایشگاه");
		panel.add(label_6, "cell 2 1");
		
		textField_1 = new JTextField();
		panel.add(textField_1, "cell 1 2,growx");
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("نام شرکت");
		panel.add(label_1, "cell 2 2");
		
		textField_2 = new JTextField();
		panel.add(textField_2, "cell 1 3,growx");
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("شماره تلفن شرکت");
		panel.add(label_2, "cell 2 3");
		
		textField_3 = new JTextField();
		panel.add(textField_3, "cell 1 4,growx");
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("ایمیل");
		panel.add(label_3, "cell 2 4");
		
		textField_4 = new JTextField();
		panel.add(textField_4, "cell 1 5,growx");
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("شماره موبایل");
		panel.add(label_4, "cell 2 5");
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, "cell 1 6,grow");
		
		JLabel label_5 = new JLabel("شرح درخواست");
		panel.add(label_5, "cell 2 6,alignx left,aligny top");
		
		JButton button = new JButton("تایید");
		panel.add(button, "cell 1 7,alignx center");
	}

}
