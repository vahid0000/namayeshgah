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
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
