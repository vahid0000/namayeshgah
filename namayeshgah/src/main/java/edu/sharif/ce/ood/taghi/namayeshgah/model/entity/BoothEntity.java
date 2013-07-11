package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.BoothStatus;

@Entity(name = "booth")
public class BoothEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "saloon")
	private Integer saloon;

	@Column(name = "number")
	private Integer number;

	@Column(name = "boothStatus")
	private BoothStatus boothStatus;

	@Column(name = "builder")
	private String builder;

	@ManyToOne
	@JoinColumn(name = "owner")
	private UserEntity owner;

	@OneToMany(mappedBy = "booth")
	private List<BoothLogEntity> logs;

	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	@OneToMany(mappedBy = "booth")
	private List<PenaltyEntity> penalties;

	public ShowPlaceEntity getShowplace() {
		return showPlace;
	}

	public void setShowplace(ShowPlaceEntity showplace) {
		this.showPlace = showplace;
	}

	public List<BoothLogEntity> getLogs() {
		return logs;
	}

	public void setLogs(List<BoothLogEntity> logs) {
		this.logs = logs;
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
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public UserEntity getOwner() {
		return owner;
	}

	public void setOwner(UserEntity owner) {
		this.owner = owner;
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
