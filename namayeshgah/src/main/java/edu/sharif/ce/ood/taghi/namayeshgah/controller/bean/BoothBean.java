package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.BoothStatus;

public class BoothBean {

	private Integer saloon;
	private Integer number;
	private BoothStatus boothStatus;
	private String builder;

	public BoothBean(BoothEntity boothEntity) {
		this.saloon = boothEntity.getSaloon();
		this.number = boothEntity.getNumber();
		this.boothStatus = boothEntity.getBoothStatus();
		this.builder = boothEntity.getBuilder();
	}

	public Integer getSaloon() {
		return saloon;
	}

	public void setSaloon(Integer saloon) {
		this.saloon = saloon;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public BoothStatus getBoothStatus() {
		return boothStatus;
	}

	public void setBoothStatus(BoothStatus boothStatus) {
		this.boothStatus = boothStatus;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

}
