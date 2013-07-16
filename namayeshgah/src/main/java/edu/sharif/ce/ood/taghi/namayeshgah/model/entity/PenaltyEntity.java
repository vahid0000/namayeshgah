package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PenaltyStatus;

@Entity(name = "penalty")
public class PenaltyEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "description")
	private String description;

	@Column(name = "lastStatus")
	private PenaltyStatus lastStatus;

	@ManyToOne
	@JoinColumn(name = "booth")
	private BoothEntity booth;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PenaltyStatus getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(PenaltyStatus lastStatus) {
		this.lastStatus = lastStatus;
	}

	public BoothEntity getBooth() {
		return booth;
	}

	public void setBooth(BoothEntity booth) {
		this.booth = booth;
	}

}
