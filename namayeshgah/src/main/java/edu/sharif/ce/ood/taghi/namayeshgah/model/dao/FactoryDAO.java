package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;

public class FactoryDAO {
	
	private FactoryDAO(){}

	private static FactoryDAO factoryDAO;

	public static FactoryDAO getInstance() {
		if (factoryDAO == null)
			factoryDAO = new FactoryDAO();
		return factoryDAO;
	}
	
	public UserDao getUserDao() {
		return (UserDao) instantiateDAO(UserDao.class);	
	}
	
	public ShowPlaceDao getShowPlaceDao() {
		return (ShowPlaceDao) instantiateDAO(ShowPlaceDao.class);	
	}

	private GenericHibernateDAO instantiateDAO(Class daoClass) {
		try {
			GenericHibernateDAO dao = (GenericHibernateDAO) daoClass
					.newInstance();
			dao.setSession(HibernateUtil.getCurrentSession());
			return dao;
		} catch (Exception ex) {
			throw new RuntimeException("Can not instantiate DAO: " + daoClass,
					ex);
		}
	}

}
