package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ReceiptBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.StoreStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ReceiptEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;

public class FinancialCatalog {

	private static FinancialCatalog session;

	private FinancialCatalog() {
	};

	public static FinancialCatalog getInstance() {
		if (session == null)
			session = new FinancialCatalog();
		return session;
	}

	public void addEnterreciept(Double number,String description, ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO.getInstance().getFinancialDao().addReceipt(number,description, showPlace);
		HibernateUtil.commitTransaction();
	}

	public List<ReceiptBean> getAllReciepts(ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<ReceiptEntity> entities = FactoryDAO.getInstance()
				.getFinancialDao().findByShowPlace(currentShowPlace);
		ArrayList<ReceiptBean> stuffs = new ArrayList<ReceiptBean>();
		for (ReceiptEntity entity : entities) {
			stuffs.add(new ReceiptBean(entity));
		}
		HibernateUtil.commitTransaction();
		return stuffs;
	}
}
