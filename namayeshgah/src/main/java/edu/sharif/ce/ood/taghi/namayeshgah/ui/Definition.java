package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Definition extends BaseUI {
	private JTextField nameText;
	private JTextField ownerText;
	public SelectList<String> selectList;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<String> a = new ArrayList<String>();
					a.add("a");
					a.add("b");
					a.add("c");
					a.add("d");
					Definition frame = new Definition(a);
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
	public Definition(List<String> allUsers) {
		super();

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JLabel lName = new JLabel("نام");
		panel.add(lName);

		JLabel lBrief = new JLabel("خلاصه توضیح");
		sl_panel.putConstraint(SpringLayout.WEST, lBrief, 0, SpringLayout.WEST,
				lName);
		panel.add(lBrief);

		JLabel lDescription = new JLabel("شرح");
		sl_panel.putConstraint(SpringLayout.NORTH, lDescription, 46,
				SpringLayout.SOUTH, lBrief);
		sl_panel.putConstraint(SpringLayout.WEST, lDescription, 0,
				SpringLayout.WEST, lName);
		panel.add(lDescription);

		JLabel lStaff = new JLabel("هیئت عالی");
		sl_panel.putConstraint(SpringLayout.WEST, lStaff, 0, SpringLayout.WEST,
				lName);
		panel.add(lStaff);

		selectList = new SelectList<String>(allUsers);
		sl_panel.putConstraint(SpringLayout.WEST, selectList, 26,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, selectList, -25,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, selectList, -6,
				SpringLayout.WEST, lStaff);
		panel.add(selectList);

		nameText = new JTextField();
		nameText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		sl_panel.putConstraint(SpringLayout.NORTH, lName, 3,
				SpringLayout.NORTH, nameText);
		sl_panel.putConstraint(SpringLayout.WEST, lName, 4, SpringLayout.EAST,
				nameText);
		sl_panel.putConstraint(SpringLayout.EAST, nameText, -78,
				SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.WEST, nameText, 26,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, nameText, 10,
				SpringLayout.NORTH, panel);
		panel.add(nameText);
		nameText.setColumns(10);

		final JTextArea shortDescriptionText = new JTextArea();
		shortDescriptionText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		sl_panel.putConstraint(SpringLayout.NORTH, shortDescriptionText, 7,
				SpringLayout.SOUTH, nameText);
		sl_panel.putConstraint(SpringLayout.WEST, shortDescriptionText, 26,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, shortDescriptionText, -6,
				SpringLayout.WEST, lBrief);
		sl_panel.putConstraint(SpringLayout.NORTH, lBrief, -2,
				SpringLayout.NORTH, shortDescriptionText);
		shortDescriptionText.setText("خلاصه");
		panel.add(shortDescriptionText);

		final JTextArea descriptionText = new JTextArea();
		descriptionText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		sl_panel.putConstraint(SpringLayout.SOUTH, shortDescriptionText, -11,
				SpringLayout.NORTH, descriptionText);
		sl_panel.putConstraint(SpringLayout.SOUTH, descriptionText, -184,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, descriptionText, -6,
				SpringLayout.WEST, lDescription);
		sl_panel.putConstraint(SpringLayout.NORTH, descriptionText, 97,
				SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, descriptionText, 26,
				SpringLayout.WEST, panel);
		descriptionText.setText("شرح");
		panel.add(descriptionText);

		JLabel label = new JLabel("سفارش دهنده");
		sl_panel.putConstraint(SpringLayout.NORTH, lStaff, 11,
				SpringLayout.SOUTH, label);
		sl_panel.putConstraint(SpringLayout.SOUTH, label, -163,
				SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST,
				lName);
		panel.add(label);

		ownerText = new JTextField();
		ownerText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		sl_panel.putConstraint(SpringLayout.NORTH, selectList, 6,
				SpringLayout.SOUTH, ownerText);
		sl_panel.putConstraint(SpringLayout.WEST, ownerText, 26,
				SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, ownerText, -6,
				SpringLayout.WEST, label);
		sl_panel.putConstraint(SpringLayout.NORTH, ownerText, 6,
				SpringLayout.SOUTH, descriptionText);
		panel.add(ownerText);
		ownerText.setColumns(10);

		JButton button = new JButton("ذخیره");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int permition = JOptionPane.showConfirmDialog(Definition.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات",
						JOptionPane.YES_NO_OPTION);

				if (permition == 0) {
					System.out.println("UI defenition: addShowPlace name:"
							+ nameText.getText());
					ShowPlaceCatalog.getInstance().addShowPlace(
							nameText.getText(), shortDescriptionText.getText(),
							descriptionText.getText(), ownerText.getText(),
							selectList.getSelectedItems());
					Definition.this.dispose();
				}
			}
		});
		sl_panel.putConstraint(SpringLayout.WEST, button, 0, SpringLayout.WEST,
				selectList);
		sl_panel.putConstraint(SpringLayout.SOUTH, button, 0,
				SpringLayout.SOUTH, panel);
		panel.add(button);

	}

}
