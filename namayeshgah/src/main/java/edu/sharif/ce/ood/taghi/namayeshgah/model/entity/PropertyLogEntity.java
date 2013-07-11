package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "propertyLog")
public class PropertyLogEntity extends LogEntity {

	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
	}
	
	

}
