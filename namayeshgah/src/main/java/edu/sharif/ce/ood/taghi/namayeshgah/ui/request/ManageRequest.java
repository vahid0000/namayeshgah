package edu.sharif.ce.ood.taghi.namayeshgah.ui.request;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RequestBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageRequest extends BaseUI {
	private JTextField subjectText;
	private JList<RequestBean> list;
	private JTextArea descriptionText;
	private JTextArea replyText;

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
					ManageRequest frame = new ManageRequest(a);
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
	public ManageRequest(ShowPlaceBean currentShowPlace) {
		super();
		setTitle("مدیریت درخواست ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][grow][][][grow][grow][]"));

		list = new JList<RequestBean>();
		list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				subjectText.setText(list.getSelectedValue().getSubject());
				descriptionText.setText(list.getSelectedValue()
						.getDescription());
			}
		});
		panel.add(list, "cell 1 1,grow");
		initialList(currentShowPlace);

		JLabel label = new JLabel("درخواست ها");
		panel.add(label, "cell 2 1,aligny top");

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

		replyText = new JTextArea();
		replyText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(replyText, "cell 1 5,grow");

		JLabel label_3 = new JLabel("پاسخ");
		panel.add(label_3, "cell 2 5,aligny top");

		JButton button = new JButton("پاسخ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int permition = JOptionPane.showConfirmDialog(
						ManageRequest.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);

				if (permition == 0) {
					list.getSelectedValue().setReply(replyText.getText());
				}
			}
		});
		panel.add(button, "flowx,cell 1 6");
	}

	public void initialList(ShowPlaceBean showPlace) {
		List<RequestBean> requests = showPlace.getRequests(showPlace);
		DefaultListModel<RequestBean> model = new DefaultListModel<RequestBean>();
		for (RequestBean bean : requests) {
			model.addElement(bean);
		}
		list.setModel(model);
	}

}
