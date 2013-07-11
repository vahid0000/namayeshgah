package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "news")
public class NewsEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "subject")
	private String subject;
	@Column(name = "description")
	private String description;
	@Column(name = "isPublic")
	private boolean isPublic;

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
