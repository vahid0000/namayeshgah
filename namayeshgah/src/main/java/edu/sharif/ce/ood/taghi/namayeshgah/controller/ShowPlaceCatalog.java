package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class ShowPlaceCatalog {
	private static ShowPlaceCatalog session;
	private ShowPlaceBean currentShowPlace;

	private ShowPlaceCatalog() {
	};

	public static ShowPlaceCatalog getInstance() {
		if (session == null)
			session = new ShowPlaceCatalog();
		return session;
	}

	public void addShowPlace(String name, String defSummary, String definition,
			String owner, List<String> groupManager) {
		HibernateUtil.getCurrentSession().beginTransaction();
		ShowPlaceEntity entity = FactoryDAO
				.getInstance()
				.getShowPlaceDao()
				.addShowPlace(name, defSummary, definition, owner, groupManager);
		HibernateUtil.commitTransaction();
	}

	public List<ShowPlaceBean> getAllShowPlaces() {
		ArrayList<ShowPlaceBean> showPlaces = new ArrayList<ShowPlaceBean>();
		HibernateUtil.getCurrentSession().beginTransaction();
		List<ShowPlaceEntity> entities = FactoryDAO.getInstance()
				.getShowPlaceDao().findAll();

		for (ShowPlaceEntity entity : entities) {
			showPlaces.add(new ShowPlaceBean(entity));
		}
		HibernateUtil.commitTransaction();
		return showPlaces;
	}

	public ShowPlaceBean getCurrentShowPlace() {
		return currentShowPlace;
	}

	public void setCurrentShowPlace(ShowPlaceBean currentShowPlace) {
		this.currentShowPlace = currentShowPlace;
	}

	public void addNewRequest(String subject, String description,
			ShowPlaceBean currentShowPlace) {

		HibernateUtil.getCurrentSession().beginTransaction();

		FactoryDAO.getInstance().getRequestDao()
				.addNewRequest(subject, description, currentShowPlace);
		HibernateUtil.commitTransaction();

	}

}
