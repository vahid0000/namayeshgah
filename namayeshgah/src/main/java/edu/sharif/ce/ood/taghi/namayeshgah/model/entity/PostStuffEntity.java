package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.PostStuffStatus;


@Entity(name="postStuff")
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

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id=id;

	}

}
