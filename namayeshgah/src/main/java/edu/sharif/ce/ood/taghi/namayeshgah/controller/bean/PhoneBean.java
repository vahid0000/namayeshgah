package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PhoneNumberEntity;

public class PhoneBean {

	private Integer id;
	private String name;
	private String phoneNumber;
	

	public PhoneBean(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public PhoneBean(PhoneNumberEntity phone) {
		this.name = phone.getName();
		this.phoneNumber = phone.getNumber();
		this.id = phone.getId();
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
