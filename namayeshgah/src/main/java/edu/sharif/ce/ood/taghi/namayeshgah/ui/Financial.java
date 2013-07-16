package edu.sharif.ce.ood.taghi.namayeshgah.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import net.miginfocom.swing.MigLayout;
import edu.sharif.ce.ood.taghi.namayeshgah.HibernateUtil;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.FinancialCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.StoreCatalog;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ReceiptBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.ShowPlaceBean;
import edu.sharif.ce.ood.taghi.namayeshgah.controller.bean.StoreStuffBean;
import edu.sharif.ce.ood.taghi.namayeshgah.model.dao.FactoryDAO;
import edu.sharif.ce.ood.taghi.namayeshgah.model.enums.ReceiptStatus;

public class Financial extends BaseUI {
	private JTextField textField;
	private JTextField priceText;
	private JList<ReceiptBean> list;

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

					Financial frame = new Financial(a);
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
	public Financial(final ShowPlaceBean currentShowPlace) {
		super();
		setTitle("انبار");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[467px]", "[grow][grow 30]"));

		JPanel upPanel = new JPanel();
		upPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(upPanel, "cell 0 0,grow");
		upPanel.setLayout(new MigLayout("", "[][grow][]", "[][][][grow][]"));

		JLabel label = new JLabel("فیش های موجود");
		upPanel.add(label, "cell 1 0,alignx center");

		JButton button = new JButton("جست و جو");
		upPanel.add(button, "flowx,cell 1 2,alignx center");

		list = new JList<ReceiptBean>();
		list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		initialList(currentShowPlace);
		upPanel.add(list, "cell 1 3,grow");

		textField = new JTextField();
		textField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		upPanel.add(textField, "cell 1 2");
		textField.setColumns(10);

		JLabel label_2 = new JLabel("شماره پیگیری");
		upPanel.add(label_2, "cell 1 2");

		JButton button_2 = new JButton("پرداخت فیش");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() < 0) {
					JOptionPane.showMessageDialog(Financial.this,
							"هیچ کالا ای را انتخاب نکرده اید", "خطا",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int permition = JOptionPane.showConfirmDialog(
							Financial.this,
							"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
							"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
					if (permition == 0) {
						list.getSelectedValue().setStatus(ReceiptStatus.paid);
						initialList(currentShowPlace);
					}
				}
			}
		});
		upPanel.add(button_2, "cell 1 4");

		JPanel downPanel = new JPanel();
		downPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(downPanel, "cell 0 1,grow");
		downPanel.setLayout(new MigLayout("", "[][grow][50px:n:100px][]",
				"[][][grow][][]"));

		JLabel label_5 = new JLabel("ثبت فیش جدید");
		downPanel.add(label_5, "cell 1 0,alignx center");

		final JTextArea descriptionText = new JTextArea();
		descriptionText
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		downPanel.add(descriptionText, "cell 1 2,grow");

		JLabel label_4 = new JLabel("توضیحات");
		downPanel.add(label_4, "cell 2 2");

		JButton button_1 = new JButton("ثبت");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (priceText.getText().length() < 1
						|| descriptionText.getText().length() < 1) {
					JOptionPane.showMessageDialog(Financial.this,
							"همه فیلد ها را پر نمایید", "خطا",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				Double price = null;
				try {
					price = Double.parseDouble(priceText.getText());
				} catch (Exception ea) {
					JOptionPane.showMessageDialog(Financial.this,
							"قیمت را درست وارد نکردید", "خطا",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				int permition = JOptionPane.showConfirmDialog(Financial.this,
						"آیا صحت اطلاعات وارد شده را تایید می کنید؟",
						"تایید صحت اطلاعات", JOptionPane.YES_NO_OPTION);
				if (permition == 0) {
					FinancialCatalog.getInstance().addEnterreciept(price,
							descriptionText.getText(), currentShowPlace);
					initialList(currentShowPlace);
				}
			}

		});

		priceText = new JTextField();
		downPanel.add(priceText, "cell 1 3,growx");
		priceText.setColumns(10);

		JLabel label_1 = new JLabel("قیمت");
		downPanel.add(label_1, "cell 2 3");
		downPanel.add(button_1, "cell 1 4");
	}

	private void initialList(ShowPlaceBean currentShowPlace) {
		List<ReceiptBean> stuffs = FinancialCatalog.getInstance()
				.getAllReciepts();
		System.out.println("financial/ initialList/ receipt.size"
				+ stuffs.size());
		DefaultListModel<ReceiptBean> model = new DefaultListModel<ReceiptBean>();
		for (ReceiptBean bean : stuffs) {
			model.addElement(bean);
		}
		this.list.setModel(model);
	}

}
