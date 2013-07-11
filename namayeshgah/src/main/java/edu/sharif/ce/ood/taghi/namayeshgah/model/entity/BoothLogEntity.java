package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "boothLog")
public class BoothLogEntity extends LogEntity {

	@ManyToOne
	@JoinColumn(name = "booth")
	private BoothEntity booth;

	public BoothEntity getBooth() {
		return booth;
	}

	public void setBooth(BoothEntity booth) {
		this.booth = booth;
	}

	
	
}
