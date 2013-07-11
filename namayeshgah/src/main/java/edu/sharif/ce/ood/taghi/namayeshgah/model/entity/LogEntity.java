package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="log")
public class LogEntity extends BaseEntity<Integer> {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "date")
	private Date date;
	
	@Column(name = "description")
	private String description;

	
	
	
	
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
