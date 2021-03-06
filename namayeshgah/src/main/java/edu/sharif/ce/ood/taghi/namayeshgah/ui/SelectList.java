package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

public class SelectList<T> extends JPanel {

	JList<T> allItems;
	private JList<T> selectedItems;
	private DefaultListModel<T> allItemsModel;
	private DefaultListModel<T> selectedItemsModel;
	private JPanel panel;
	private JButton add;
	private JButton remove;

	ArrayList<String> items;

	private void init(List<T> items) {
		setLayout(new GridLayout(0, 3, 0, 0));

		allItems = new JList<T>();
		add(allItems);

		panel = new JPanel();
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		selectedItems = new JList<T>();

		add(selectedItems);

		add = new JButton("<اضافه");
		add.setName("add");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				T item = allItemsModel.getElementAt(allItems.getSelectedIndex());
				selectedItemsModel.addElement(item);
				allItemsModel.removeElement(item);

			}
		});
		add.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(add);

		remove = new JButton("حذف>");
		remove.setName("remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				T item = selectedItemsModel.getElementAt(selectedItems
						.getSelectedIndex());
				allItemsModel.addElement(item);
				selectedItemsModel.removeElement(item);
			}
		});
		remove.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(remove);
		this.initialList(items);
	}

	public T getSelectedFromAllItems(){
		return allItems.getSelectedValue();
	}
	
	public void initialList(List<T> items) {
		selectedItemsModel = new DefaultListModel<T>();
		allItemsModel = new DefaultListModel<T>();
		if (items != null) {
			for (T item : items) {
				allItemsModel.addElement(item);
			}
		}
		allItems.setModel(allItemsModel);
		selectedItems.setModel(selectedItemsModel);
	}

	public SelectList(List<T> items, ActionListener listener) {
		init(items);
		add.addActionListener(listener);
		remove.addActionListener(listener);

	}

	/**
	 * Create the panel.
	 */
	public SelectList(List<T> items) {
		init(items);
	}

	public List<T> getSelectedItems() {

		DefaultListModel<T> modal = (DefaultListModel<T>) selectedItems
				.getModel();
		int size = modal.getSize();
		ArrayList<T> items = new ArrayList<T>();
		for (int i = 0; i < size; i++) {
			items.add(modal.getElementAt(i));
		}
		System.out.println("Select List: get Selected Items:" + items);
		return items;
	}

	public void moveUp() {
		int index = this.selectedItems.getSelectedIndex();
		T rightSelected = this.selectedItemsModel.getElementAt(index);
		this.selectedItemsModel.remove(index);
		if (index > 0)
			index = index - 1;
		this.selectedItemsModel.add(index, rightSelected);

	}

	public void moveDown() {
		int index = this.selectedItems.getSelectedIndex();
		T rightSelected = this.selectedItemsModel.getElementAt(index);
		this.selectedItemsModel.remove(index);
		if (index < this.selectedItemsModel.getSize())
			index = index + 1;
		this.selectedItemsModel.add(index, rightSelected);

	}

}
