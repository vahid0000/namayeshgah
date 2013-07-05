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

import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends BaseUI {
	private JTextField userNameTextField;
	private JTextField passTextField;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		super();
		setTitle("ورود");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][][]", "[][][][][][]"));

		final JLabel erorrLabel = new JLabel("");
		panel.add(erorrLabel, "cell 1 0");

		userNameTextField = new JTextField();
		panel.add(userNameTextField, "cell 1 1,growx");
		userNameTextField.setColumns(10);

		JLabel label = new JLabel("نام کاربری");
		panel.add(label, "cell 2 1");

		passTextField = new JTextField();
		panel.add(passTextField, "cell 1 3,growx");
		passTextField.setColumns(10);

		JLabel label_1 = new JLabel("کلمه عبور");
		panel.add(label_1, "cell 2 3");

		JButton button = new JButton("ورود");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean result = UserCatalog.getInstance().login(
						userNameTextField.getText(), passTextField.getText());
				if (result == false)
					erorrLabel.setText("نام کاربری یا کلمه عبور غلط است");
				else {
					JFrame frame = new Home();
					frame.setVisible(true);
					Login.this.dispose();

				}
			}
		});
		panel.add(button, "cell 1 5,alignx center");
	}

}
