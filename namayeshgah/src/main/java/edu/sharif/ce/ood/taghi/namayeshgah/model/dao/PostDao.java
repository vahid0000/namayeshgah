package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PostStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ReceiptEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PostStuffStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ReceiptStatus;

public class PostDao extends GenericHibernateDAO<PostStuffEntity, Integer> {


	public List<PostStuffEntity> findByShowPlace(ShowPlaceBean currentShowPlace) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PostStuffEntity.class);
		criteria.add(Restrictions.eq("showPlace", FactoryDAO.getInstance()
				.getShowPlaceDao().findByShowPlaceBean(currentShowPlace)));
		List<PostStuffEntity> entities = this.findByDetachedCriteria(criteria);
		return entities;
	}

	public void addStuff(String subject, String sender, String destination,
			ShowPlaceEntity showPlace) {
		PostStuffEntity entity = new PostStuffEntity();
		entity.setDestination(destination);
		entity.setName(subject);
		entity.setPostStuffStatus(PostStuffStatus.newAdded);
		entity.setShowPlace(showPlace);
		this.makePersistent(entity);

	}

}
