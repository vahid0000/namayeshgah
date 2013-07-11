package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "file")
public class FilesEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "address")
	private String address;
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
