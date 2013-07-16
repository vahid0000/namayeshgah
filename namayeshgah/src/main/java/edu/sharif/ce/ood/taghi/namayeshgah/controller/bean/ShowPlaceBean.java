package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.ShowPlaceDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ImplementationStatus;

public class ShowPlaceBean {

	private Integer id;
	private String name;
	private String defSummary;
	private String definition;
	private String owner;
	private ImplementationStatus implementationStatus;
	private List<BoothBean> boothes;
	private List<PeopleReportBean> peopleReports;
	private List<ProcessBean> processes;
	private List<PropertyBean> properties;
	private Set<UserBean> users;

	public ShowPlaceBean(ShowPlaceEntity entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.defSummary = entity.getDefSummary();
		this.definition = entity.getDefinition();
		this.owner = entity.getOwner();
		this.implementationStatus = entity.getImplementationStatus();
		boothes = new ArrayList<BoothBean>();
		for (BoothEntity boothEntity : entity.getBoothes()) {
			this.boothes.add(new BoothBean(boothEntity));
		}

		peopleReports = new ArrayList<PeopleReportBean>();
		for (PeopleReportEntity reportEntity : entity.getPeopleReports()) {
			this.peopleReports.add(new PeopleReportBean(reportEntity));
		}
		processes = new ArrayList<ProcessBean>();
		for (ProcessEntity processEntity : entity.getProcesses()) {
			this.processes.add(new ProcessBean(processEntity));
		}
		properties = new ArrayList<PropertyBean>();
		for (PropertyEntity propEntity : entity.getProperties()) {
			this.properties.add(new PropertyBean(propEntity));
		}
		properties = new ArrayList<PropertyBean>();
		for (PropertyEntity propEntity : entity.getProperties()) {
			this.properties.add(new PropertyBean(propEntity));
		}

	}

	public ShowPlaceBean(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return this.name;
	}

	public ShowPlaceBean(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public List<ProcessBean> getProcesses() {
		return processes;
	}

	public void setProcesses(List<ProcessBean> processes) {
		this.processes = processes;
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO.getInstance().getShowPlaceDao()
				.setProcessesById(this.id, this.processes);
		FactoryDAO.getInstance().getProcessLogDao().addNewLog(this, processes);

		HibernateUtil.commitTransaction();
	}

	public List<ProcessBean> getAllProcesses() {
		ArrayList<ProcessBean> myProcesses = new ArrayList<ProcessBean>();
		for (ProcessBean process : this.processes) {
			myProcesses.add(process);
		}
		return myProcesses;
	}

}
