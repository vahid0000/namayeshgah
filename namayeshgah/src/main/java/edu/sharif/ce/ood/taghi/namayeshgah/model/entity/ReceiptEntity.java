package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ReceiptStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.StoreStuffStatus;


@Entity(name="receipt")
public class ReceiptEntity extends BaseEntity<Integer> {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "subject")
	private String subject;
	
	@Column(name = "description")
	private String description;

	@Column(name = "price")
	private Double price;

	@Column(name = "receiptStatus")
	private ReceiptStatus receiptStatus;

	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	@Override
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id=id;

	}

}
