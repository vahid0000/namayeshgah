package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.Date;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.CalendarTool;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ReceiptEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.StoreStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ReceiptStatus;

public class ReceiptBean {

	private Integer id;
	private Double number;
	private String description;
	private ReceiptStatus status;
	private Date lastDateOfStatusChanged;
	private ShowPlaceBean showPlaceBean;

	public ReceiptBean(ReceiptEntity entity) {
		this.id = entity.getId();
		this.number = entity.getPrice();
		this.description = entity.getDescription();
		this.status = entity.getReceiptStatus();
		this.lastDateOfStatusChanged = entity.getLastDateStatusChange();
		this.showPlaceBean = new ShowPlaceBean(entity.getShowPlace());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReceiptStatus getStatus() {
		return status;
	}

	public void setStatus(ReceiptStatus status) {
		this.status = status;
		HibernateUtil.getCurrentSession().beginTransaction();
		ReceiptEntity entity = FactoryDAO.getInstance().getFinancialDao()
				.findById(this.id, false);
		entity.setReceiptStatus(status);
		FactoryDAO.getInstance().getFinancialDao().makePersistent(entity);
		HibernateUtil.commitTransaction();
	}

	public Date getLastDateOfStatusChanged() {
		return lastDateOfStatusChanged;
	}

	public void setLastDateOfStatusChanged(Date lastDateOfStatusChanged) {
		this.lastDateOfStatusChanged = lastDateOfStatusChanged;
	}

	public ShowPlaceBean getShowPlaceBean() {
		return showPlaceBean;
	}

	public void setShowPlaceBean(ShowPlaceBean showPlaceBean) {
		this.showPlaceBean = showPlaceBean;
	}

	@Override
	public String toString() {
		CalendarTool ct = new CalendarTool(this.lastDateOfStatusChanged);
		return (this.id + " " + "آخرین وضعیت:" + this.status.persianName()
				+ " " + "تاریخ:" + ct.getIranianDate());
	}

}
