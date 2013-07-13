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

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ImplementationStatus;

public class ShowPlaceDao extends GenericHibernateDAO<ShowPlaceEntity, Integer> {

	public ShowPlaceEntity addShowPlace(String name, String defSummary, String definition, String owner, List<String> groupManager) {
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
		for(String gname: groupManager){
			Set<UserEntity> userList= new HashSet<UserEntity>();
			userList.add( FactoryDAO.getInstance().getUserDao()
					.getUserByName(gname));
			entity.setUsers(userList);
		}
		this.makePersistent(entity);
		return entity;
	}
}
