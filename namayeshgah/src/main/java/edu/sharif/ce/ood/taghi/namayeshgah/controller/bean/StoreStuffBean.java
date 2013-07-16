package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.Date;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.CalendarTool;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.StoreStuffStatus;

public class StoreStuffBean {

	private Integer id;
	private String name;
	private Date lastStatusChange;
	private StoreStuffStatus status;
	private ShowPlaceBean showPlaceBean;

	public StoreStuffBean(StoreStuffEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.lastStatusChange = entity.getLastDateStatusChange();
		this.status = entity.getStoreStuffStatus();
		this.showPlaceBean = new ShowPlaceBean(entity.getShowPlace());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastStatusChange() {
		return lastStatusChange;
	}

	public void setLastStatusChange(Date lastStatusChange) {
		this.lastStatusChange = lastStatusChange;
	}

	public StoreStuffStatus getStatus() {
		return status;
	}

	public void setStatus(StoreStuffStatus status) {

		this.status = status;
		HibernateUtil.getCurrentSession().beginTransaction();
		StoreStuffEntity entity = FactoryDAO.getInstance().getStoreDao()
				.findById(this.id, false);
		entity.setStoreStuffStatus(status);
		FactoryDAO.getInstance().getStoreDao().makePersistent(entity);
		HibernateUtil.commitTransaction();
	}

	public ShowPlaceBean getShowPlaceBean() {
		return showPlaceBean;
	}

	public void setShowPlaceBean(ShowPlaceBean showPlaceBean) {
		this.showPlaceBean = showPlaceBean;
	}

	@Override
	public String toString() {
		CalendarTool ct = new CalendarTool(this.lastStatusChange);
		return (this.name + " " + "آخرین وضعیت:" + this.status.persianName()
				+ " " + "تاریخ:" + ct.getIranianDate());
	}
}
