package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.UserBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PhoneNumberEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ImplementationStatus;

public class ShowPlaceDao extends GenericHibernateDAO<ShowPlaceEntity, Integer> {

	public ShowPlaceEntity addShowPlace(String name, String defSummary,
			String definition, String owner, List<String> groupManager) {
		ShowPlaceEntity entity = new ShowPlaceEntity();
		entity.setName(name);
		entity.setDefSummary(defSummary);
		entity.setDefinition(definition);
		entity.setOwner(owner);
		entity.setImplementationStatus(ImplementationStatus.builded);
		entity.setBoothes(null);
		entity.setPeopleReports(null);
		entity.setProcesses(null);
		entity.setProperties(null);
		Set<UserEntity> userList = new HashSet<UserEntity>();
		for (String gname : groupManager) {
			UserEntity user = FactoryDAO.getInstance().getUserDao()
					.getUserByName(gname);
			UserBean userBean = new UserBean(user);
			userList.add(user);
		}
		entity.setUsers(userList);
		this.makePersistent(entity);

		for (String gname : groupManager) {
			UserEntity user = FactoryDAO.getInstance().getUserDao()
					.getUserByName(gname);
			FactoryDAO.getInstance().getRoleDao().addRole(24, user, entity);
			FactoryDAO.getInstance().getRoleDao().addRole(16, user, entity);
			FactoryDAO.getInstance().getRoleDao().addRole(23, user, entity);
			FactoryDAO.getInstance().getRoleDao().addRole(25, user, entity);
			FactoryDAO.getInstance().getRoleDao().addRole(26, user, entity);
			FactoryDAO.getInstance().getRoleDao().addRole(27, user, entity);
		}
		return entity;
	}

	public void setProcessesById(Integer id, List<ProcessBean> processes) {
		ArrayList<ProcessEntity> processesEntities = new ArrayList<ProcessEntity>();
		for (ProcessBean process : processes) {
			ProcessEntity entity = FactoryDAO.getInstance().getProcessDao()
					.findById(process.getId(), false);
			entity.setStartDate(process.getStartDate());
			entity.setEndDate(process.getEndDate());
			processesEntities.add(entity);
		}
		ShowPlaceEntity showPlace = FactoryDAO.getInstance().getShowPlaceDao()
				.findById(id, false);
		System.out
				.println("ShowPlaceDao/setProcessesById/ processesEntities.size():");
		System.out
				.println("ShowPlaceDao/setProcessesById/ before.processes.size():"
						+ showPlace.getProcesses().size());

		showPlace.setProcesses(processesEntities);
		System.out
				.println("ShowPlaceDao/setProcessesById/ after.processes.size():"
						+ showPlace.getProcesses().size());

	}

	public void setPropertyById(Integer id, List<PropertyBean> properties) {
		ArrayList<PropertyEntity> propertyEntities = new ArrayList<PropertyEntity>();
		for (PropertyBean process : properties) {
			propertyEntities.add(FactoryDAO.getInstance().getPropertyDao()
					.findById(process.getId(), false));
		}
		ShowPlaceEntity showPlace = FactoryDAO.getInstance().getShowPlaceDao()
				.findById(id, false);
		System.out
				.println("ShowPlaceDao/setPropertyById/ before.Property.size():"
						+ showPlace.getProcesses().size());

		showPlace.setProperties(propertyEntities);
		System.out
				.println("ShowPlaceDao/setProcessesById/ after.Property.size():"
						+ showPlace.getProcesses().size());

	}

	public ShowPlaceEntity findByShowPlaceBean(ShowPlaceBean currentShowPlace) {
		return this.findById(currentShowPlace.getId(), false);
	}
}
