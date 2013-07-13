package edu.sharif.ce.ood.taghi.namayeshgah;

import java.util.ArrayList;

import javax.swing.JFrame;

import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.ShowPlaceDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.UserDao;
import edu.sharif.ce.ood.taghi.namayeshgah.model.entity.UserEntity;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
		HibernateUtil.getCurrentSession().beginTransaction();
		UserEntity entity = new UserEntity();
		entity.setFirstName("وحید");
		entity.setLastName("amintabar");
		entity.setUserName("vahid");
		entity.setPassword("1");
		
		UserDao ed = new UserDao();
		ed.makePersistent(entity);
		HibernateUtil.commitTransaction();
		
		ShowPlaceDao sd= new ShowPlaceDao();
		ArrayList<String> gname= new ArrayList<String>();
		gname.add("vahid");
		sd.addShowPlace("amir", "amir2", "amir3", "amir4", gname );
    }
}
