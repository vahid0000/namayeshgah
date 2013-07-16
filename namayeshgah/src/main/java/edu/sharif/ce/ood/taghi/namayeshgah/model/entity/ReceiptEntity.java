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

	@Column(name = "lastDateStatusChange")
	private Date lastDateStatusChange;

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
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id=id;

	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ReceiptStatus getReceiptStatus() {
		return receiptStatus;
	}

	public void setReceiptStatus(ReceiptStatus receiptStatus) {
		this.receiptStatus = receiptStatus;
	}

	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
	}

	public Date getLastDateStatusChange() {
		return lastDateStatusChange;
	}

	public void setLastDateStatusChange(Date lastDateStatusChange) {
		this.lastDateStatusChange = lastDateStatusChange;
	}
	
	
	
	

}
