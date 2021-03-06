package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PeopleReportStatus;

@Entity(name = "peopleReport")
public class PeopleReportEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "phoneNumber")
	private String phoneNumber;
	@Column(name = "peopleReportStatus")
	private PeopleReportStatus peopleReportStatus;

	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
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
