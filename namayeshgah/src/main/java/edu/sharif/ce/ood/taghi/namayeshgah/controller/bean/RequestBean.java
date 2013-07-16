package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import javax.persistence.EnumType;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RequestEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.RequestStatus;

public class RequestBean {
	private Integer id;
	private String subject;
	private String description;
	private String reply;
	private RequestStatus status;

	public RequestBean(RequestEntity entity) {
		super();
		this.id = entity.getId();
		this.subject = entity.getSubject();
		this.description = entity.getDescription();
		this.reply = entity.getReplay();
		this.status = entity.getRequestStatus();
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		HibernateUtil.getCurrentSession().beginTransaction();
		this.reply = reply;
		FactoryDAO.getInstance().getRequestDao().setAnswerByBean(this);
		HibernateUtil.commitTransaction();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		if (this.status.equals(RequestStatus.nonAnswered))
			return (this.subject + " " + "بدون پاسخ");
		else
			return (this.subject + " جواب:" + this.reply);
	}

}
