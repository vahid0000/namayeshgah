package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "questionEntity")
public class QuestionEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "question")
	private String question;

	@Column(name = "resultBad")
	private Integer resultBad;
	@Column(name = "resultNotBad")
	private Integer resultNotBad;
	@Column(name = "resultGood")
	private Integer resultGood;
	@Column(name = "resultVeryGood")
	private Integer resultVeryGood;

	@ManyToOne
	@JoinColumn(name = "poll")
	private PollEntity poll;

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
