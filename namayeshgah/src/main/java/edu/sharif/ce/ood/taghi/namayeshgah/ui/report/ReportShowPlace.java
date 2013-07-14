package edu.sharif.ce.ood.taghi.namayeshgah.ui.report;

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

public class ReportShowPlace extends BaseUI {
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
					ReportShowPlace frame = new ReportShowPlace();
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
	public ReportShowPlace() {
		super();
		setTitle("گزارش");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][][][][][][grow]"));
		
		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField, "cell 1 0,alignx right");
		textField.setColumns(10);
		
		JLabel label = new JLabel("از");
		panel.add(label, "cell 2 0");
		
		textField_1 = new JTextField();
		textField_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField_1, "cell 1 1,alignx right");
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("تا");
		panel.add(label_1, "cell 2 1");
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 2,alignx right");
		
		JLabel label_3 = new JLabel("نمایشگاه");
		panel.add(label_3, "cell 2 2");
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "cell 1 3,alignx right");
		
		JLabel label_4 = new JLabel("سالن");
		panel.add(label_4, "cell 2 3");
		
		JComboBox comboBox_2 = new JComboBox();
		panel.add(comboBox_2, "cell 1 4,alignx right");
		
		JLabel label_5 = new JLabel("غرفه");
		panel.add(label_5, "cell 2 4");
		
		JLabel label_2 = new JLabel("نتیجه");
		panel.add(label_2, "cell 1 5,alignx center");
		
		JList list = new JList();
		panel.add(list, "cell 1 6,grow");
	}

}
