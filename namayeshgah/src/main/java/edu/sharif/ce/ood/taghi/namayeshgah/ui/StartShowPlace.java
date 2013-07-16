package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;

import net.miginfocom.swing.MigLayout;

import java.util.ArrayList;
import java.util.List;

public class StartShowPlace extends BaseUI implements ItemListener {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					StartShowPlace frame = new StartShowPlace(ShowPlaceCatalog
							.getInstance().getAllShowPlaces());
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
	public StartShowPlace(List<ShowPlaceBean> showPlaces) {
		super();
		setTitle("اجرای نمایشگاه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[grow][]"));

		SelecTshowPlaceCombo<ShowPlaceBean> selecTshowPlaceCombo = new SelecTshowPlaceCombo<ShowPlaceBean>(
				showPlaces, this);
		panel.add(selecTshowPlaceCombo, "cell 1 0,grow");

		JLabel label = new JLabel("نمایشگاه");
		panel.add(label, "cell 2 0");

		JButton button_1 = new JButton("خاتمه");
		panel.add(button_1, "flowx,cell 1 1");

		JButton button = new JButton("اجرا");
		panel.add(button, "cell 1 1,alignx right");
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}
