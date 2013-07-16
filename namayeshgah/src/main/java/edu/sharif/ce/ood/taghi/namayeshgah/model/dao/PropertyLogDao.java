package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessLogEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyLogEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class PropertyLogDao extends
		GenericHibernateDAO<PropertyLogEntity, Integer> {

	public void addNewLog(ShowPlaceBean showPlace, List<PropertyBean> properties) {
		PropertyLogEntity log = new PropertyLogEntity();
		log.setDate(new Date());
		StringBuilder builder = new StringBuilder();
		for (PropertyBean p : properties) {
			builder.append(p.getSubject());
			builder.append(" ");
		}
		log.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findById(showPlace.getId(), false));
		log.setDescription(builder.toString());
		this.makePersistent(log);
	}

	public List<PropertyLogEntity> getAllPropertyLogs(ShowPlaceBean showPlace) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(PropertyLogEntity.class);
		ShowPlaceEntity showPlaceEntity = FactoryDAO.getInstance()
				.getShowPlaceDao().findById(showPlace.getId(), false);
		criteria.add(Restrictions.eq("showPlace", showPlaceEntity));
		System.out.println("ProcpertyLogFao/getAllproperiesLogs/ showPlace.id:"
				+ showPlace.getId());
		List<PropertyLogEntity> entities = this
				.findByDetachedCriteria(criteria);
		return entities;

	}
}
