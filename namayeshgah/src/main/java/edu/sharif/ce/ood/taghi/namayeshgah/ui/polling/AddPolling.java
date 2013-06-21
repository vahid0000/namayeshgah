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
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelectList;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPolling extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPolling frame = new AddPolling();
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
	public AddPolling() {
		super();
		setTitle("نظرسنجی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel upPanel = new JPanel();
		panel.add(upPanel);
		upPanel.setLayout(new MigLayout("", "[][grow][]", "[][][][][grow][]"));

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		upPanel.add(separator, "cell 1 1,growx");

		JComboBox comboBox = new JComboBox();
		upPanel.add(comboBox, "flowx,cell 1 2,alignx center");

		JLabel label = new JLabel("نمایشگاه");
		upPanel.add(label, "cell 1 2");

		JLabel label_1 = new JLabel("کاربران");
		upPanel.add(label_1, "cell 1 3,alignx center,aligny bottom");

		SelectList selectList = new SelectList();
		upPanel.add(selectList, "cell 1 4,grow");

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.BLACK);
		upPanel.add(separator_1, "cell 1 5,growx");

		JPanel downPanel = new JPanel();
		panel.add(downPanel);
		downPanel.setLayout(new MigLayout("", "[][grow][grow][]",
				"[][grow][][]"));

		JLabel label_2 = new JLabel("سوالات");
		downPanel.add(label_2, "cell 2 0,alignx center,aligny bottom");

		JPanel panel_1 = new JPanel();
		downPanel.add(panel_1, "cell 1 1,alignx right,aligny center");
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JButton addQuestion = new JButton("سوال جدید");
		addQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = (String) JOptionPane.showInputDialog(null,
						null, "صورت سوال جدید");

				// If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					//TODO: surate soal
					//setLabel("Green eggs and... " + s + "!");
					//return;
				}
			}
		});
		addQuestion.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(addQuestion);

		JButton answerButton1 = new JButton("جواب1");
		answerButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						null, "جواب1");

				// If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					//TODO: surate soal
					//setLabel("Green eggs and... " + s + "!");
					//return;
				}
			}
		});
		answerButton1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(answerButton1);
		
		JButton answerButton2 = new JButton("جواب2");
		answerButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						null, "جواب 2");

				// If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					//TODO: surate soal
					//setLabel("Green eggs and... " + s + "!");
					//return;
				}
			}
		});
		answerButton2.setAlignmentX(1.0f);
		panel_1.add(answerButton2);
		
		JButton answerButton3 = new JButton("جواب3");
		answerButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						null, "جواب3");

				// If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					//TODO: surate soal
					//setLabel("Green eggs and... " + s + "!");
					//return;
				}
			}
		});
		answerButton3.setAlignmentX(1.0f);
		panel_1.add(answerButton3);
		
		JButton answerButton = new JButton("جواب4");
		answerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String) JOptionPane.showInputDialog(null,
						null, "جواب4");

				// If a string was returned, say so.
				if ((s != null) && (s.length() > 0)) {
					//TODO: surate soal
					//setLabel("Green eggs and... " + s + "!");
					//return;
				}
			}
		});
		answerButton.setAlignmentX(1.0f);
		panel_1.add(answerButton);

		JButton removeButton = new JButton("حذف");
		removeButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_1.add(removeButton);

		JList list = new JList();
		downPanel.add(list, "cell 2 1,grow");

		JButton acceptButton = new JButton("ذخیره");
		downPanel.add(acceptButton, "cell 1 3,alignx center");
	}

}
