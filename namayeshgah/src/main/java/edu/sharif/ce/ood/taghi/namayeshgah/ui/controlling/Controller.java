package edu.sharif.ce.ood.taghi.namayeshgah.ui.controlling;

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

public class Controller extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Controller frame = new Controller();
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
	public Controller() {
		super();
		setTitle("فراخوان و اطلاع رسانی");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][50px:n:100px][grow][]"));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 1 1,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow]"));
		
		JComboBox comboBox = new JComboBox();
		panel_1.add(comboBox, "cell 0 0,growx");
		
		JLabel label_1 = new JLabel("نمایشگاه");
		panel_1.add(label_1, "cell 1 0");
		
		JLabel label = new JLabel("غرفه های دارای مشکل");
		panel_1.add(label, "cell 2 0,alignx right");
		
		SelectList selectList = new SelectList();
		panel.add(selectList, "cell 1 2,grow");
		
		JButton acceptButton = new JButton("تایید");
		panel.add(acceptButton, "cell 1 3,alignx center");
	}

}
