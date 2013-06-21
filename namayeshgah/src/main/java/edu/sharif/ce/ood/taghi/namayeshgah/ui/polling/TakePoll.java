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
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;

public class TakePoll extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TakePoll frame = new TakePoll();
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
	public TakePoll() {
		super();
		setTitle("شرکت در نظرسنجی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
												
												JPanel question1 = new JPanel();
												panel.add(question1);
												question1.setLayout(new GridLayout(3, 1, 0, 0));
												
												JPanel upPanel1 = new JPanel();
												upPanel1.setAlignmentX(1.0f);
												question1.add(upPanel1);
												upPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JLabel label = new JLabel("مساحت اختصاصی غرفه ها مناسب بود؟");
												upPanel1.add(label);
												
												JPanel downPanel1 = new JPanel();
												question1.add(downPanel1);
												downPanel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JRadioButton radioButton = new JRadioButton("عالی");
												downPanel1.add(radioButton);
												
												JRadioButton radioButton_1 = new JRadioButton("خوب");
												downPanel1.add(radioButton_1);
												
												JRadioButton radioButton_2 = new JRadioButton("متوسط");
												downPanel1.add(radioButton_2);
												
												JRadioButton radioButton_3 = new JRadioButton("ضعیف");
												downPanel1.add(radioButton_3);
												
												JPanel panel_1 = new JPanel();
												panel.add(panel_1);
												panel_1.setLayout(new GridLayout(3, 1, 0, 0));
												
												JPanel panel_2 = new JPanel();
												panel_2.setAlignmentX(1.0f);
												panel_1.add(panel_2);
												panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JLabel label_1 = new JLabel("مساحت اختصاصی غرفه ها مناسب بود؟");
												panel_2.add(label_1);
												
												JPanel panel_3 = new JPanel();
												panel_1.add(panel_3);
												panel_3.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JRadioButton radioButton_4 = new JRadioButton("عالی");
												panel_3.add(radioButton_4);
												
												JRadioButton radioButton_5 = new JRadioButton("خوب");
												panel_3.add(radioButton_5);
												
												JRadioButton radioButton_6 = new JRadioButton("متوسط");
												panel_3.add(radioButton_6);
												
												JRadioButton radioButton_7 = new JRadioButton("ضعیف");
												panel_3.add(radioButton_7);
												
												JPanel panel_4 = new JPanel();
												panel.add(panel_4);
												panel_4.setLayout(new GridLayout(3, 1, 0, 0));
												
												JPanel panel_5 = new JPanel();
												panel_5.setAlignmentX(1.0f);
												panel_4.add(panel_5);
												panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JLabel label_2 = new JLabel("مساحت اختصاصی غرفه ها مناسب بود؟");
												panel_5.add(label_2);
												
												JPanel panel_6 = new JPanel();
												panel_4.add(panel_6);
												panel_6.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JRadioButton radioButton_8 = new JRadioButton("عالی");
												panel_6.add(radioButton_8);
												
												JRadioButton radioButton_9 = new JRadioButton("خوب");
												panel_6.add(radioButton_9);
												
												JRadioButton radioButton_10 = new JRadioButton("متوسط");
												panel_6.add(radioButton_10);
												
												JRadioButton radioButton_11 = new JRadioButton("ضعیف");
												panel_6.add(radioButton_11);
												
												JPanel panel_7 = new JPanel();
												panel.add(panel_7);
												panel_7.setLayout(new GridLayout(3, 1, 0, 0));
												
												JPanel panel_8 = new JPanel();
												panel_8.setAlignmentX(1.0f);
												panel_7.add(panel_8);
												panel_8.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JLabel label_3 = new JLabel("مساحت اختصاصی غرفه ها مناسب بود؟");
												panel_8.add(label_3);
												
												JPanel panel_9 = new JPanel();
												panel_7.add(panel_9);
												panel_9.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
												
												JRadioButton radioButton_12 = new JRadioButton("عالی");
												panel_9.add(radioButton_12);
												
												JRadioButton radioButton_13 = new JRadioButton("خوب");
												panel_9.add(radioButton_13);
												
												JRadioButton radioButton_14 = new JRadioButton("متوسط");
												panel_9.add(radioButton_14);
												
												JRadioButton radioButton_15 = new JRadioButton("ضعیف");
												panel_9.add(radioButton_15);
												
												JPanel panel_10 = new JPanel();
												panel.add(panel_10);
												
												JButton button = new JButton("ثبت");
												panel_10.add(button);
	}

}
