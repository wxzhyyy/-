package fm.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import fm.model.BeanCoupon;
import fm.model.BeanOrder;
import fm.model.BeanShippingAddress;
import fm.model.BeanUser;
import fm.util.BaseException;
import freshmarket.FreshMarketUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmSubmitOrder extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btncouponOK = new JButton("ѡ���Ż�ȯ");
	private JButton btnaddrOK = new JButton("ѡ���ַ");
	private	JButton btnmodifyaddr = new JButton("��ӻ��޸ĵ�ַ");
	
	//�Ż�ȯ
	private Object tblCouponTitle[]= {"�Ż�ȯ���","���","��","��","��ʼʱ��","����ʱ��"};
	private Object tblCouponData[][];
	DefaultTableModel tabCouponModel=new DefaultTableModel();
	private JTable dataTableCoupon=new JTable(tabCouponModel);
	BeanCoupon coupon=null;
	private List<BeanCoupon> allCoupon=null;
	
	//ѡ���ַ
	private Object tblShipAddrTitle[]= {"��ַ���","ʡ","��","��","��ϸ��ַ","��ϵ��","�绰",};
	private Object tblShipAddrData[][];
	DefaultTableModel tabShipAddrModel=new DefaultTableModel();
	private JTable dataTableShipAddr=new JTable(tabShipAddrModel);
	List<BeanShippingAddress> allShipAddr=null;
	private JButton btnSubmit = new JButton("�ύ");
	private JLabel lbloriginalprice = new JLabel("\u539F\u59CB\u603B\u4EF7:");
	private JTextField textoriginalprice = new JTextField();
	private JLabel lblNewLabel_3 = new JLabel("Ԫ");
	private JLabel lblNewLabel_4 = new JLabel("\u4F18\u60E0\u540E\u603B\u8BA1:");
	private JTextField textActualprice = new JTextField();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSubmitOrder frame = new FrmSubmitOrder();
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
	public FrmSubmitOrder() {
		textActualprice.setEditable(false);
		textActualprice.setColumns(10);
		textoriginalprice.setEditable(false);
		textoriginalprice.setColumns(10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1099, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("ѡ������Ż�ȯ");
		JLabel lblNewLabel_1 = new JLabel("ѡ�����͵�ַ");
		JScrollPane scrollPane = new JScrollPane();
		JScrollPane scrollPane_1 = new JScrollPane();
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(552, Short.MAX_VALUE)
					.addComponent(btnaddrOK, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(btnmodifyaddr)
					.addGap(271))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnSubmit, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 932, GroupLayout.PREFERRED_SIZE)
									.addComponent(btncouponOK, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)))
							.addGap(108))))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addComponent(lbloriginalprice)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textoriginalprice, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(215)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textActualprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(443, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbloriginalprice)
						.addComponent(textoriginalprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(textActualprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(lblNewLabel)
					.addGap(30)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btncouponOK)
					.addGap(11)
					.addComponent(lblNewLabel_1)
					.addGap(31)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnaddrOK)
						.addComponent(btnmodifyaddr)
						.addComponent(btnSubmit))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		try {
			textoriginalprice.setText(FreshMarketUtil.OrderManager.OriginalPrice(BeanOrder.cartOrder));
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			textActualprice.setText(FreshMarketUtil.OrderManager.ActualPrice(BeanOrder.cartOrder));
		} catch (BaseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		scrollPane_1.setViewportView(dataTableShipAddr);
		scrollPane.setViewportView(dataTableCoupon);
		contentPane.setLayout(gl_contentPane);
		this.reloadShipAddrTable();
		this.reloadCouponTable();
		this.dataTableShipAddr.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent e) {
				int i=FrmSubmitOrder.this.dataTableShipAddr.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null, "��ѡ���ַ", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				
			}
	    	
	    });
		this.dataTableCoupon.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent e) {
				int i=FrmSubmitOrder.this.dataTableCoupon.getSelectedRow();
				if(i<0) {
					JOptionPane.showMessageDialog(null, "��ѡ���Ż�ȯ", "��ʾ", JOptionPane.ERROR_MESSAGE);
				}
				
			}
	    	
	    });
	}
	private void reloadCouponTable(){//���ǲ������ݣ���Ҫ��ʵ�����滻
		try {
			allCoupon=FreshMarketUtil.CouponManager.loadAllUserCoupons(BeanUser.currentLoginUser);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblCouponData =  new Object[allCoupon.size()][tblCouponTitle.length];
		for(int i=0;i<allCoupon.size();i++){
			for(int j=0;j<tblCouponTitle.length;j++)
				tblCouponData[i][j]=allCoupon.get(i).getAdminCell(j);
		}
		tabCouponModel.setDataVector(tblCouponData,tblCouponTitle);
		this.dataTableCoupon.validate();
		this.dataTableCoupon.repaint();
	}

	private void reloadShipAddrTable(){//���ǲ������ݣ���Ҫ��ʵ�����滻
		try {
			String userid=BeanUser.currentLoginUser.getUser_id();
			allShipAddr=FreshMarketUtil.ShipAddrManager.loadAll(userid);
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblShipAddrData =  new Object[allShipAddr.size()][tblShipAddrTitle.length];
		for(int i=0;i<allShipAddr.size();i++){
			for(int j=0;j<tblShipAddrTitle.length;j++)
				tblShipAddrData[i][j]=allShipAddr.get(i).getCell(j);
		}
		tabShipAddrModel.setDataVector(tblShipAddrData,tblShipAddrTitle);
		this.dataTableShipAddr.validate();
		this.dataTableShipAddr.repaint();
		this.btnaddrOK.addActionListener(this);
		this.btncouponOK.addActionListener(this);
		this.btnmodifyaddr.addActionListener(this);
		this.btnSubmit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.btnaddrOK) {
			int i=FrmSubmitOrder.this.dataTableShipAddr.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "��ѡ���ַ", "��ʾ", JOptionPane.ERROR_MESSAGE);
			}
			BeanShippingAddress sa=allShipAddr.get(i);
			try {
				BeanOrder or=BeanOrder.cartOrder;
				FreshMarketUtil.OrderManager.addOrderAddr(or, sa);
			}catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==this.btnaddrOK) {
			
		}
		else if(e.getSource()==this.btncouponOK) {
			int i=FrmSubmitOrder.this.dataTableCoupon.getSelectedRow();
			if(i<0) {
				JOptionPane.showMessageDialog(null, "δѡ���Ż�ȯ", "��ʾ", JOptionPane.ERROR_MESSAGE);
			}
			BeanCoupon coupon=allCoupon.get(i);
			try {
				FreshMarketUtil.OrderManager.addOrderCoupon(BeanOrder.cartOrder,coupon);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			float actualprice=BeanOrder.cartOrder.getActual_price();
			String sactualprice=Float.toString(actualprice);
			textActualprice.setText(sactualprice);
		}
		else if(e.getSource()==this.btnmodifyaddr) {
			FrmShippingAddr dlg=new FrmShippingAddr();
			dlg.setVisible(true);
			this.reloadShipAddrTable();
		}
		else if(e.getSource()==this.btnSubmit) {
			BeanOrder or=BeanOrder.cartOrder;
			try {
				FreshMarketUtil.OrderManager.OrderSubmit(or);
				FreshMarketUtil.CouponManager.useUserCoupon(BeanUser.currentLoginUser, or);
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
