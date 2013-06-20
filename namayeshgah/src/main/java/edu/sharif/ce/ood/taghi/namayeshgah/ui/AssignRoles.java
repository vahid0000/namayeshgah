package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class AssignRoles extends BaseUI {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignRoles frame = new AssignRoles();
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
	public AssignRoles() {
		super();
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 2, 0));
		
		JPanel panelUp = new JPanel();
		panel.add(panelUp);
		panelUp.setLayout(new MigLayout("", "[grow 50][grow][grow 50][grow][grow 50]", "[grow][][]"));
		
		JList list_1 = new JList();
		panelUp.add(list_1, "cell 1 0,grow");
		
		JLabel label_1 = new JLabel("کاربران");
		panelUp.add(label_1, "cell 2 0,alignx left,aligny top");
		
		JList list = new JList();
		panelUp.add(list, "cell 3 0,grow");
		
		JLabel label = new JLabel("نقش ها");
		panelUp.add(label, "cell 4 0,alignx left,aligny top");
		
		JButton addButton = new JButton("اضافه");
		panelUp.add(addButton, "flowx,cell 2 1,alignx center,aligny bottom");
		
		JButton deleteButton = new JButton("حذف");
		panelUp.add(deleteButton, "cell 2 2,alignx center,aligny top");
		
		JPanel panelDown = new JPanel();
		panel.add(panelDown);
		panelDown.setLayout(new MigLayout("", "[][grow][]", "[][grow][20px:n:20px][20px:n:50px]"));
		
		JLabel label_2 = new JLabel("کاربر-نقش");
		panelDown.add(label_2, "cell 1 0,alignx center");
		
		JList list_2 = new JList();
		panelDown.add(list_2, "cell 1 1,grow");
		
		JButton acceptButton = new JButton("تایید");
		panelDown.add(acceptButton, "flowx,cell 1 3,alignx center");
	}

}
