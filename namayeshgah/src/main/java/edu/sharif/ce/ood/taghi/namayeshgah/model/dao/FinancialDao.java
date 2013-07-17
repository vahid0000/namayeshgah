package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ReceiptEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ReceiptStatus;

public class FinancialDao extends GenericHibernateDAO<ReceiptEntity, Integer> {

	public void addReceipt(Double price, String description,
			ShowPlaceBean showPlace) {
		ReceiptEntity entity = new ReceiptEntity();
		entity.setDescription(description);
		entity.setPrice(price);

		entity.setLastDateStatusChange(new Date());
		entity.setReceiptStatus(ReceiptStatus.nonPaid);
		entity.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(showPlace));
		this.makePersistent(entity);

	}

	public List<ReceiptEntity> findByShowPlace(ShowPlaceBean currentShowPlace) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ReceiptEntity.class);
		criteria.add(Restrictions.eq("showPlace", FactoryDAO.getInstance()
				.getShowPlaceDao().findByShowPlaceBean(currentShowPlace)));
		List<ReceiptEntity> entities = this.findByDetachedCriteria(criteria);
		return entities;
	}

}
