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
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][grow][grow][grow][]"));
		
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
		panel.add(textArea, "cell 1 3,grow");
		
		JLabel label_3 = new JLabel("توضیحات");
		panel.add(label_3, "cell 2 3,aligny top");
		
		JButton button = new JButton("ذخیره");
		panel.add(button, "cell 1 4");
	}

}
