package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;

public class ConstRoleDao extends GenericHibernateDAO<ConstRoleEntity, Integer> {

	public ConstRoleEntity getByNum(Integer num) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ConstRoleEntity.class);
		criteria.add(Restrictions.eq("number", num));
		List<ConstRoleEntity> entities = this.findByDetachedCriteria(criteria);
		System.out.println("ConstroleDao/getByNum/ entities.size="
				+ entities.size());
		if (entities.size() > 0)
			return entities.get(0);
		return null;
	}

}
