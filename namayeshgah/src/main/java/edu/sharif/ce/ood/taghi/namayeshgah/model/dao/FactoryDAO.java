package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;

public class FactoryDAO {

	private FactoryDAO() {
	}

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

	public ProcessDao getProcessDao() {
		return (ProcessDao) instantiateDAO(ProcessDao.class);
	}

	public RoleDao getRoleDao() {
		return (RoleDao) instantiateDAO(RoleDao.class);
	}

	public ConstRoleDao getConstRoleDao() {
		return (ConstRoleDao) instantiateDAO(ConstRoleDao.class);
	}

	public ProcessLogDao getProcessLogDao() {
		return (ProcessLogDao) instantiateDAO(ProcessLogDao.class);
	}

	public PropertyDao getPropertyDao() {
		return (PropertyDao) instantiateDAO(PropertyDao.class);
	}

	public PropertyLogDao getPropertyLogDao() {
		return (PropertyLogDao) instantiateDAO(PropertyLogDao.class);
	}

	public NewsDao getNewsDao() {
		return (NewsDao) instantiateDAO(NewsDao.class);
	}

	public FileDao getFileDao() {
		return (FileDao) instantiateDAO(FileDao.class);
	}

	public PhoneNumberDao getPhoneNumberDao() {
		return (PhoneNumberDao) instantiateDAO(PhoneNumberDao.class);
	}

	public RequestDao getRequestDao() {
		return (RequestDao) instantiateDAO(RequestDao.class);
	}

	public BoothDao getBoothDao() {
		return (BoothDao) instantiateDAO(BoothDao.class);
	}

	public PenaltyDao getPenaltyDao() {
		return (PenaltyDao) instantiateDAO(PenaltyDao.class);
	}

	public StoreDao getStoreDao() {
		return (StoreDao) instantiateDAO(StoreDao.class);
	}

	public FinancialDao getFinancialDao() {
		return (FinancialDao) instantiateDAO(FinancialDao.class);
	}

	public PostDao getPostDao() {
		return (PostDao) instantiateDAO(PostDao.class);
	}

	public ReportDao getReportDao() {
		return (ReportDao) instantiateDAO(ReportDao.class);
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
