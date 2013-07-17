package edu.sharif.ce.ood.taghi.namayeshgah.ui.request;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
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

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RequestBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import edu.sharif.ce.ood.taghi.namayeshgah.ui.SelecTshowPlaceCombo;
import java.util.List;
import java.awt.event.ItemListener;

public class AddRequest extends BaseUI implements ItemListener {
	private JTextField subjectText;
	private JTextArea descriptionText;
	private JList<RequestBean> list;
	private ShowPlaceBean selectedShowPlace;

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HibernateUtil.getCurrentSession().beginTransaction();
					ShowPlaceBean a = new ShowPlaceBean(FactoryDAO
							.getInstance().getShowPlaceDao().findById(1, false));
					HibernateUtil.commitTransaction();
					AddRequest frame = new AddRequest(a);
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
	public AddRequest(final ShowPlaceBean currentShowPlace) {
		super();
		setTitle("درخواست ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[grow][grow][][][grow][grow][]"));

		// SelecTshowPlaceCombo<ShowPlaceBean> selecTshowPlaceCombo = new
		// SelecTshowPlaceCombo<ShowPlaceBean>(
		// ShowPlaceCatalog.getInstance().getAllShowPlaces(), this);
		// panel.add(selecTshowPlaceCombo, "cell 1 0,grow");

		list = new JList<RequestBean>();
		list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		initialList(currentShowPlace);

		SelecTshowPlaceCombo<ShowPlaceBean> selecTshowPlaceCombo = new SelecTshowPlaceCombo<ShowPlaceBean>(
				ShowPlaceCatalog.getInstance().getAllShowPlaces(), this);
		if (ShowPlaceCatalog.getInstance().getAllShowPlaces().size() > 0)
			selectedShowPlace = ShowPlaceCatalog.getInstance()
					.getAllShowPlaces().get(0);
		panel.add(selecTshowPlaceCombo, "cell 1 0,grow");

		panel.add(list, "cell 1 1,grow");

		JLabel label = new JLabel("درخواست ها");
		panel.add(label, "cell 2 1,aligny top");

		JButton button = new JButton("ایجاد درخواست جدید");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int permition = JOptionPane.showConfirmDialog(AddRequest.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);

				if (permition == 0) {
					ShowPlaceCatalog.getInstance().addNewRequest(
							subjectText.getText(), descriptionText.getText(),
							currentShowPlace);
				}
			}
		});
		panel.add(button, "flowx,cell 1 2");

		subjectText = new JTextField();
		subjectText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(subjectText, "cell 1 3,growx");
		subjectText.setColumns(10);

		JLabel label_1 = new JLabel("عنوان");
		panel.add(label_1, "cell 2 3");

		descriptionText = new JTextArea();
		descriptionText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(descriptionText, "cell 1 4,grow");

		JLabel label_2 = new JLabel("شرح");
		panel.add(label_2, "cell 2 4,aligny top");
	}

	public void initialList(ShowPlaceBean showPlace) {
		List<RequestBean> requests = showPlace.getRequests(showPlace);
		DefaultListModel<RequestBean> model = new DefaultListModel<RequestBean>();
		for (RequestBean bean : requests) {
			model.addElement(bean);
		}
		list.setModel(model);
	}

	public void itemStateChanged(ItemEvent evt) {
		selectedShowPlace = (ShowPlaceBean) evt.getItem();
		System.out.println("addRequest/itemStateChanged/ selectedShowPlace"
				+ selectedShowPlace.getName());

	}

}
