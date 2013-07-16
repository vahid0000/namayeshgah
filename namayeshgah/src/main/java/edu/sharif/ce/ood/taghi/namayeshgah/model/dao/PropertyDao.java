package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;

public class PropertyDao extends GenericHibernateDAO<PropertyEntity, Integer> {


	
	public List<PropertyBean> getAllProperties(){
		List<PropertyEntity> entities = this.findAll();
		System.out.println("PropertyDao: getAllProperties.size()="+entities.size());
		ArrayList<PropertyBean> users_string=new ArrayList<PropertyBean>();
		for(PropertyEntity user: entities){
			users_string.add(new PropertyBean(user));
		}
		if (users_string.size() > 0)
			return users_string;
		return null;
	}
}
