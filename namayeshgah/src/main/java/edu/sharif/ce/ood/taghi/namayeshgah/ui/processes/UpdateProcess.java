package edu.sharif.ce.ood.taghi.namayeshgah.ui.processes;

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
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateProcess extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProcess frame = new UpdateProcess();
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
	public UpdateProcess() {
		super();
		setTitle("به روزرسانی فرآیند");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][grow][]"));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,alignx right");
		
		JLabel label = new JLabel("نمایشگاه");
		panel.add(label, "cell 2 0");
		
		JList list = new JList();
		panel.add(list, "cell 1 1,grow");
		
		JLabel label_1 = new JLabel("لیست فرآیندها");
		panel.add(label_1, "cell 2 1,aligny top");
		
		JButton button = new JButton("به روز رسانی");
		panel.add(button, "flowx,cell 1 2,alignx center");
		
		JButton button_1 = new JButton("اجرا");
		panel.add(button_1, "cell 1 2");
	}

}
