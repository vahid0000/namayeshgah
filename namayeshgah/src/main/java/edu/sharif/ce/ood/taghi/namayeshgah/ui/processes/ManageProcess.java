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
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelectList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class ManageProcess extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageProcess frame = new ManageProcess();
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
	public ManageProcess() {
		super();
		setTitle("ویژگی ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				ColumnSpec.decode("0px:grow(6)"),
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("0px:grow(3)"),
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("0px:grow(5)"),
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "2, 2, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC,},
			new RowSpec[] {
				FormFactory.GLUE_ROWSPEC,
				RowSpec.decode("20dlu"),}));
		
		JList list = new JList();
		panel_2.add(list, "2, 1, fill, fill");
		
		JLabel label_1 = new JLabel("تاریخچه");
		panel_2.add(label_1, "3, 1, default, top");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 3, left, fill");
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox);
		
		JLabel label = new JLabel("نمایشگاه");
		panel_1.add(label);
		
		SelectList selectList = new SelectList(null);
		panel.add(selectList, "2, 4, fill, fill");
		
		JButton button = new JButton("تایید");
		panel.add(button, "2, 5, center, default");
	}

}
