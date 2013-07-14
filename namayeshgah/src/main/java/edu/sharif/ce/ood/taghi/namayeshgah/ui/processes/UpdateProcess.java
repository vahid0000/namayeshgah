package edu.sharif.ce.ood.taghi.namayeshgah.ui.processes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

public class UpdateProcess extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProcess frame = new UpdateProcess();
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
	public UpdateProcess() {
		super();
		setTitle("به روزرسانی فرآیند");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][grow][]"));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, "cell 1 0,alignx right");
		
		JLabel label = new JLabel("نمایشگاه");
		panel.add(label, "cell 2 0");
		
		JList list = new JList();
		panel.add(list, "cell 1 1,grow");
		
		JLabel label_1 = new JLabel("لیست فرآیندها");
		panel.add(label_1, "cell 2 1,aligny top");
		
		JButton button = new JButton("به روز رسانی");
		panel.add(button, "flowx,cell 1 2,alignx center");
		
		JButton button_1 = new JButton("اجرا");
		panel.add(button_1, "cell 1 2");
	}

}
