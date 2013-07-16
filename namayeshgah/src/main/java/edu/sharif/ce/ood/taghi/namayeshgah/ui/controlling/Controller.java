package edu.sharif.ce.ood.taghi.namayeshgah.ui.controlling;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.BoothBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.BoothStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.StartShowPlace;

public class Controller extends BaseUI {

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
					Controller frame = new Controller(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JList<BoothBean> list;

	/**
	 * Create the frame.
	 */
	public Controller(ShowPlaceBean currentShowPlace) {
		super();
		setTitle("ثبت بازرسی غرفه ها");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][][][grow][]"));

		JLabel label_2 = new JLabel("غرفه ها");
		panel.add(label_2, "cell 1 3,alignx center");

		list = new JList<BoothBean>();
		list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(list, "cell 1 4,grow");
		initialList(currentShowPlace);

		JButton button = new JButton("تایید بازرسی");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(Controller.this,
							"هیچ غرفه ای را انتخاب نکرده اید", "خطا",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int permition = JOptionPane.showConfirmDialog(Controller.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
				if (permition == 0) {
					list.getSelectedValue().setBoothStatus(
							BoothStatus.available);
					list.updateUI();
				}
			}
		});
		panel.add(button, "flowx,cell 1 5,alignx center");

		JButton button_1 = new JButton("دارای اشکال");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(Controller.this,
							"هیچ غرفه ای را انتخاب نکرده اید", "خطا",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int permition = JOptionPane.showConfirmDialog(Controller.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
				if (permition == 0) {
					list.getSelectedValue().setBoothStatus(
							BoothStatus.deliqunet);
					list.updateUI();
				}
			}
		});
		panel.add(button_1, "cell 1 5");
	}

	private void initialList(ShowPlaceBean currentShowPlace) {
		List<BoothBean> boothes = currentShowPlace.getBoothes();
		System.out.println("controller/ initialList/ boothes.size"
				+ boothes.size());
		DefaultListModel<BoothBean> model = new DefaultListModel<BoothBean>();
		for (BoothBean bean : boothes) {
			model.addElement(bean);
		}
		this.list.setModel(model);
	}
}
