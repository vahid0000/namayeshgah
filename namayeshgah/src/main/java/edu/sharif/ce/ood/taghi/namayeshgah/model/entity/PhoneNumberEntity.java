package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PhoneNumberStatus;

@Entity(name = "phoneNumber")
public class PhoneNumberEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "number")
	private Integer number;
	@Column(name = "phoneNumberStatus")
	private PhoneNumberStatus phoneNumberStatus;
	@ManyToOne
	@JoinColumn(name = "newsEntity")
	private NewsEntity news;

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
