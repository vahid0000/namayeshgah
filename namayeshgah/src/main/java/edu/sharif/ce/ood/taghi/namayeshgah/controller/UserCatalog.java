package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

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

	public List<String> getAllUsers() {
		HibernateUtil.getCurrentSession().beginTransaction();
		System.out.println("UserCatalog: allUsers");
		List<String> users = FactoryDAO.getInstance().getUserDao().getAllUser();
		HibernateUtil.commitTransaction();
		return users;

	}

	public ArrayList<Integer> getRolesOfLoggedInUser() {

		if (logginedUser == null) {
			ArrayList<Integer> roles = new ArrayList<Integer>();
			roles.add(22);
			roles.add(20);
			roles.add(24);
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
