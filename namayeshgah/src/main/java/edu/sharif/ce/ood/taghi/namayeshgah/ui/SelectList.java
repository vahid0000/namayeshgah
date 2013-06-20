package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class SelectList extends JPanel {

	/**
	 * Create the panel.
	 */
	public SelectList() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		JList allItems = new JList();
		add(allItems);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton add = new JButton("اضافه");
		add.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(add);
		
		JButton remove = new JButton("حذف");
		remove.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(remove);
		
		JList selectedItems = new JList();
		add(selectedItems);

	}

}
