package edu.sharif.ce.ood.taghi.namayeshgah.model.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PropertyBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.FilesEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.NewsEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;

public class FileDao extends GenericHibernateDAO<FilesEntity, Integer> {

	public void addFile(String addr, NewsEntity news) {
		FilesEntity file = new FilesEntity();
		file.setAddress(addr);
		file.setNews(news);
		this.makePersistent(file);
	}
}
