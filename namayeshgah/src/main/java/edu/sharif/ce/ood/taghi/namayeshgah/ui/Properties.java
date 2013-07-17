package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.LogCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.PrpertyCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Properties extends BaseUI implements ItemListener {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Properties frame = new Properties(ShowPlaceCatalog
							.getInstance().getAllShowPlaces(),
							new ShowPlaceBean(FactoryDAO.getInstance()
									.getShowPlaceDao().findById(1, false)));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private SelectList<PropertyBean> selectList;
	private JList<String> historyList;

	/**
	 * Create the frame.
	 */
	public Properties(List<ShowPlaceBean> showPlaces,
			final ShowPlaceBean currentShowPlace) {
		super();
		setTitle("ویژگی ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC, ColumnSpec.decode("0px:grow(6)"),
				FormFactory.GLUE_COLSPEC, }, new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("default:grow(3)"),
				FormFactory.DEFAULT_ROWSPEC, RowSpec.decode("0px:grow(5)"),
				FormFactory.DEFAULT_ROWSPEC, FormFactory.GLUE_ROWSPEC, }));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4, "2, 2, fill, fill");
		panel_4.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("0px"),
				FormFactory.GLUE_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.GLUE_ROWSPEC,
				RowSpec.decode("15dlu"),}));

		historyList = new JList<String>();
		panel_4.add(historyList, "2, 1, fill, fill");
		initialHistory(currentShowPlace);

		JLabel label_1 = new JLabel("تاریخچه");
		panel_4.add(label_1, "3, 1, default, top");

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 3, fill, fill");
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC, FormFactory.GLUE_COLSPEC,
				FormFactory.GLUE_COLSPEC, },
				new RowSpec[] { FormFactory.DEFAULT_ROWSPEC, }));

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "1, 1, fill, bottom");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		SelecTshowPlaceCombo<ShowPlaceBean> comboBox = new SelecTshowPlaceCombo<ShowPlaceBean>(
				showPlaces, this);
		panel_3.add(comboBox);

		JLabel label = new JLabel("نمایشگاه ها");
		panel_3.add(label);

		selectList = new SelectList<PropertyBean>(PrpertyCatalog.getInstance()
				.getAllProperties());
		panel.add(selectList, "2, 4, fill, fill");

		JButton button_2 = new JButton("تایید");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int permition = JOptionPane.showConfirmDialog(Properties.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);

				if (permition == 0) {
					currentShowPlace.setProperties(Properties.this.selectList
							.getSelectedItems());
					Properties.this.dispose();
					JFrame frame = new Home();
					frame.setVisible(true);

				}
			}
		});
		panel.add(button_2, "2, 5, center, center");
	}

	public void initialHistory(ShowPlaceBean currentShowPlace) {
		System.out.println("ManageProcess/initialHistory");
		List<String> logs = LogCatalog.getInstance()
				.getAllPropertiesLogByShowPlace(currentShowPlace);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String log : logs) {
			model.addElement(log);
		}
		historyList.setModel(model);
	}

	@SuppressWarnings("unchecked")
	public void itemStateChanged(ItemEvent evt) {
		ShowPlaceBean newShowPlace = (ShowPlaceBean) ((JComboBox<ShowPlaceBean>) evt
				.getSource()).getModel().getSelectedItem();
		if (newShowPlace.getName().equals("--")) {
			selectList.initialList(PrpertyCatalog.getInstance()
					.getAllProperties());
		} else {
			selectList.initialList(newShowPlace.getProperties());
		}
		System.out
				.println("ManageProcess: combo box trigered: newShowPlace.name:"
						+ newShowPlace.getName());

	}

}
