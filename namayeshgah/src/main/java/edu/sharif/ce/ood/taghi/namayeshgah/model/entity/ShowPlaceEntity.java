package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.List;
import java.util.Set;

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
//	 List<String> groupManager
	@Column(name = "name")
	private String name;
	
	@Column(name = "defSummary")
	private String defSummary;
	
	@Column(name = "definition")
	private String definition;
	
	@Column(name = "owner")
	private String owner;

	@Column(name = "implementationStatus")
	private ImplementationStatus implementationStatus;

	@OneToMany(mappedBy = "showPlace")
	private List<BoothEntity> boothes;
	
	@OneToMany(mappedBy = "showPlace")
	private List<PeopleReportEntity> peopleReports;
	@OneToMany(mappedBy = "showPlace")
	private List<RequestEntity> requests;

	@ManyToMany
	@OrderColumn(name = "processes")
	private List<ProcessEntity> processes;

	@ManyToMany
	@OrderColumn(name = "properties")
	private List<PropertyEntity> properties;

	@ManyToMany()
	@OrderColumn(name="users")
	private Set<UserEntity> users;

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
	
	

	public String getDefSummary() {
		return defSummary;
	}

	public void setDefSummary(String defSummary) {
		this.defSummary = defSummary;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<BoothEntity> getBoothes() {
		return boothes;
	}

	public void setBoothes(List<BoothEntity> boothes) {
		this.boothes = boothes;
	}

	public List<PeopleReportEntity> getPeopleReports() {
		return peopleReports;
	}

	public void setPeopleReports(List<PeopleReportEntity> peopleReports) {
		this.peopleReports = peopleReports;
	}

	public List<ProcessEntity> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessEntity> processes) {
		this.processes = processes;
	}

	public List<PropertyEntity> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyEntity> properties) {
		this.properties = properties;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
	
	

	public List<RequestEntity> getRequests() {
		return requests;
	}

	public void setRequests(List<RequestEntity> requests) {
		this.requests = requests;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

}
