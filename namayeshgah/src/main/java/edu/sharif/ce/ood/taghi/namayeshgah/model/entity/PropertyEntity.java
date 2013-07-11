package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PropertyStatus;


@Entity(name="Property")
public class PropertyEntity extends BaseEntity<Integer> {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "propertyStatus")
	private PropertyStatus propertyStatus;

	
	
	
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

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id=id;

	}

}
