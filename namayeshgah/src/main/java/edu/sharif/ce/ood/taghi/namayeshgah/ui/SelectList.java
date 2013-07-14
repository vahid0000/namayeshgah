package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import antlr.collections.List;

public class SelectList extends JPanel {

	ArrayList<String> items;
	JList allItems;
	JList selectedItems;
	/**
	 * Create the panel.
	 */
	public SelectList() {
		setLayout(new GridLayout(0, 3, 0, 0));
		
		allItems = new JList();
		add(allItems);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JButton add = new JButton("<اضافه");
		add.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(add);
		
		JButton remove = new JButton("حذف>");
		remove.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(remove);
		
		selectedItems = new JList();
		add(selectedItems);

	}
	public void initial(String[] rows){
		items= new ArrayList<String>();
		for(String s : rows){
			items.add(s);
		}
	}
	public void addStringToSelected(String s){
//		( (DefaultListModel) selectedItems.getModel() ).addElement( allItems.getSelectedValue().getText() );
		
	}
	public java.util.List<String> getSelectedItems(){
		return null;
	}
}
