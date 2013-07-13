package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

public class ShowPlaceCatalog {
	private static ShowPlaceCatalog session;
	
	private ShowPlaceCatalog() {
	};

	public static ShowPlaceCatalog getInstance() {
		if (session == null)
			session = new ShowPlaceCatalog();
		return session;
	}
	
	public void addShowPlace(String name, String defSummary, String definition, String owner, List<String> groupManager){
		HibernateUtil.getCurrentSession().beginTransaction();
		ArrayList<UserEntity> users= new ArrayList<UserEntity>();
		ShowPlaceEntity entity = FactoryDAO.getInstance().getShowPlaceDao()
				.addShowPlace(name, defSummary, definition, owner, groupManager);
		HibernateUtil.commitTransaction();
	}
	
	

}
