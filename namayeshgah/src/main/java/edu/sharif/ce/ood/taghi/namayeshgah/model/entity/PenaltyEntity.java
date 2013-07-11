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
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
