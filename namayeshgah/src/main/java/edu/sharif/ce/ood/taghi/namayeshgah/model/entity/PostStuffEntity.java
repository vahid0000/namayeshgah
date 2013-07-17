package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PostStuffStatus;

@Entity(name = "postStuff")
public class PostStuffEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;
	@Column(name = "destination")
	private String destination;
	@Column(name = "sender")
	private String sender;
	@Column(name = "postStuffStatus")
	private PostStuffStatus postStuffStatus;
	
	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

	
	
	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
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

}
