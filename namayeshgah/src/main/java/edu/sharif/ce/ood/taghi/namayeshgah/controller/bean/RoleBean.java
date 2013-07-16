package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;

public class RoleBean {

	private Integer id;
	private String name;
	private Integer number;

	public RoleBean(RoleEntity role) {
		this.id = role.getId();
		this.number = role.getConstRoleEntity().getNumber();
		this.number = role.getConstRoleEntity().getNumber();
	}

	public RoleBean(String name, Integer number) {
		super();
		this.name = name;
		this.number = number;
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

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

}
