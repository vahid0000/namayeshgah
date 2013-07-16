package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RoleStatus;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class UserBean {

	private String fullName;
	private Integer id;

	public UserBean(UserEntity entity) {
		fullName = entity.getFirstName() + " " + entity.getLastName();
		this.id = entity.getId();

	}

	public String getFullname() {
		return fullName;
	}

	public List<RoleBean> getButtonsByShowPlace(ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<RoleBean> roles = FactoryDAO.getInstance().getUserDao()
				.getRolesByShowPlace(this.id, currentShowPlace);
		HibernateUtil.commitTransaction();
		return roles;
	}

//	public void addManagerRoles(ShowPlaceBean showPlace) {
//		HibernateUtil.getCurrentSession().beginTransaction();
//		// TODO Auto-generated method stub
//		FactoryDAO.getInstance().getRoleDao()
//				.addRole(num, this.id, showPlace.getId());
//
//		HibernateUtil.commitTransaction();
//	}

}
