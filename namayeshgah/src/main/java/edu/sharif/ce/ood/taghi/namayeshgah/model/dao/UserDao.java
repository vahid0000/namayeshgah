package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RoleBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class UserDao extends GenericHibernateDAO<UserEntity, Integer> {

	public void addUser(String firstName, String lastName, String userName,
			String password) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		entity.setUserName(userName);
		entity.setPassword(password);

	}

	public UserEntity isValid(String userName, String password) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		criteria.add(Restrictions.eq("password", password));
		List<UserEntity> entities = this.findByDetachedCriteria(criteria);
		System.out.println("UserDao: entities.size=" + entities.size());
		if (entities.size() > 0)
			return entities.get(0);
		return null;
	}

	public UserEntity getUserByName(String userName) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
		criteria.add(Restrictions.eq("userName", userName));
		List<UserEntity> entities = this.findByDetachedCriteria(criteria);
		System.out.println("UserDao: getUserByName.size()=" + entities.size());
		if (entities.size() > 0)
			return entities.get(0);
		return null;
	}

	public List<String> getAllUser() {
		List<UserEntity> entities = this.findAll();
		System.out.println("UserDao: getAllUser.size()=" + entities.size());
		ArrayList<String> users_string = new ArrayList<String>();
		for (UserEntity user : entities) {
			users_string.add(user.toString());
		}
		if (users_string.size() > 0)
			return users_string;
		return null;
	}

	public List<RoleBean> getRolesByShowPlace(Integer id,
			ShowPlaceBean showPlace) {
		UserEntity user = this.findById(id, false);
		List<RoleEntity> AllRoles = user.getRoles();
		System.out.println("UserDao/getRolesByShowPlace/ allRoles.size:"
				+ AllRoles.size());
		ArrayList<RoleBean> roles = new ArrayList<RoleBean>();
		for (RoleEntity role : AllRoles) {
			if (role.getShowPlace().getId().equals(showPlace.getId()))
				roles.add(new RoleBean(role));
		}
		return roles;
	}
}
