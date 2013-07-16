package edu.sharif.ce.ood.taghi.namayeshgah.ui.processes;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.Sizes;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.LogCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ProcessCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelecTshowPlaceCombo;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelectList;

public class ManageProcess extends BaseUI implements ItemListener {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private ShowPlaceBean showPlace;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageProcess frame = new ManageProcess(ShowPlaceCatalog
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

	private SelectList<ProcessBean> selectList;
	private JList<String> historylist;

	/**
	 * Create the frame.
	 */
	public ManageProcess(List<ShowPlaceBean> showPlaces,
			final ShowPlaceBean currentShowPlace) {
		super();
		setTitle("ویژگی ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.GLUE_COLSPEC, ColumnSpec.decode("0px:grow(6)"),
				FormFactory.GLUE_COLSPEC, }, new RowSpec[] {
				FormFactory.DEFAULT_ROWSPEC,
				RowSpec.decode("0px:grow(3)"),
				new RowSpec(RowSpec.CENTER, Sizes.bounded(Sizes.MINIMUM,
						Sizes.constant("30dlu", false),
						Sizes.constant("50dlu", false)), 0),
				RowSpec.decode("default:grow(5)"), FormFactory.DEFAULT_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC, }));

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "2, 2, fill, fill");
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.DEFAULT_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.GLUE_ROWSPEC,
				RowSpec.decode("20dlu"),}));

		historylist = new JList<String>();
		panel_2.add(historylist, "2, 1, fill, fill");
		initialHistory(currentShowPlace);

		JLabel label_1 = new JLabel("تاریخچه");
		panel_2.add(label_1, "3, 1, default, top");

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 3, fill, fill");
		showPlaces.add(0, new ShowPlaceBean("--"));
		panel_1.setLayout(new MigLayout("", "[grow][][grow]", "[88px,grow]"));
		
//		
		SelecTshowPlaceCombo<ShowPlaceBean> comboBox = new SelecTshowPlaceCombo<ShowPlaceBean>(
				showPlaces, this);
		panel_1.add(comboBox, "cell 0 0,alignx left,aligny top");

		JLabel label = new JLabel("نمایشگاه");
		panel_1.add(label, "cell 1 0,alignx left,aligny center");

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, "cell 2 0,grow");
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton button_1 = new JButton("پایین");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageProcess.this.selectList.moveDown();
			}
		});
		panel_3.add(button_1);

		JButton button_2 = new JButton("بالا");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ManageProcess.this.selectList.moveUp();
			}
		});
		panel_3.add(button_2);

		selectList = new SelectList<ProcessBean>(ProcessCatalog.getInstance()
				.getAllProcesses());
		panel.add(selectList, "2, 4, fill, fill");

		JButton button = new JButton("تایید");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int permition = JOptionPane.showConfirmDialog(
						ManageProcess.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);

				if (permition == 0) {
					currentShowPlace.setProcesses(ManageProcess.this.selectList
							.getSelectedItems());
					ManageProcess.this.dispose();

				}

			}
		});
		panel.add(button, "2, 5, center, default");
	}

	public void initialHistory(ShowPlaceBean currentShowPlace) {
		System.out.println("ManageProcess/initialHistory");
		List<String> logs = LogCatalog.getInstance()
				.getAllProcessLogByShowPlace(currentShowPlace);
		DefaultListModel<String> model = new DefaultListModel<String>();
		for (String log : logs) {
			model.addElement(log);
		}
		historylist.setModel(model);
	}

	public void itemStateChanged(ItemEvent evt) {
		@SuppressWarnings("unchecked")
		ShowPlaceBean newShowPlace = (ShowPlaceBean) ((JComboBox<ShowPlaceBean>) evt
				.getSource()).getModel().getSelectedItem();
		if (newShowPlace.getName().equals("--")) {
			selectList.initialList(ProcessCatalog.getInstance()
					.getAllProcesses());
		} else {
			selectList.initialList(newShowPlace.getAllProcesses());
		}
		System.out
				.println("ManageProcess: combo box trigered: newShowPlace.name:"
						+ newShowPlace.getName());

	}

}
