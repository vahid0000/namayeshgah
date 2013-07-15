package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;

public class ShowPlaceBean {

	private Integer id;
	private String name;

	public ShowPlaceBean(ShowPlaceEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
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

	@Override
	public String toString() {
		return this.name;
	}

	public ShowPlaceBean(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
