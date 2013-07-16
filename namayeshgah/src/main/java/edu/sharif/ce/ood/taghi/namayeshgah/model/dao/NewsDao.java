package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PhoneBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PrivateNewsBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.NewsEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PhoneNumberEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PhoneNumberStatus;

public class NewsDao extends GenericHibernateDAO<NewsEntity, Integer> {
	public void addNews(String subject, boolean isPublic, String description,
			String files, ShowPlaceBean currentShowPlace) {
		NewsEntity news = new NewsEntity();
		news.setPublic(isPublic);
		news.setDescription(description);
		news.setSubject(subject);
		news.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findById(currentShowPlace.getId(), false));
		this.makePersistent(news);
		// for (String address : files)
		FactoryDAO.getInstance().getFileDao().addFile(files, news);
		System.out.println("NewsDao/addNews/ news.id=" + news.getId());
	}

	public void addPrivateNews(String text, ArrayList<PhoneBean> phones,
			ShowPlaceBean currentShowPlace) {
		
		NewsEntity news = new NewsEntity();
		news.setPublic(false);
		news.setDescription(text);
		news.setSubject("");
		news.setShowPlace(FactoryDAO.getInstance().getShowPlaceDao()
				.findById(currentShowPlace.getId(), false));
		this.makePersistent(news);

		for (PhoneBean phone : phones) {
			PhoneNumberEntity entity = new PhoneNumberEntity();
			entity.setNews(news);
			entity.setName(phone.getName());
			entity.setNumber(phone.getPhoneNumber());
			entity.setPhoneNumberStatus(PhoneNumberStatus.undone);
			FactoryDAO.getInstance().getPhoneNumberDao().makePersistent(entity);
		}

	}
	


	public PrivateNewsBean getAllPrivateNewsByShowPlace(ShowPlaceBean showPlace) {
		ShowPlaceEntity showPlaceEntity = FactoryDAO.getInstance()
				.getShowPlaceDao().findById(showPlace.getId(), false);
		DetachedCriteria criteria = DetachedCriteria.forClass(NewsEntity.class);
		criteria.add(Restrictions.eq("showPlace", showPlaceEntity));
		List<NewsEntity> entities = this.findByDetachedCriteria(criteria);
		if (entities.size() < 1)
			return null;
		NewsEntity entity = entities.get(0);
		List<PhoneNumberEntity> phones = FactoryDAO.getInstance()
				.getPhoneNumberDao().getAllPhonesByNews(entity);
		System.out.println("newsDao/getAllPrivateNewsByShowPlace/ phones.size:"
				+ phones.size());
		PrivateNewsBean news = new PrivateNewsBean(entity.getDescription(),
				phones);
		return news;
	}
}
