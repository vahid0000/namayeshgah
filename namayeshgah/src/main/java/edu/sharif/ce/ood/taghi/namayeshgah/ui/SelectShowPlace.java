package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;

public class SelectShowPlace extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectShowPlace frame = new SelectShowPlace();
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
	public SelectShowPlace() {
		super();
		setTitle("انتخاب نمایشگاه");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				ColumnSpec.decode("0px:grow(3)"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.GLUE_ROWSPEC,
				FormFactory.GLUE_ROWSPEC,
				FormFactory.GLUE_ROWSPEC,
				RowSpec.decode("0px:grow(10)"),
				FormFactory.GLUE_ROWSPEC,
				FormFactory.GLUE_ROWSPEC,}));
		
		JLabel label = new JLabel("لیست نمایشگاه ها");
		panel.add(label, "2, 2, center, center");
		
		JList list = new JList();
		panel.add(list, "2, 4, fill, fill");
		
		JButton button = new JButton("انتخاب");
		panel.add(button, "2, 5, center, center");
	}

}
