package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ItemListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class SelecTshowPlaceCombo<T> extends JPanel {
	private List<T> items;
	private JComboBox<T> comboBox;
	private JLabel label;
	private T newValue;

	/**
	 * Create the panel.
	 */
	public SelecTshowPlaceCombo(List<T> items,ItemListener listener) {
		setLayout(new MigLayout("", "[47px][47px]", "[61px]"));

		comboBox = new JComboBox<T>();
		comboBox.addItemListener(listener);
		add(comboBox, "cell 0 0,grow");

		label = new JLabel("نمایشگاه");
		add(label, "cell 1 0,grow");
		this.initialCombo(items);
	}

	public void initialCombo(List<T> items) {
		// this.items=items;
		DefaultComboBoxModel<T> model = new DefaultComboBoxModel<T>();
		for (T item : items) {
			model.addElement(item);
		}
		comboBox.setModel(model);

	}

	@SuppressWarnings("unchecked")
	public T getSelectedItem() {
		return ((T) comboBox.getModel().getSelectedItem());

	}

}
