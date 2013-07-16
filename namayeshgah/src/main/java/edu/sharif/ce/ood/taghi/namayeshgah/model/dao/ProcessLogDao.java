package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessLogEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class ProcessLogDao extends
		GenericHibernateDAO<ProcessLogEntity, Integer> {

	public void addNewLog(ShowPlaceBean showPlace, List<ProcessBean> processes) {
		ProcessLogEntity log = new ProcessLogEntity();
		log.setDate(new Date());
		StringBuilder builder = new StringBuilder();
		for (ProcessBean p : processes) {
			builder.append(p.getName());
			builder.append(" ");
		}
		log.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findById(showPlace.getId(), false));
		log.setDescription(builder.toString());
		this.makePersistent(log);
	}

	public List<ProcessLogEntity> getAllProcessLogs(ShowPlaceBean showPlace) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ProcessLogEntity.class);
		ShowPlaceEntity showPlaceEntity = FactoryDAO.getInstance()
				.getShowPlaceDao().findById(showPlace.getId(), false);
		criteria.add(Restrictions.eq("showPlace", showPlaceEntity));
		System.out.println("ProcessLogFao/getAllProcessLogs/ showPlace.id:"
				+ showPlace.getId());
		List<ProcessLogEntity> entities = this.findByDetachedCriteria(criteria);
		return entities;

	}
}
