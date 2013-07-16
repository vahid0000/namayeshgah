package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public class Properties extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties frame = new Properties();
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
	public Properties() {
		super();
		setTitle("فرآیند ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				ColumnSpec.decode("0px:grow(6)"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("default:grow(3)"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("0px:grow(5)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.GLUE_ROWSPEC,}));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "2, 2, fill, fill");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.GLUE_ROWSPEC,
				RowSpec.decode("15dlu"),}));
		
		JList list = new JList();
		panel_4.add(list, "2, 1, fill, fill");
		
		JLabel label_1 = new JLabel("تاریخچه");
		panel_4.add(label_1, "3, 1, default, top");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 3, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "1, 1, fill, bottom");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox);
		
		JLabel label = new JLabel("نمایشگاه ها");
		panel_3.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, "3, 1, fill, bottom");
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button_1 = new JButton("پایین");
		panel_2.add(button_1);
		
		JButton button = new JButton("بالا");
		panel_2.add(button);
		
		SelectList selectList = new SelectList(null);
		panel.add(selectList, "2, 4, fill, fill");
		
		JButton button_2 = new JButton("تایید");
		panel.add(button_2, "2, 5, center, center");
	}

}
