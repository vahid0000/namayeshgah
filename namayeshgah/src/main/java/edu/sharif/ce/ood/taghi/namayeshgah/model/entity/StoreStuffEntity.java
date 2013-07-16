package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PostStuffStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.StoreStuffStatus;

@Entity(name = "storeStuff")
public class StoreStuffEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastDateStatusChange")
	private Date lastDateStatusChange;

	@Column(name = "storeStuffStatus")
	private StoreStuffStatus storeStuffStatus;

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

	public Date getLastDateStatusChange() {
		return lastDateStatusChange;
	}

	public void setLastDateStatusChange(Date lastDateStatusChange) {
		this.lastDateStatusChange = lastDateStatusChange;
	}

	public StoreStuffStatus getStoreStuffStatus() {
		return storeStuffStatus;
	}

	public void setStoreStuffStatus(StoreStuffStatus storeStuffStatus) {
		this.storeStuffStatus = storeStuffStatus;
	}

	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
	}

}
