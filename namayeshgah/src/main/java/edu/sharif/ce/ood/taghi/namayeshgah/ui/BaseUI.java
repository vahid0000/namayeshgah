package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.controlling.Controller;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.news.News;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.news.Portal;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.polling.PollingList;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.processes.ImplementationProcess;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.processes.ManageProcess;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.publish.Publish;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.report.AddReport;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.report.ReportShowPlace;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.request.ManageRequest;

public class BaseUI extends JFrame {

	/**
	 * @uml.property name="contentPane"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	protected JPanel contentPane;

	private JButton[] button = new JButton[28];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseUI frame = new BaseUI();
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
	public BaseUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		JScrollPane scrollBar = new JScrollPane(panel);
		scrollBar
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollBar, BorderLayout.EAST);

		button[0] = new JButton("تیم اجرایی");
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new AssignRoles();
				frame.setVisible(true);
			}
		});
		button[0].setFont(new Font("Tahoma", Font.PLAIN, 11));
		// panel.add(button[0]);

		button[1] = new JButton("اطلاع رسانی");
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Publish();
				frame.setVisible(true);
			}
		});
		// panel.add(button[1]);

		button[2] = new JButton("اجرایی");
		// panel.add(button[2]);

		button[3] = new JButton("ورودی ها");
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Inputs();
				frame.setVisible(true);
			}
		});

		button[4] = new JButton("نظرسنجی");
		button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new PollingList();
				frame.setVisible(true);
			}
		});
		// panel.add(button[4]);

		button[5] = new JButton("بازرسی");
		button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Controller();
				frame.setVisible(true);
			}
		});
		// panel.add(button[5]);

		button[6] = new JButton("انبار");
		button[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Store();
				frame.setVisible(true);
			}
		});
		// panel.add(button[6]);

		button[7] = new JButton("مالی");
		button[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Financial();
				frame.setVisible(true);
			}
		});

		// panel.add(button[7]);

		button[8] = new JButton("شرکت در نمایشگاه");
		button[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new RequestShowPlace();
				frame.setVisible(true);
			}
		});
		// panel.add(button[8]);

		button[9] = new JButton("درخواست غرفه و سالن");
		button[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new RequestSaloon();
				frame.setVisible(true);
			}
		});

		button[9].setFont(new Font("Tahoma", Font.PLAIN, 10));
		// panel.add(button[9]);

		button[10] = new JButton("تخصیص سالن و غرفه");
		button[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageRequest();
				frame.setVisible(true);
			}
		});
		// panel.add(button[10]);

		button[11] = new JButton("نقشه");
		button[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Map();
				frame.setVisible(true);
			}
		});
		// panel.add(button[11]);

		button[12] = new JButton("پست");
		button[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Post();
				frame.setVisible(true);
			}
		});
		// panel.add(button[12]);

		button[13] = new JButton("گزارش مردمی");
		button[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new AddReport();
				frame.setVisible(true);
			}
		});
		// panel.add(button[13]);

		button[14] = new JButton("فرآیند");
		button[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ImplementationProcess();
				frame.setVisible(true);
			}
		});
		// panel.add(button[14]);

		button[15] = new JButton("درخواست");
		button[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageRequest();
				frame.setVisible(true);
			}
		});
		// panel.add(button[15]);

		button[16] = new JButton("برگزاری-خاتمه");
		button[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new StartShowPlace();
				frame.setVisible(true);
			}
		});
		// panel.add(button[16]);

		button[17] = new JButton("کراد");
		button[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new CRUD();
				frame.setVisible(true);
			}
		});
		// panel.add(button[17]);

		button[18] = new JButton("گزارش");
		button[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ReportShowPlace();
				frame.setVisible(true);
			}
		});
		// panel.add(button[18]);

		button[19] = new JButton("ارسال خبر");
		button[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new News();
				frame.setVisible(true);
			}
		});
		// panel.add(button[19]);

		button[20] = new JButton("پرتال");
		button[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Portal();
				frame.setVisible(true);
			}
		});
		// panel.add(button[20]);

		button[21] = new JButton("کارتابل");
		button[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Kartabl();
				frame.setVisible(true);
			}
		});
		// panel.add(button[21]);

		button[22] = new JButton("ورود");
		button[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Login();
				frame.setVisible(true);
			}
		});
		// panel.add(button[22]);

		button[23] = new JButton("مدیریت فرآیندها");
		button[23].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageProcess();
				frame.setVisible(true);
			}
		});
		panel.setLayout(new GridLayout(20, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel userLabel = new JLabel("");
		panel_1.add(userLabel);

		button[24] = new JButton("تعریف نمایشگاه");
		button[24].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[24].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Definition(UserCatalog.getInstance()
						.getAllUsers());
				frame.setVisible(true);
			}
		});
		// panel.add(button[24]);
		// panel.add(button[23]);

		button[25] = new JButton("ویژگی ها");
		button[25].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[25].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Properties();
				frame.setVisible(true);
			}
		});
		// panel.add(button[25]);

		button[26] = new JButton(
				"<html><div style=\"text-align:center;\">\r\nرای‌گیری\r\n<br>\r\nمشخصات و فرآیند\r\n</div></html>");
		button[26].setFont(new Font("Tahoma", Font.PLAIN, 10));
		button[26].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Election();
				frame.setVisible(true);
			}
		});
		// panel.add(button[26]);

		button[27] = new JButton(
				"<html><div style=\"text-align:center;\">\r\nرای‌گیری\r\n<br>\r\nتیم اجرایی\r\n</div></html>");
		button[27].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[27].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Election();
				frame.setVisible(true);
			}
		});
		// panel.add(button[27]);

		// panel.add(button[28]);

		// panel.add(button[29]);
		for (Integer butId : UserCatalog.getInstance().getRolesOfLoggedInUser()) {
			panel.add(button[butId]);
		}
		userLabel.setText(UserCatalog.getInstance().getFullNameOfLoggedInUser()
				+ " " + "خوش آمدید");
	}

}
