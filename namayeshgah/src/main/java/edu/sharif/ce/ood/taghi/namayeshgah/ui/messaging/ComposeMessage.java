package edu.sharif.ce.ood.taghi.namayeshgah.ui.messaging;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
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
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelectList;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ComposeMessage extends BaseUI {
	private JTextField textField;

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComposeMessage frame = new ComposeMessage();
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
	public ComposeMessage() {
		super();
		setTitle("پیغام ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][grow 30][][grow][]"));
		
		JLabel label_1 = new JLabel("گیرندگان");
		panel.add(label_1, "cell 1 0,alignx center");
		
		SelectList selectList = new SelectList();
		panel.add(selectList, "cell 1 1,grow");
		
		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textField, "flowx,cell 1 2,growx");
		textField.setColumns(10);
		
		JLabel label = new JLabel("عنوان");
		panel.add(label, "cell 1 2");
		
		JTextArea textArea = new JTextArea();
		textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(textArea, "flowx,cell 1 3,grow");
		
		JLabel label_2 = new JLabel("متن");
		panel.add(label_2, "cell 1 3,aligny top");
		
		JButton button = new JButton("ارسال");
		panel.add(button, "cell 1 4");
	}

}
