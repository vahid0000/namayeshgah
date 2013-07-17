package edu.sharif.ce.ood.taghi.namayeshgah.ui.report;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ReportCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PeopleReportBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelecTshowPlaceCombo;
import java.util.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddReport extends BaseUI implements ItemListener {
	private JTextField nameText;
	private JList<PeopleReportBean> list;
	private ShowPlaceBean showPlace;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddReport frame = new AddReport();
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
	public AddReport() {
		super();
		setTitle("گزارش مردمی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px,grow 3][]",
				"[grow][][][][][grow][][][grow][]"));
		if (UserCatalog.getInstance().getLogginedUser() != null) {
			list = new JList<PeopleReportBean>();
			panel.add(list, "cell 1 0,grow");

			JLabel label = new JLabel("گزارشات");
			panel.add(label, "cell 2 0,aligny top");
		}
		JLabel label_1 = new JLabel("ثبت گزارش جدید");
		panel.add(label_1, "cell 1 3,alignx center");

		SelecTshowPlaceCombo<ShowPlaceBean> selecTshowPlaceCombo = new SelecTshowPlaceCombo<ShowPlaceBean>(
				ShowPlaceCatalog.getInstance().getAllShowPlaces(), this);
		panel.add(selecTshowPlaceCombo, "cell 1 5,grow");
		if (ShowPlaceCatalog.getInstance().getAllShowPlaces().size() > 0) {
			initialList(ShowPlaceCatalog.getInstance().getAllShowPlaces()
					.get(0));
			showPlace = ShowPlaceCatalog.getInstance().getAllShowPlaces()
					.get(0);
		}
		nameText = new JTextField();
		nameText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(nameText, "cell 1 7,growx");
		nameText.setColumns(10);

		JLabel label_2 = new JLabel("نام و نام خانوادگی");
		panel.add(label_2, "cell 2 7");

		final JTextArea detailText = new JTextArea();
		detailText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(detailText, "cell 1 8,grow");

		JLabel label_3 = new JLabel("شرح گزارش");
		panel.add(label_3, "cell 2 8,aligny top");

		JButton button = new JButton("ذخیره");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ReportCatalog.getInstance().addNewPeopleReport(
						nameText.getText(), detailText.getText(), showPlace);
				initialList(showPlace);
			}
		});
		panel.add(button, "cell 1 9,alignx center");
	}

	public void itemStateChanged(ItemEvent evt) {
		// TODO Auto-generated method stub
		ShowPlaceBean currentShowPlace = ((ShowPlaceBean) evt.getItem());
		showPlace = currentShowPlace;
		System.out.println("add Request/itemStateChanged "
				+ currentShowPlace.getName());
		initialList(currentShowPlace);

	}

	private void initialList(ShowPlaceBean currentShowPlaceBean) {
		List<PeopleReportBean> reports = ReportCatalog.getInstance()
				.getReportsByShowPlace(currentShowPlaceBean);
		System.out.println("addReport/initialList/ reports.size:"
				+ reports.size());
		DefaultListModel<PeopleReportBean> model = new DefaultListModel<PeopleReportBean>();
		for (PeopleReportBean phone : reports) {
			model.addElement(phone);
		}

		list.setModel(model);
	}

}
