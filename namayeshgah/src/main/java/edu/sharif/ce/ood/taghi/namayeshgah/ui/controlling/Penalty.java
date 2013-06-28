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
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class Penalty extends BaseUI {
	private JTextField textField;

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Penalty frame = new Penalty();
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
	public Penalty() {
		super();
		setTitle("فراخوان و اطلاع رسانی");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][grow][grow][][]"));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "flowx,cell 1 0,alignx center");
		
		JLabel label_2 = new JLabel("غرفه ها");
		panel.add(label_2, "cell 1 1,alignx center");
		
		JList list = new JList();
		panel.add(list, "cell 1 2,grow");
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea, "cell 1 3,grow");
		
		JLabel label_3 = new JLabel("گزارش");
		panel.add(label_3, "cell 2 3,aligny top");
		
		JButton button = new JButton("ثبت جریمه");
		panel.add(button, "cell 1 5,alignx center");
		
		textField = new JTextField();
		panel.add(textField, "flowx,cell 1 4,growx");
		textField.setColumns(10);
		
		JLabel label = new JLabel("جریمه");
		panel.add(label, "cell 1 4");
		
		JLabel label_1 = new JLabel("نمایشگاه");
		panel.add(label_1, "cell 1 0");
	}

}
