package edu.sharif.ce.ood.taghi.namayeshgah.ui.news;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.NewsBean;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.BaseUI;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Portal extends BaseUI {

	// private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	ArrayList<NewsBean> news = new ArrayList<NewsBean>();
	int i;
	private JLabel subjectText;
	private JLabel detailText;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Portal frame = new Portal();
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
	public Portal() {
		super();
		setTitle("پرتال");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 0, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow][]", "[][grow][]"));

		subjectText = new JLabel("بازگشایی ....");
		panel_1.add(subjectText, "cell 0 0,alignx right");

		JLabel lblNewLabel = new JLabel("عنوان");
		panel_1.add(lblNewLabel, "cell 1 0");

		detailText = new JLabel("طی گزارش .....");
		panel_1.add(detailText, "cell 0 1,alignx right");

		JLabel label = new JLabel("متن");
		panel_1.add(label, "cell 1 1,aligny top");

		JButton button = new JButton("بعدی");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				i = (i + 1) % news.size();
				subjectText.setText(news.get(i).getSubject());
				detailText.setText(news.get(i).getDetail());
			}
		});
		panel_1.add(button, "cell 0 2");
		i = 0;
		initNews();
		if (news.size() > 0) {
			subjectText.setText(news.get(0).getSubject());
			detailText.setText(news.get(0).getDetail());
		}
	}

	public void initNews() {
		news = edu.sharif.ce.ood.taghi.namayeshgah.controller.Portal
				.getInstance().getAllPublicNews();
	}
}
