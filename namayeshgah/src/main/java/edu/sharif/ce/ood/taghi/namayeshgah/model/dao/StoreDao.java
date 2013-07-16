package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.Date;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.StoreStuffStatus;

public class StoreDao extends GenericHibernateDAO<StoreStuffEntity, Integer> {

	public void addEnterStuff(String name, ShowPlaceBean showPlace) {
		StoreStuffEntity entity = new StoreStuffEntity();
		entity.setLastDateStatusChange(new Date());
		entity.setName(name);
		entity.setStoreStuffStatus(StoreStuffStatus.enter);
		entity.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(showPlace));
		this.makePersistent(entity);

	}

}
