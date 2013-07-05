package edu.sharif.ce.ood.taghi.namayeshgah;

import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.GenericHibernateDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

	private static SessionFactory factory;

	public static Configuration getInitializedConfiguration() {
		Configuration config = new Configuration();
		config.configure();
		return config;
	}

	@SuppressWarnings("deprecation")
	public static Session getCurrentSession() {
		if (factory == null) {
			Configuration config = HibernateUtil.getInitializedConfiguration();
			factory = config.buildSessionFactory();
		}
		Session hibernateSession = factory.getCurrentSession();
		return hibernateSession;
	}

	public static void closeSession() {
		HibernateUtil.getCurrentSession().close();
	}

	public static void recreateDatabase() {
		Configuration config;
		config = HibernateUtil.getInitializedConfiguration();
		new SchemaExport(config).create(true, true);
	}

	public static Session beginTransaction() {
		Session hibernateSession;
		hibernateSession = HibernateUtil.getCurrentSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getCurrentSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtil.getCurrentSession().getTransaction().rollback();
	}


}