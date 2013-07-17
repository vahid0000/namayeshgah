package edu.sharif.ce.ood.taghi.namayeshgah.ui.polling;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PollingList extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PollingList frame = new PollingList();
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
	public PollingList() {
		super();
		setTitle("نظرسنجی ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][grow][]"));

		JLabel label = new JLabel("نظرسنجی ها");
		panel.add(label, "cell 1 1,alignx center");

		JList list = new JList();
		panel.add(list, "cell 1 2,grow");

		JButton newPolling = new JButton("نظرسنجی جدید");
		newPolling.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new AddPolling();
				frame.setVisible(true);
				PollingList.this.dispose();
			}
		});

		JButton button = new JButton("برگزاری");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new TakePoll();
				frame.setVisible(true);
				PollingList.this.dispose();
			}
		});
		panel.add(button, "flowx,cell 1 3,alignx center");
		panel.add(newPolling, "cell 1 3,alignx center");

		JButton resultButton = new JButton("دیدن نتیجه");
		panel.add(resultButton, "cell 1 3");

		JButton removeButton = new JButton("حذف");
		panel.add(removeButton, "cell 1 3");
	}

}
