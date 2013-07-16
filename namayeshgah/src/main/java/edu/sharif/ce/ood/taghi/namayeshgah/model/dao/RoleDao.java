package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class RoleDao extends GenericHibernateDAO<RoleEntity, Integer> {

	public void addRole(int num, int userId, int showPlaceId) {
		UserEntity user = FactoryDAO.getInstance().getUserDao()
				.findById(userId, false);
		ShowPlaceEntity showPlace = FactoryDAO.getInstance().getShowPlaceDao()
				.findById(showPlaceId, false);
		ConstRoleEntity constRole = FactoryDAO.getInstance().getConstRoleDao()
				.getByNum(num);
		RoleEntity role = new RoleEntity();
		role.setConstRoleEntity(constRole);
		role.setShowPlace(showPlace);
		role.setUser(user);
		this.makePersistent(role);
	}

	public void addRole(int num, UserEntity user, ShowPlaceEntity showPlace) {
		ConstRoleEntity constRole = FactoryDAO.getInstance().getConstRoleDao()
				.getByNum(num);
		RoleEntity role = new RoleEntity();
		role.setConstRoleEntity(constRole);
		role.setShowPlace(showPlace);
		role.setUser(user);
		this.makePersistent(role);
	}

}
