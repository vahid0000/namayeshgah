package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ProcessStatus;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.RequestStatus;

@Entity(name = "process")
public class ProcessEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "processStatus")
	private ProcessStatus processStatus;

	
	
	
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
	Integer getId() {
		return id;
	}

	@Override
	void setId(Integer id) {
		this.id = id;

	}

}
