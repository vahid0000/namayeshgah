package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PhoneBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PrivateNewsBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;

public class Portal {

	private static Portal session;

	private Portal() {
	};

	public static Portal getInstance() {
		if (session == null)
			session = new Portal();
		return session;
	}

	public void addNews(String subject, boolean isPublic, String description,
			String files, ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO
				.getInstance()
				.getNewsDao()
				.addNews(subject, isPublic, description, files,
						currentShowPlace);
		HibernateUtil.commitTransaction();

	}

	public void addPrivateNews(String text,
			DefaultListModel<PhoneBean> defaultListModel,
			ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		ArrayList<PhoneBean> phones = new ArrayList<PhoneBean>();
		for (int i = 0; i < defaultListModel.size(); i++) {
			phones.add(defaultListModel.getElementAt(i));

		}
		FactoryDAO.getInstance().getNewsDao()
				.addPrivateNews(text, phones, currentShowPlace);

		HibernateUtil.commitTransaction();

	}

	public PrivateNewsBean getAllPrivateNewsByShowPlace(ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		PrivateNewsBean bean = FactoryDAO.getInstance().getNewsDao()
				.getAllPrivateNewsByShowPlace(showPlace);
		HibernateUtil.commitTransaction();
		return bean;
	}
}