package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.NewsBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PeopleReportBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PhoneBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PrivateNewsBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.NewsEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;

public class ReportCatalog {

	private static ReportCatalog session;

	private ReportCatalog() {
	};

	public static ReportCatalog getInstance() {
		if (session == null)
			session = new ReportCatalog();
		return session;
	}

	public List<PeopleReportBean> getReportsByShowPlace(
			ShowPlaceBean currentShowPlaceBean) {
		HibernateUtil.getCurrentSession().beginTransaction();
		ShowPlaceEntity showPlace = FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(currentShowPlaceBean);
		List<PeopleReportEntity> entities = FactoryDAO.getInstance()
				.getReportDao().getPeopleReportsByShowPlace(showPlace);
		ArrayList<PeopleReportBean> reports = new ArrayList<PeopleReportBean>();
		for (PeopleReportEntity entity : entities) {
			reports.add(new PeopleReportBean(entity));
		}

		HibernateUtil.commitTransaction();
		return reports;
	}

	public void addNewPeopleReport(String name, String detail,
			ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO
				.getInstance()
				.getReportDao()
				.addPeopleReport(
						name,
						detail,
						FactoryDAO.getInstance().getShowPlaceDao()
								.findByShowPlaceBean(showPlace));
		HibernateUtil.commitTransaction();

	}
}
