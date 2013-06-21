package edu.sharif.ce.ood.taghi.namayeshgah.ui.messaging;

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

public class MessageList extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageList frame = new MessageList();
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
	public MessageList() {
		super();
		setTitle("پیغام ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][grow][]"));
		
		JButton button = new JButton("پیفام جدید");
		panel.add(button, "flowx,cell 1 0,alignx center");
		
		JButton button_1 = new JButton("پیفام های دریافتی");
		panel.add(button_1, "cell 1 0");
		
		JButton button_2 = new JButton("پیفام های ارسالی");
		panel.add(button_2, "cell 1 0");
		
		JLabel label = new JLabel("لیست پیغام ها");
		panel.add(label, "cell 1 1,alignx center");
		
		JList list = new JList();
		panel.add(list, "cell 1 2,grow");
		
		JButton button_3 = new JButton("پاسخ");
		panel.add(button_3, "flowx,cell 1 3,alignx center");
		
		JButton button_4 = new JButton("حذف");
		panel.add(button_4, "cell 1 3,alignx center");
	}

}
