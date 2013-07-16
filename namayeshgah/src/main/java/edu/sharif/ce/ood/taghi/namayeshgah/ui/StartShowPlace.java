package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;

public class StartShowPlace extends BaseUI implements ItemListener {

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
					StartShowPlace frame = new StartShowPlace(a);
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
	public StartShowPlace(final ShowPlaceBean showPlace) {
		super();
		setTitle("اجرای نمایشگاه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]", "[][]"));

		JButton button_1 = new JButton("خاتمه");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int permition = JOptionPane.showConfirmDialog(
						StartShowPlace.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
				if (permition == 0) {
					showPlace.End();
				}
			}
		});
		panel.add(button_1, "flowx,cell 1 1,alignx center");

		JButton button = new JButton("اجرا");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int permition = JOptionPane.showConfirmDialog(
						StartShowPlace.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
				if (permition == 0) {
					showPlace.Start();
				}
			}
		});
		panel.add(button, "cell 1 1,alignx center");
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}
