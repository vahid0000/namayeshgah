package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;

public class ProcessDao extends GenericHibernateDAO<ProcessEntity, Integer> {


	
	public List<ProcessBean> getAllProcesses(){
		List<ProcessEntity> entities = this.findAll();
		System.out.println("ProcessDao: getAllProcesses.size()="+entities.size());
		ArrayList<ProcessBean> users_string=new ArrayList<ProcessBean>();
		for(ProcessEntity user: entities){
			users_string.add(new ProcessBean(user));
		}
		if (users_string.size() > 0)
			return users_string;
		return null;
	}
}
