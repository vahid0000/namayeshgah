package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Definition extends BaseUI {
	private JTextField textField;
	private JTextField textField_1;

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Definition frame = new Definition();
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
	public Definition() {
		super();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JLabel lName = new JLabel("نام");
		panel.add(lName);
		
		JLabel lBrief = new JLabel("خلاصه توضیح");
		sl_panel.putConstraint(SpringLayout.WEST, lBrief, 0, SpringLayout.WEST, lName);
		panel.add(lBrief);
		
		JLabel lDescription = new JLabel("شرح");
		sl_panel.putConstraint(SpringLayout.NORTH, lDescription, 46, SpringLayout.SOUTH, lBrief);
		sl_panel.putConstraint(SpringLayout.WEST, lDescription, 0, SpringLayout.WEST, lName);
		panel.add(lDescription);
		
		JLabel lStaff = new JLabel("هیئت عالی");
		sl_panel.putConstraint(SpringLayout.WEST, lStaff, 0, SpringLayout.WEST, lName);
		panel.add(lStaff);
		
		SelectList selectList = new SelectList();
		sl_panel.putConstraint(SpringLayout.WEST, selectList, 26, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, selectList, -25, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, selectList, -6, SpringLayout.WEST, lStaff);
		panel.add(selectList);
		
		textField = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, lName, 3, SpringLayout.NORTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, lName, 4, SpringLayout.EAST, textField);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -78, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textField, 26, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 10, SpringLayout.NORTH, panel);
		panel.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrDfdsff = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, txtrDfdsff, 7, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, txtrDfdsff, 26, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, txtrDfdsff, -6, SpringLayout.WEST, lBrief);
		sl_panel.putConstraint(SpringLayout.NORTH, lBrief, -2, SpringLayout.NORTH, txtrDfdsff);
		txtrDfdsff.setText("خلاصه");
		panel.add(txtrDfdsff);
		
		JTextArea textArea = new JTextArea();
		sl_panel.putConstraint(SpringLayout.SOUTH, txtrDfdsff, -11, SpringLayout.NORTH, textArea);
		sl_panel.putConstraint(SpringLayout.SOUTH, textArea, -184, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textArea, -6, SpringLayout.WEST, lDescription);
		sl_panel.putConstraint(SpringLayout.NORTH, textArea, 97, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, textArea, 26, SpringLayout.WEST, panel);
		textArea.setText("شرح");
		panel.add(textArea);
		
		JLabel label = new JLabel("سفارش دهنده");
		sl_panel.putConstraint(SpringLayout.NORTH, lStaff, 11, SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -163, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lName);
		panel.add(label);
		
		textField_1 = new JTextField();
		sl_panel.putConstraint(SpringLayout.NORTH, selectList, 6, SpringLayout.SOUTH, textField_1);
		sl_panel.putConstraint(SpringLayout.WEST, textField_1, 26, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, textField_1, -6, SpringLayout.WEST, label);
		sl_panel.putConstraint(SpringLayout.NORTH, textField_1, 6, SpringLayout.SOUTH, textArea);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("ذخیره");
		sl_panel.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST, selectList);
		sl_panel.putConstraint(SpringLayout.SOUTH, button, 0, SpringLayout.SOUTH, panel);
		panel.add(button);

	}
}
