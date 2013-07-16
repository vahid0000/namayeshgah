package edu.sharif.ce.ood.taghi.namayeshgah.ui.controlling;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.BoothBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

public class Penalty extends BaseUI {
	private JList<BoothBean> list;

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
					Penalty frame = new Penalty(a);
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
	public Penalty(ShowPlaceBean currentShowPlace) {
		super();
		setTitle("فراخوان و اطلاع رسانی");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[][][grow][grow][][]"));

		JLabel label_2 = new JLabel("غرفه ها");
		panel.add(label_2, "cell 1 1,alignx center");

		list = new JList<BoothBean>();
		list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(list, "cell 1 2,grow");
		this.initialList(currentShowPlace);

		final JTextArea descriptionText = new JTextArea();
		descriptionText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(descriptionText, "cell 1 3,grow");

		JLabel label_3 = new JLabel("گزارش");
		panel.add(label_3, "cell 2 3,aligny top");

		JButton button = new JButton("ثبت جریمه");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(Penalty.this,
							"هیچ غرفه ای را انتخاب نکرده اید", "خطا",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int permition = JOptionPane.showConfirmDialog(Penalty.this,
							"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
							"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
					if (permition == 0) {
						list.getSelectedValue().addPenalty(
								descriptionText.getText());
					}
				}
			}
		});
		panel.add(button, "cell 1 5,alignx center");
	}

	private void initialList(ShowPlaceBean currentShowPlace) {
		List<BoothBean> boothes = currentShowPlace.getDeliquentBoothes();
		System.out.println("Penalty/ initialList/ boothes.size"
				+ boothes.size());
		DefaultListModel<BoothBean> model = new DefaultListModel<BoothBean>();
		for (BoothBean bean : boothes) {
			model.addElement(bean);
		}
		this.list.setModel(model);
	}

}
