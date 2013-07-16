package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PeopleReportStatus;

public class PeopleReportBean {

	private Integer id;

	private String name;
	private String description;
	private String phoneNumber;
	private PeopleReportStatus peopleReportStatus;
	private ShowPlaceEntity showPlace;

	public PeopleReportBean(PeopleReportEntity entity) {
		this.name = entity.getName();
		this.id = entity.getId();
		this.description = entity.getDescription();
		this.phoneNumber = entity.getPhoneNumber();
		this.peopleReportStatus = entity.getPeopleReportStatus();
		this.showPlace = entity.getShowPlace();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public PeopleReportStatus getPeopleReportStatus() {
		return peopleReportStatus;
	}

	public void setPeopleReportStatus(PeopleReportStatus peopleReportStatus) {
		this.peopleReportStatus = peopleReportStatus;
	}

	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
	}

}
