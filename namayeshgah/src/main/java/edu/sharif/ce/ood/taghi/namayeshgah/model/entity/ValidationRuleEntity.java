package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

@Entity(name = "validationRule")
public class ValidationRuleEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;

	@ManyToMany
	@OrderColumn(name = "property1")
	private List<PropertyEntity> property1;
	@ManyToMany
	@OrderColumn(name = "property2")
	private List<PropertyEntity> property2;

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
