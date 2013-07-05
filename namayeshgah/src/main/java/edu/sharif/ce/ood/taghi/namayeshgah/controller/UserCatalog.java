package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;

import javassist.compiler.ast.NewExpr;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class UserCatalog {

	private static UserCatalog session;
	private UserController logginedUser;

	private UserCatalog() {
		logginedUser = null;
	};

	public static UserCatalog getInstance() {
		if (session == null)
			session = new UserCatalog();
		return session;
	}

	public boolean login(String userName, String password) {
		HibernateUtil.getCurrentSession().beginTransaction();

		UserEntity entity = FactoryDAO.getInstance().getUserDao()
				.isValid(userName, password);
		HibernateUtil.commitTransaction();
		if (entity == null)
			return false;
		logginedUser = new UserController(entity);
		return true;

	}

	public ArrayList<Integer> getRolesOfLoggedInUser() {

		if (logginedUser == null) {
			ArrayList<Integer> roles = new ArrayList<Integer>();
			roles.add(22);
			roles.add(20);
			return roles;
		} else {
			return logginedUser.getButtons();
		}
	}

	public String getFullNameOfLoggedInUser() {
		if (logginedUser == null)
			return "";
		return logginedUser.getFullname();
	}

}
