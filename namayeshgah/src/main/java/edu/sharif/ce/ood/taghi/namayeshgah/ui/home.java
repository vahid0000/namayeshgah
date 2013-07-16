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

import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.Font;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

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
		if (ShowPlaceCatalog.getInstance().getAllShowPlaces().size() > 0)
			ShowPlaceCatalog.getInstance().setCurrentShowPlace(
					ShowPlaceCatalog.getInstance().getAllShowPlaces().get(0));
		this.setButtons(UserCatalog.getInstance()
				.getRolesOfLoggedInUserByShowPlace(
						ShowPlaceCatalog.getInstance().getCurrentShowPlace()));
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
