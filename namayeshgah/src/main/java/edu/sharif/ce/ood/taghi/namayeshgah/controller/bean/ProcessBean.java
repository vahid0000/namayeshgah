package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ProcessStatus;

public class ProcessBean {
	private Integer id;

	private String name;
	private String description;
	private ProcessStatus processStatus;

	public ProcessBean(ProcessEntity processEntity) {
		this.id = processEntity.getId();
		this.name = processEntity.getName();
		this.description = processEntity.getDescription();
		this.processStatus = processEntity.getProcessStatus();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProcessStatus getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(ProcessStatus processStatus) {
		this.processStatus = processStatus;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
