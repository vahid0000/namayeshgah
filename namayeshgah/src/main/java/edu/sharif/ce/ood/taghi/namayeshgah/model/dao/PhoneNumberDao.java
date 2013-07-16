package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.NewsEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PhoneNumberEntity;

public class PhoneNumberDao extends
		GenericHibernateDAO<PhoneNumberEntity, Integer> {

	public List<PhoneNumberEntity> getAllPhonesByNews(NewsEntity entity) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PhoneNumberEntity.class);
		criteria.add(Restrictions.eq("news", entity));
		List<PhoneNumberEntity> entities = this
				.findByDetachedCriteria(criteria);
		return entities;
	}

}
