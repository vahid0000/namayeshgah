package edu.sharif.ce.ood.taghi.namayeshgah.controller;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PostStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ReceiptBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.StoreStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PostStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ReceiptEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;

public class PostCatalog {

	private static PostCatalog session;

	private PostCatalog() {
	};

	public static PostCatalog getInstance() {
		if (session == null)
			session = new PostCatalog();
		return session;
	}

	// public void addStuff(Double number,String description, ShowPlaceBean
	// showPlace) {
	// HibernateUtil.getCurrentSession().beginTransaction();
	// FactoryDAO.getInstance().getFinancialDao().addReceipt(number,description,
	// showPlace);
	// HibernateUtil.commitTransaction();
	// }

	public List<PostStuffBean> getAllPostStuffs(ShowPlaceBean currentShowPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<PostStuffEntity> entities = FactoryDAO.getInstance().getPostDao()
				.findByShowPlace(currentShowPlace);
		ArrayList<PostStuffBean> stuffs = new ArrayList<PostStuffBean>();
		for (PostStuffEntity entity : entities) {
			stuffs.add(new PostStuffBean(entity));
		}
		HibernateUtil.commitTransaction();
		return stuffs;
	}

	public void addStuff(String text, String text2, String text3,
			ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();

		FactoryDAO
				.getInstance()
				.getPostDao()
				.addStuff(
						text,
						text2,
						text3,
						FactoryDAO.getInstance().getShowPlaceDao()
								.findByShowPlaceBean(showPlace));
		HibernateUtil.commitTransaction();

	}
}
