package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.PostCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.PostStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Post extends BaseUI {
	private JTextField subjectText;
	private JTextField senderText;
	private JList<PostStuffBean> list;
	private JTextArea destinationText;

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
					Post frame = new Post(a);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Post(final ShowPlaceBean currentShowPlace) {
		super();
		setTitle("پست");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[grow][][][][grow][grow 20]"));

		list = new JList<PostStuffBean>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				PostStuffBean stuff = list.getSelectedValue();
				subjectText.setText(stuff.getName());
				senderText.setText(stuff.getSender());
				destinationText.setText(stuff.getDestination());

			}
		});
		panel.add(list, "cell 1 0,grow");
		initialList(currentShowPlace);

		JLabel label = new JLabel("فیش ها");
		panel.add(label, "cell 2 0,aligny top");

		JButton button = new JButton("حذف");
		panel.add(button, "flowx,cell 1 1,alignx center");

		JButton button_1 = new JButton("تغییر");
		panel.add(button_1, "cell 1 1");

		JButton button_2 = new JButton("اضافه");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostCatalog.getInstance().addStuff(subjectText.getText(),
						senderText.getText(), destinationText.getText(),
						currentShowPlace);
				initialList(currentShowPlace);
			}
		});
		panel.add(button_2, "cell 1 1");

		subjectText = new JTextField();
		subjectText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(subjectText, "cell 1 2,growx");
		subjectText.setColumns(10);

		JLabel nameText = new JLabel("عنوان");
		panel.add(nameText, "cell 2 2");

		senderText = new JTextField();
		senderText.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(senderText, "cell 1 3,growx");
		senderText.setColumns(10);

		JLabel label_4 = new JLabel("فرستنده");
		panel.add(label_4, "cell 2 3");

		destinationText = new JTextArea();
		destinationText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(destinationText, "cell 1 4,grow");

		JLabel label_1 = new JLabel("آدرس مقصد");
		panel.add(label_1, "cell 2 4");
	}

	private void initialList(ShowPlaceBean currShowPlaceBean) {
		List<PostStuffBean> stuffs = PostCatalog.getInstance()
				.getAllPostStuffs(currShowPlaceBean);
		System.out.println("acceptContact/initialList/ phones.size:"
				+ stuffs.size());
		DefaultListModel<PostStuffBean> model = new DefaultListModel<PostStuffBean>();
		for (PostStuffBean phone : stuffs) {
			model.addElement(phone);
		}

		list.setModel(model);
	}

}
