package edu.sharif.ce.ood.taghi.namayeshgah;

import java.util.ArrayList;

import javax.swing.JFrame;

import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.ProcessDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.PropertyDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.ShowPlaceDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.UserDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ConstRoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ProcessEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.PropertyEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.RoleEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.ShowPlaceEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ProcessStatus;

/**
 * Hello world!
 * 
 */
public class App {

	public static void addShowPlace() {
		ShowPlaceDao sd = new ShowPlaceDao();
		ArrayList<String> gname = new ArrayList<String>();
		gname.add("showPlace owner");
		sd.addShowPlace("showPlace", "showPlace defSummary",
				"showPlace description", "showPlace owner", gname);
	}

	// public static void addUserRole(UserEntity user,ShowPlaceEntity showPlace)
	// {
	//
	// RoleEntity role = new RoleEntity();
	// role.setName("showPlace1 Role1");
	// role.setNumber(15);
	// role.setShowPlace(showPlace);
	//
	// }

	public static void addUsers() {
		UserEntity entity = new UserEntity();
		entity.setFirstName("وحید");
		entity.setLastName("amintabar");
		entity.setUserName("vahid");
		entity.setPassword("1");
		UserDao ed = new UserDao();
		ed.makePersistent(entity);
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");

		HibernateUtil.getCurrentSession().beginTransaction();
		// UserEntity entity = FactoryDAO.getInstance().getUserDao()
		// .findById(1, false);
		 addUsers();
//		 addShowPlace();
		 addProcesses();
		 addRoles();
		addProperties();
		// System.out.println(entity.getLastName());
		HibernateUtil.commitTransaction();

	}

	private static void addProperties() {
		PropertyEntity property1 = new PropertyEntity();
		property1.setSubject("property1 s");
		property1.setDescription("propery1 des");
		PropertyDao pd = new PropertyDao();
		pd.makePersistent(property1);
		PropertyEntity property2 = new PropertyEntity();
		property2.setSubject("property2 s");
		property2.setDescription("propery2 des");
		pd.makePersistent(property2);

	}

	private static void addRoles() {
		ConstRoleEntity cRole = new ConstRoleEntity();
		cRole.setName("برگزاری-خاتمه");
		cRole.setNumber(16);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);

		cRole = new ConstRoleEntity();
		cRole.setName("مدیریت فرآیندها");
		cRole.setNumber(23);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);

		cRole = new ConstRoleEntity();
		cRole.setName("تعریف نمایشگاه");
		cRole.setNumber(24);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);

		cRole = new ConstRoleEntity();
		cRole.setName("ویژگی ها");
		cRole.setNumber(25);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);
		cRole = new ConstRoleEntity();
		cRole.setName("رای گیری تیم اجرایی");
		cRole.setNumber(26);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);
		cRole = new ConstRoleEntity();
		cRole.setName("رای گیری فرآیندها و ویژگی ها");
		cRole.setNumber(27);
		cRole.setProcess(FactoryDAO.getInstance().getProcessDao()
				.findById(1, false));
		FactoryDAO.getInstance().getConstRoleDao().makePersistent(cRole);

	}

	private static void addProcesses() {
		ProcessDao pd = new ProcessDao();

		ProcessEntity process1 = new ProcessEntity();
		process1.setDescription("process1 description");
		process1.setName("process1");
		process1.setProcessStatus(null);
		pd.makePersistent(process1);

		ProcessEntity process2 = new ProcessEntity();
		process2.setDescription("process2 description");
		process2.setName("process2");
		process2.setProcessStatus(null);
		pd.makePersistent(process2);
	}
}
