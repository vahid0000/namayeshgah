package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;

public class Home extends BaseUI implements ItemListener {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	@SuppressWarnings("unchecked")
	public Home() {
		super();
		setTitle("خانه");

		JPanel panel = new JPanel();

		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow][grow]"));

		JLabel label = new JLabel("سامانه نمایشگاه");
		label.setFont(new Font("Tahoma", Font.PLAIN, 50));
		panel.add(label, "cell 0 0,alignx center,aligny center");

		SelecTshowPlaceCombo<ShowPlaceBean> selecTshowPlaceCombo = new SelecTshowPlaceCombo<ShowPlaceBean>(
				ShowPlaceCatalog.getInstance().getAllShowPlaces(), this);
		panel.add(selecTshowPlaceCombo, "cell 0 1,alignx center,growy");


	}

	@SuppressWarnings("unchecked")
	public void itemStateChanged(ItemEvent evt) {
		ShowPlaceBean newShowPlace = (ShowPlaceBean) ((JComboBox<ShowPlaceBean>) evt
				.getSource()).getModel().getSelectedItem();
		System.out.println("Home/itemStateChanged/ newShowPlace:"
				+ newShowPlace.getId());
		this.setButtons(UserCatalog.getInstance()
				.getRolesOfLoggedInUserByShowPlace(newShowPlace));
		ShowPlaceCatalog.getInstance().setCurrentShowPlace(newShowPlace);

	}

}
