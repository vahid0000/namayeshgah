package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RequestBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RequestEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.RequestStatus;

public class RequestDao extends GenericHibernateDAO<RequestEntity, Integer> {

	public void addNewRequest(String subject, String description,
			ShowPlaceBean currentShowPlace) {
		System.out.println("RequestDao/addNewRequest/ currentshowPlace:"
				+ currentShowPlace.getId());
		RequestEntity request = new RequestEntity();
		request.setDescription(description);
		request.setSubject(subject);
		ShowPlaceEntity showPlace = FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(currentShowPlace);
		request.setShowPlace(showPlace);
		request.setRequestStatus(RequestStatus.nonAnswered);
		this.makePersistent(request);
	}

	public void setAnswerByBean(RequestBean requestBean) {
		RequestEntity entity = this.findById(requestBean.getId(), false);
		entity.setReplay(requestBean.getReply());
		entity.setRequestStatus(RequestStatus.answered);
		this.makePersistent(entity);

	}
}
