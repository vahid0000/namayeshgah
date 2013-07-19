package edu.sharif.ce.ood.taghi.namayeshgah.controller.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.BoothEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PeopleReportEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RequestEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.BoothStatus;
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
	private String map;

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
		System.out.println("ShowPlaceBean/constructor/ booth.size"
				+ this.boothes.size());

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

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
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

	public List<PropertyBean> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyBean> properties) {
		this.properties = properties;
		HibernateUtil.getCurrentSession().beginTransaction();
		FactoryDAO.getInstance().getShowPlaceDao()
				.setPropertyById(this.id, this.properties);
		FactoryDAO.getInstance().getPropertyLogDao()
				.addNewLog(this, this.properties);

		HibernateUtil.commitTransaction();
	}

	public List<RequestBean> getRequests(ShowPlaceBean showPlace) {
		HibernateUtil.getCurrentSession().beginTransaction();
		List<RequestEntity> requests = FactoryDAO.getInstance()
				.getShowPlaceDao().findByShowPlaceBean(showPlace).getRequests();
		ArrayList<RequestBean> requestBeans = new ArrayList<RequestBean>();
		System.out.println("ShowPlaceBean/getRequests/ requests.size"
				+ requests.size());
		for (RequestEntity entity : requests) {
			requestBeans.add(new RequestBean(entity));
		}
		HibernateUtil.commitTransaction();
		return requestBeans;

	}

	public void Start() {
		HibernateUtil.getCurrentSession().beginTransaction();
		ShowPlaceEntity entity = FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(this);
		entity.setImplementationStatus(implementationStatus.running);
		FactoryDAO.getInstance().getShowPlaceDao().makePersistent(entity);
		HibernateUtil.commitTransaction();

	}

	public void End() {
		HibernateUtil.getCurrentSession().beginTransaction();
		ShowPlaceEntity entity = FactoryDAO.getInstance().getShowPlaceDao()
				.findByShowPlaceBean(this);
		entity.setImplementationStatus(implementationStatus.finished);
		FactoryDAO.getInstance().getShowPlaceDao().makePersistent(entity);
		HibernateUtil.commitTransaction();

	}

	public List<BoothBean> getBoothes() {
		return boothes;
	}

	public void setBoothes(List<BoothBean> boothes) {
		this.boothes = boothes;
	}

	public List<BoothBean> getDeliquentBoothes() {
		ArrayList<BoothBean> deliquents = new ArrayList<BoothBean>();
		for (BoothBean booth : this.boothes) {
			if (booth.getBoothStatus().equals(BoothStatus.deliqunet))
				deliquents.add(booth);
		}
		return deliquents;
	}

	public List<ProcessBean> getNowProcesses() {
		Date nowDate = new Date();
		ArrayList<ProcessBean> nowProcesses = new ArrayList<ProcessBean>();
		for (ProcessBean process : this.processes) {

			if (process.getStartDate().before(nowDate)
					&& process.getEndDate().after(nowDate))
				nowProcesses.add(process);
		}
		return nowProcesses;
	}

	public List<ProcessBean> getPastProcesses() {
		Date nowDate = new Date();
		ArrayList<ProcessBean> nowProcesses = new ArrayList<ProcessBean>();
		for (ProcessBean process : this.processes) {

			if (process.getEndDate().before(nowDate))
				nowProcesses.add(process);
		}
		return nowProcesses;
	}

	public List<ProcessBean> getFutureProcesses() {
		Date nowDate = new Date();
		ArrayList<ProcessBean> nowProcesses = new ArrayList<ProcessBean>();
		for (ProcessBean process : this.processes) {

			if (process.getStartDate().after(nowDate))
				nowProcesses.add(process);
		}
		return nowProcesses;
	}

}
