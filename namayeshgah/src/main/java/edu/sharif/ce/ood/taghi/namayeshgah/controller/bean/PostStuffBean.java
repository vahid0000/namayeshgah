package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import javax.persistence.Column;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PostStuffEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PostStuffStatus;

public class PostStuffBean {

	private String name;
	private String destination;
	private String sender;
	private PostStuffStatus postStuffStatus;

	public PostStuffBean(PostStuffEntity entity) {
		super();
		this.name = entity.getName();
		this.destination = entity.getDestination();
		this.sender = entity.getSender();
		this.postStuffStatus = entity.getPostStuffStatus();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public PostStuffStatus getPostStuffStatus() {
		return postStuffStatus;
	}

	public void setPostStuffStatus(PostStuffStatus postStuffStatus) {
		this.postStuffStatus = postStuffStatus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.sender + " " + this.destination;
	}
}
