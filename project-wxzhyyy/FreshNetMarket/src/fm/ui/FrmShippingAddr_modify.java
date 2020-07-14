package fm.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fm.model.BeanShippingAddress;
import fm.model.BeanUser;
import fm.util.BaseException;
import freshmarket.FreshMarketUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class FrmShippingAddr_modify extends JFrame implements ActionListener{
	BeanShippingAddress sa=null;
	private JPanel contentPane;

	private	JLabel lblNewLabel = new JLabel("ʡ��");
	private	JLabel lblNewLabel_1 = new JLabel("�У�");
	private	JLabel lblNewLabel_2 = new JLabel("����");
	private	JLabel lblNewLabel_3 = new JLabel("��ϸ��ַ��");
	private	JLabel lblNewLabel_4 = new JLabel("��ϵ�ˣ�");
	private	JLabel lblNewLabel_5 = new JLabel("�绰");
	private JTextField	textprovince = new JTextField();
	private JTextField textcity = new JTextField();
	private JTextField	textcell = new JTextField();
	private JTextField	textlinkman = new JTextField();
	private JTextField	textphone = new JTextField();
	private	JTextArea textAreaaddress = new JTextArea();
	private	JButton btnOK = new JButton("ȷ��");
	private	JButton btnCancel = new JButton("ȡ��");
	
	BeanShippingAddress	currentShippingAddress=BeanShippingAddress.currentShippingAddress;

	private Object ShippingAddr;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FrmShippingAddr_modify frame = new FrmShippingAddr_modify();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FrmShippingAddr_modify() {
		
		this.sa=BeanShippingAddress.currentShippingAddress;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textprovince.setText(currentShippingAddress.getProvince());
		textcity.setText(currentShippingAddress.getCity());
		textcell.setText(currentShippingAddress.getCell());
		textAreaaddress.setText(currentShippingAddress.getAddress());
		textlinkman.setText(currentShippingAddress.getLinkman());
		textphone.setText(currentShippingAddress.getPhone());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textphone, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
							.addGap(42))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textlinkman, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textAreaaddress, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textprovince, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textcell, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textcity, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))))
							.addGap(41))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(168, Short.MAX_VALUE)
					.addComponent(btnOK, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(47))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textprovince, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textcity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(textcell, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(textAreaaddress, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(textlinkman, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(textphone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOK)
						.addComponent(btnCancel))
					.addGap(22))
		);
		contentPane.setLayout(gl_contentPane);
		this.btnOK.addActionListener(this);
		this.btnCancel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.btnCancel) {
			this.dispose();
		}
		else if (e.getSource()==this.btnOK) {
			String province=this.textprovince.getText();
			String city=this.textcity.getText();
			String cell=this.textcell.getText();
			String address=this.textAreaaddress.getText();
			String linkman=this.textlinkman.getText();
			String phone=this.textphone.getText();
			String userid=BeanUser.currentLoginUser.getUser_id();
			try {
				FreshMarketUtil.ShipAddrManager.modifyShippingAddress(currentShippingAddress, province, city, cell, address, linkman, phone);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.setVisible(false);;
		}
	}

	public BeanShippingAddress getShippingAddress() {
		return sa;
	}
}
