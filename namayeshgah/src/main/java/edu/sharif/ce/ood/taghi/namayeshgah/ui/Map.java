package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;

public class Map extends BaseUI {
	private JTextField textField;

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
					Map frame = new Map(a);
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
	public Map(ShowPlaceBean currentShowPlace) {
		super();
		setTitle("نقشه");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[][grow][]", "[][][]"));

		initialText(currentShowPlace);

		JButton selecFile = new JButton("انتخاب فایل");
		selecFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(Map.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					textField.setText(fc.getSelectedFile().getAbsolutePath());
					System.out.println("file chooser:"
							+ fc.getSelectedFile().getAbsolutePath());
				}
			}
		});

		textField = new JTextField();
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		panel.add(selecFile, "cell 1 2,alignx center");
	}

	private void initialText(ShowPlaceBean currentShowPlace) {
		textField.setText(currentShowPlace.getMap());

	}

}
