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
	private String number;
	@Column(name = "name")
	private String name;
	@Column(name = "phoneNumberStatus")
	private PhoneNumberStatus phoneNumberStatus;
	@ManyToOne
	@JoinColumn(name = "newsEntity")
	private NewsEntity news;

	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneNumberStatus getPhoneNumberStatus() {
		return phoneNumberStatus;
	}

	public void setPhoneNumberStatus(PhoneNumberStatus phoneNumberStatus) {
		this.phoneNumberStatus = phoneNumberStatus;
	}

	public NewsEntity getNews() {
		return news;
	}

	public void setNews(NewsEntity news) {
		this.news = news;
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
