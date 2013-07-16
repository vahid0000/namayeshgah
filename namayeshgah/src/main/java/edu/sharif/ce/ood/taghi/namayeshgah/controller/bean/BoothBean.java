package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.BoothDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.BoothStatus;

public class BoothBean {

	private Integer saloon;
	private Integer number;
	private BoothStatus boothStatus;
	private String builder;
	private Integer id;

	public BoothBean(BoothEntity boothEntity) {
		this.id = boothEntity.getId();
		this.saloon = boothEntity.getSaloon();
		this.number = boothEntity.getNumber();
		this.boothStatus = boothEntity.getBoothStatus();
		this.builder = boothEntity.getBuilder();
	}

	public Integer getSaloon() {
		return saloon;
	}

	public void setSaloon(Integer saloon) {
		this.saloon = saloon;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BoothStatus getBoothStatus() {
		return boothStatus;
	}

	public void setBoothStatus(BoothStatus boothStatus) {
		this.boothStatus = boothStatus;
		HibernateUtil.getCurrentSession().beginTransaction();
		BoothEntity booth = FactoryDAO.getInstance().getBoothDao()
				.findById(this.id, false);
		booth.setBoothStatus(boothStatus);
		FactoryDAO.getInstance().getBoothDao().makePersistent(booth);
		HibernateUtil.commitTransaction();
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	@Override
	public String toString() {

		return ("(" + this.saloon + "," + this.number + ") " + "وضعیت: " + this.boothStatus
				.persianName());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void addPenalty(String description) {
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO.getInstance().getPenaltyDao().addPenalty(description, this);
		HibernateUtil.commitTransaction();
	}
}
