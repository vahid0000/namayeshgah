package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.BoothBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RequestBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PenaltyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RequestEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PenaltyStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.RequestStatus;

public class PenaltyDao extends GenericHibernateDAO<PenaltyEntity, Integer> {

	public void addPenalty(String description, BoothBean booth) {
		PenaltyEntity penalty = new PenaltyEntity();
		penalty.setBooth(FactoryDAO.getInstance().getBoothDao()
				.findById(booth.getId(), false));
		penalty.setDescription(description);
		penalty.setLastStatus(PenaltyStatus.newAdded);
		this.makePersistent(penalty);
	}

}
