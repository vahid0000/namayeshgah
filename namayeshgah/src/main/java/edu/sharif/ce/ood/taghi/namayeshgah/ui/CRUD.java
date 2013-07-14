package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class CRUD extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
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
	public CRUD() {
		super();
		setTitle("کراد");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][grow][]"));
		
		JLabel label = new JLabel("لیست اطلاعات");
		panel.add(label, "cell 1 0,alignx center");
		
		JList list = new JList();
		panel.add(list, "cell 1 1,grow");
		
		JButton button = new JButton("حذف");
		panel.add(button, "flowx,cell 1 2,alignx center");
		
		JButton button_1 = new JButton("اضافه");
		panel.add(button_1, "cell 1 2");
		
		JButton button_2 = new JButton("تغییر");
		panel.add(button_2, "cell 1 2");
	}

}
