package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.ProcessLogDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessLogEntity;

public class LogCatalog {

	private static LogCatalog session;

	private LogCatalog() {
	};

	public static LogCatalog getInstance() {
		if (session == null)
			session = new LogCatalog();
		return session;
	}

	public List<String> getAllProcessLogByShowPlace(ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<ProcessLogEntity> logEntities = FactoryDAO.getInstance()
				.getProcessLogDao().getAllProcessLogs(showPlace);
		ArrayList<String> logs = new ArrayList<String>();
		for (ProcessLogEntity log : logEntities) {
			CalendarTool calendarTool = new CalendarTool(log.getDate()
					.getYear(), log.getDate().getMonth(), log.getDate()
					.getDay());
			logs.add(calendarTool.getIranianDate() + ":" + log.getDescription());
		}

		HibernateUtil.commitTransaction();
		return logs;

	}
}
