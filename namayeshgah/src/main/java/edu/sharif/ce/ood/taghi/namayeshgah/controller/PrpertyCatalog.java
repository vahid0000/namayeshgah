package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;

public class PrpertyCatalog {

	private static PrpertyCatalog session;

	private PrpertyCatalog() {
	};

	public static PrpertyCatalog getInstance() {
		if (session == null)
			session = new PrpertyCatalog();
		return session;
	}

	public List<PropertyBean> getAllProperties() {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<PropertyBean> processes = FactoryDAO.getInstance()
				.getPropertyDao().getAllProperties();
		HibernateUtil.commitTransaction();
		return processes;
	}

}
