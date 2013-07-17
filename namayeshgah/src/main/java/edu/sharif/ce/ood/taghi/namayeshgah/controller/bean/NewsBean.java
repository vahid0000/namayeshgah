package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.NewsEntity;

public class NewsBean {

	private String subject;
	private String detail;

	public String getSubject() {
		return subject;
	}

	public NewsBean(NewsEntity news) {
		super();
		this.subject = news.getSubject();
		this.detail = news.getDescription();
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
