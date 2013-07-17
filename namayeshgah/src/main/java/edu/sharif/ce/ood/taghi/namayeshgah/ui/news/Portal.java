package edu.sharif.ce.ood.taghi.namayeshgah.ui.news;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridLayout;

public class Portal extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portal frame = new Portal();
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
	public Portal() {
		super();
		setTitle("پرتال");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 0, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][]", "[][grow][]"));
		
		JLabel label_1 = new JLabel("بازگشایی ....");
		panel_1.add(label_1, "cell 0 0,alignx right");
		
		JLabel lblNewLabel = new JLabel("عنوان");
		panel_1.add(lblNewLabel, "cell 1 0");
		
		JLabel label_2 = new JLabel("طی گزارش .....");
		panel_1.add(label_2, "cell 0 1,alignx right");
		
		JLabel label = new JLabel("متن");
		panel_1.add(label, "cell 1 1,aligny top");
	}

}
