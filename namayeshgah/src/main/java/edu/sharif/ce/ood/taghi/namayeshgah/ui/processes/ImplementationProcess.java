package edu.sharif.ce.ood.taghi.namayeshgah.ui.processes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ProcessBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.controlling.Controller;

public class ImplementationProcess extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HibernateUtil.getCurrentSession().beginTransaction();
					ShowPlaceBean a = new ShowPlaceBean(FactoryDAO
							.getInstance().getShowPlaceDao().findById(1, false));

					HibernateUtil.commitTransaction();
					ImplementationProcess frame = new ImplementationProcess(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JList futureList;
	private JList nowList;
	private JList pastList;

	/**
	 * Create the frame.
	 */
	public ImplementationProcess(ShowPlaceBean showPlace) {
		super();
		setTitle("اجرای فرآیند پایه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow]", "[grow]"));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[][][grow]"));

		JLabel label_2 = new JLabel("آینده");
		panel_1.add(label_2, "cell 0 0,alignx center");

		JLabel nowLabel = new JLabel("در حال اجرا");
		panel_1.add(nowLabel, "cell 1 0,alignx center");

		JLabel pastLabel = new JLabel("گذشته");
		panel_1.add(pastLabel, "cell 2 0,alignx center");

		futureList = new JList();
		panel_1.add(futureList, "cell 0 2,grow");

		nowList = new JList();
		panel_1.add(nowList, "cell 1 2,grow");

		pastList = new JList();
		panel_1.add(pastList, "cell 2 2,grow");
		initNowLists(showPlace);
		initPastLists(showPlace);
		initFutureLists(showPlace);
	}

	public void initNowLists(ShowPlaceBean showPlace) {
		List<ProcessBean> nowProcesses = showPlace.getNowProcesses();
		DefaultListModel<ProcessBean> model = new DefaultListModel<ProcessBean>();
		for (ProcessBean nowProcess : nowProcesses) {
			model.addElement(nowProcess);
		}
		nowList.setModel(model);

	}

	public void initPastLists(ShowPlaceBean showPlace) {
		List<ProcessBean> nowProcesses = showPlace.getPastProcesses();
		DefaultListModel<ProcessBean> model = new DefaultListModel<ProcessBean>();
		for (ProcessBean nowProcess : nowProcesses) {
			model.addElement(nowProcess);
		}
		pastList.setModel(model);

	}

	public void initFutureLists(ShowPlaceBean showPlace) {
		List<ProcessBean> nowProcesses = showPlace.getFutureProcesses();
		DefaultListModel<ProcessBean> model = new DefaultListModel<ProcessBean>();
		for (ProcessBean nowProcess : nowProcesses) {
			model.addElement(nowProcess);
		}
		futureList.setModel(model);

	}

}
