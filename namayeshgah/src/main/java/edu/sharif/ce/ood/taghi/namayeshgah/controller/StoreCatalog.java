package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.StoreStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;

public class StoreCatalog {

	private static StoreCatalog session;

	private StoreCatalog() {
	};

	public static StoreCatalog getInstance() {
		if (session == null)
			session = new StoreCatalog();
		return session;
	}

	public void addEnterStuff(String name, ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO.getInstance().getStoreDao().addEnterStuff(name, showPlace);
		HibernateUtil.commitTransaction();
	}

	public List<StoreStuffBean> getAllStuffs(ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<StoreStuffEntity> entities = FactoryDAO.getInstance()
				.getStoreDao().getAllByShowPlace(currentShowPlace);
		ArrayList<StoreStuffBean> stuffs = new ArrayList<StoreStuffBean>();
		for (StoreStuffEntity entity : entities) {
			stuffs.add(new StoreStuffBean(entity));
		}
		HibernateUtil.commitTransaction();
		return stuffs;
	}
}
