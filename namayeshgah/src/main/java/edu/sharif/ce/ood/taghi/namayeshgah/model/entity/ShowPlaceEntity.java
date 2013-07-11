package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ImplementationStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PeopleReportStatus;

@Entity(name = "showPlace")
public class ShowPlaceEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "implementationStatus")
	private ImplementationStatus implementationStatus;

	@OneToMany(mappedBy = "showPlace")
	private List<BoothEntity> boothes;
	
	@OneToMany(mappedBy = "showPlace")
	private List<PeopleReportEntity> peopleReports;

	@ManyToMany
	@OrderColumn(name = "processes")
	private List<ProcessEntity> processes;

	@ManyToMany
	@OrderColumn(name = "properties")
	private List<PropertyEntity> properties;

	// @ManyToMany
	// @OrderColumn(name="users")
	// private UserEntity[] users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ImplementationStatus getImplementationStatus() {
		return implementationStatus;
	}

	public void setImplementationStatus(
			ImplementationStatus implementationStatus) {
		this.implementationStatus = implementationStatus;
	}

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
