package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class ReportDao extends GenericHibernateDAO<PeopleReportEntity, Integer> {

	public List<PeopleReportEntity> getPeopleReportsByShowPlace(
			ShowPlaceEntity showPlace) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PeopleReportEntity.class);
		criteria.add(Restrictions.eq("showPlace", showPlace));
		List<PeopleReportEntity> entities = this
				.findByDetachedCriteria(criteria);
		return entities;
	}

	public void addPeopleReport(String name, String detail,
			ShowPlaceEntity showPlace) {
		PeopleReportEntity entity = new PeopleReportEntity();
		entity.setDescription(detail);
		entity.setName(name);
		entity.setShowPlace(showPlace);
		this.makePersistent(entity);

	}
}
