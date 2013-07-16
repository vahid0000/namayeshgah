package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;

public class ProcessCatalog {

	private static ProcessCatalog session;

	private ProcessCatalog() {
	};

	public static ProcessCatalog getInstance() {
		if (session == null)
			session = new ProcessCatalog();
		return session;
	}

	public List<ProcessBean> getAllProcesses() {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<ProcessBean> processes = FactoryDAO.getInstance().getProcessDao()
				.getAllProcesses();
		HibernateUtil.commitTransaction();
		return processes;
	}

}
