package edu.sharif.ce.ood.taghi.namayeshgah.ui;

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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

public class Election extends BaseUI {

//	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Election frame = new Election();
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
	public Election() {
		super();
		setTitle("ویژگی ها");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow 50][grow][grow 50]", "[][][][][][][]"));
		
		JButton startElectionButton = new JButton("انجماد و رای گیری");
		panel.add(startElectionButton, "cell 1 2,alignx center");
		
		JButton acceptButton = new JButton("تایید نهای");
		panel.add(acceptButton, "cell 1 4,alignx center");
		
		JButton failedButton = new JButton("عدم تایید");
		panel.add(failedButton, "cell 1 6,alignx center");
	}

}
