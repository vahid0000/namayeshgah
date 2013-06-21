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
		setTitle("ثبت بازرسی غرفه ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][][grow][]"));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "flowx,cell 1 1,alignx center");
		
		JLabel label = new JLabel("نمایشگاه");
		panel.add(label, "cell 1 1");
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, "flowx,cell 1 2,alignx center");
		
		JLabel label_1 = new JLabel("سالن");
		panel.add(label_1, "cell 1 2");
		
		JLabel label_2 = new JLabel("غرفه ها");
		panel.add(label_2, "cell 1 3,alignx center");
		
		JList list = new JList();
		panel.add(list, "cell 1 4,grow");
		
		JButton button = new JButton("تایید بازرسی");
		panel.add(button, "flowx,cell 1 5,alignx center");
		
		JButton button_1 = new JButton("دارای اشکال");
		panel.add(button_1, "cell 1 5");
		
		JButton button_2 = new JButton("بازرسی نشده");
		panel.add(button_2, "cell 1 5");
	}

}
