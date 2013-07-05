package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

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
		System.out.println("UserDao: entities.size="+entities.size());
		if (entities.size() > 0)
			return entities.get(0);
		return null;
	}

}
