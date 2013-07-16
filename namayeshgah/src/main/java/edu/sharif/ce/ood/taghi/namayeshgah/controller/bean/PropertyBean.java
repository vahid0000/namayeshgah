package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PropertyStatus;

public class PropertyBean {

	private Integer id;
	private String subject;
	private String description;
	private PropertyStatus propertyStatus;

	public PropertyBean(PropertyEntity propertyEntity) {
		this.id = propertyEntity.getId();
		this.subject = propertyEntity.getSubject();
		this.description = propertyEntity.getDescription();
		this.propertyStatus = propertyEntity.getPropertyStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PropertyStatus getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(PropertyStatus propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

}
