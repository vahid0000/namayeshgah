package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import edu.sharif.ce.ood.taghi.namayeshgah.controller.CalendarTool;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.ShowPlaceCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.UserCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.RoleBean;
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
import edu.sharif.ce.ood.taghi.namayeshgah.ui.request.RequestShowPlace;
import edu.sharif.ce.ood.taghi.namayeshgah.ui.request.RequestBooth;

public class BaseUI extends JFrame {

	/**
	 * @uml.property name="contentPane"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	protected JPanel contentPane;

	private JButton[] button = new JButton[26];

	private JPanel panel;

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
		panel = new JPanel();
		JScrollPane scrollBar = new JScrollPane(panel);
		scrollBar
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollBar, BorderLayout.EAST);

		button[0] = new JButton("تیم اجرایی");
		button[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new AssignRoles();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		button[0].setFont(new Font("Tahoma", Font.PLAIN, 11));
		// panel.add(button[0]);

		button[1] = new JButton("اطلاع رسانی");
		button[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Publish(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[1]);

		button[2] = new JButton("پرتال");
		button[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Portal();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});

		button[3] = new JButton("ورودی ها");
		button[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Inputs();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});

		button[4] = new JButton("نظرسنجی");
		button[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new PollingList();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[4]);

		button[5] = new JButton("بازرسی");
		button[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Controller(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[5]);

		button[6] = new JButton("انبار");
		button[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Store(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[6]);

		button[7] = new JButton("مالی");
		button[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Financial(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});

		// panel.add(button[7]);

		// button[8] = new JButton("شرکت در نمایشگاه");
		// button[8].addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// JFrame frame = new RequestShowPlace();
		// frame.setVisible(true);
		// BaseUI.this.dispose();
		// }
		// });
		// // panel.add(button[8]);
		//
		// button[9] = new JButton("درخواست غرفه و سالن");
		// button[9].addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// JFrame frame = new RequestBooth();
		// frame.setVisible(true);
		// BaseUI.this.dispose();
		// }
		// });

		// button[9].setFont(new Font("Tahoma", Font.PLAIN, 10));
		// panel.add(button[9]);

		button[10] = new JButton("تخصیص سالن و غرفه");
		button[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageRequest(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[10]);

		button[11] = new JButton("نقشه");
		button[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Map(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[11]);

		button[12] = new JButton("پست");
		button[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Post(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[12]);

		button[13] = new JButton("گزارش مردمی");
		button[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new AddReport();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[13]);

		button[14] = new JButton("فرآیند");
		button[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ImplementationProcess();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[14]);

		button[15] = new JButton("درخواست");
		button[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageRequest(ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[15]);

		button[16] = new JButton("برگزاری-خاتمه");
		button[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new StartShowPlace(ShowPlaceCatalog
						.getInstance().getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[16]);

		button[17] = new JButton("کراد");
		button[17].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new CRUD();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[17]);

		button[18] = new JButton("گزارش");
		button[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ReportShowPlace();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[18]);

		// button[19] = new JButton("ارسال خبر");
		// button[19].addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// JFrame frame = new News();
		// frame.setVisible(true);
		// BaseUI.this.dispose();
		// }
		// });
		// panel.add(button[19]);

		// panel.add(button[20]);

		button[20] = new JButton(
				"<html><div style=\"text-align:center;\">\r\nرای‌گیری\r\n<br>\r\nمشخصات و فرآیند\r\n</div></html>");
		button[20].setFont(new Font("Tahoma", Font.PLAIN, 10));
		button[20].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Election();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[26]);

		button[21] = new JButton(
				"<html><div style=\"text-align:center;\">\r\nرای‌گیری\r\n<br>\r\nتیم اجرایی\r\n</div></html>");
		button[21].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[21].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Election();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[21]);

		button[22] = new JButton("ورود");
		button[22].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Login();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[22]);

		button[23] = new JButton("مدیریت فرآیندها");
		button[23].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[23].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new ManageProcess(ShowPlaceCatalog.getInstance()
						.getAllShowPlaces(), ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		panel.setLayout(new GridLayout(28, 1, 0, 0));

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
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[24]);
		// panel.add(button[23]);

		button[25] = new JButton("ویژگی ها");
		button[25].setFont(new Font("Tahoma", Font.PLAIN, 11));
		button[25].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame frame = new Properties(ShowPlaceCatalog.getInstance()
						.getAllShowPlaces(), ShowPlaceCatalog.getInstance()
						.getCurrentShowPlace());
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		// panel.add(button[25]);

		// panel.add(button[27]);

		// panel.add(button[28]);

		// panel.add(button[29]);
		this.setButtons(UserCatalog.getInstance()
				.getRolesOfLoggedInUserByShowPlace(
						ShowPlaceCatalog.getInstance().getCurrentShowPlace()));
		userLabel.setText(UserCatalog.getInstance().getFullNameOfLoggedInUser()
				+ " " + "خوش آمدید");

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);

		// CalendarTool ct = new CalendarTool(new Date());
		// JLabel ghamariLabel = new JLabel(ct.getGregorianDate());
		// panel_2.add(ghamariLabel);

		JLabel label = new JLabel("1392/4/26");
		panel_2.add(label);

		JButton button_2 = new JButton("صفحه اصلی");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new Home();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		if (UserCatalog.getInstance().getLogginedUser() != null)
			panel_2.add(button_2);

		JButton button_1 = new JButton("خروج");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserCatalog.getInstance().setLogginedUser(null);
				Login frame = new Login();
				frame.setVisible(true);
				BaseUI.this.dispose();
			}
		});
		panel_2.add(button_1);
		if (UserCatalog.getInstance().getLogginedUser() != null)
			button_1.setText("خروج");
		else
			button_1.setText("ورود");

		if (ShowPlaceCatalog.getInstance().getAllShowPlaces().size() > 0
				&& ShowPlaceCatalog.getInstance().getCurrentShowPlace() == null)
			ShowPlaceCatalog.getInstance().setCurrentShowPlace(
					ShowPlaceCatalog.getInstance().getAllShowPlaces().get(0));
		this.setButtons(UserCatalog.getInstance()
				.getRolesOfLoggedInUserByShowPlace(
						ShowPlaceCatalog.getInstance().getCurrentShowPlace()));
	}

	public void setButtons(List<RoleBean> roles) {
		// panel=new JPanel();
		// panel.setLayout(new GridLayout(20, 1, 0, 0));
		// JScrollPane scrollBar = new JScrollPane(panel);
		// scrollBar
		// .setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		// contentPane.add(scrollBar, BorderLayout.EAST);
		panel.setVisible(false);
		panel.removeAll();
		System.out.println("BaseUI/setButtons rolesSize:" + roles.size());

		for (RoleBean butId : roles) {
//			System.out.println("buuuuuuuuuuuuuuuut:" + butId.getNumber());
			panel.add(button[butId.getNumber()]);
		}
		panel.setVisible(true);
		this.repaint();

	}

}
