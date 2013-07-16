package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PhoneNumberEntity;

public class PrivateNewsBean {

	private String description;
	private List<PhoneBean> phones;

	public PrivateNewsBean(String description, List<PhoneNumberEntity> phones) {
		this.description = description;
		this.phones = new ArrayList<PhoneBean>();
		for (PhoneNumberEntity phone : phones) {
			this.phones.add(new PhoneBean(phone));
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<PhoneBean> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneBean> phones) {
		this.phones = phones;
	}
	
	
}
