package fm.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import fm.model.BeanCat;
import fm.model.BeanComd;
import fm.model.BeanUser;
import fm.util.BaseException;
import fm.util.BusinessException;
import freshmarket.FreshMarketUtil;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class FrmMain extends JFrame implements ActionListener {

	private JMenuBar menuBar=new JMenuBar();
	private JMenu mntmSearhch = new JMenu("����");
	private JMenu mnmyOrder = new JMenu("����");
	private	JMenu mnMineInfo = new JMenu("�ҵ�");
	private JMenuItem mntmMyBlance = new JMenuItem("�ҵ����");
	private	JMenuItem mntmNewMyCoupon = new JMenuItem("�ҵ��Ż�ȯ");
	private	JMenuItem mntmMyVIP = new JMenuItem("��ΪVIP");
	private	JMenuItem mntmMyIfo = new JMenuItem("������Ϣ");
	private	JMenuItem mntmShippingAddr = new JMenuItem("���͵�ַ");
	private JMenuItem mntmOrderdetail = new JMenuItem("��ʷ����");
	private JMenuItem mntmMyEval = new JMenuItem("��������Ʒ");
	private JMenuItem mntmSeachComd = new JMenuItem("������Ʒ");
	private JMenuItem mntmSearchMenu = new JMenuItem("�����˵�");
	private JMenuItem mntmChangPwd = new JMenuItem("�޸�����");
	
	
	private Object tblCatTitle[]= {"��������","��������"};
	private Object tblCatData[][];
	DefaultTableModel tabCatModel=new DefaultTableModel();
	private JTable dataTableCat=new JTable(tabCatModel);


	
	private Object tblCatComdTitle[]= {"��Ʒ���","��Ʒ����","��Ʒ�۸�","VIP�۸�","���"};
	private Object tblCatComdData[][];
	DefaultTableModel tabCatComdModel=new DefaultTableModel();
	private JTable dataTableCatComd=new JTable(tabCatComdModel);
	
	BeanCat curCat=null;
	List<BeanCat> allCat=null;
	List<BeanComd> allCatComd=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private FrmLogin dlgLogin=null;
	private JMenuItem mntmNewCart = new JMenuItem("���ﳵ");
	private JMenuItem mntmSystemCoupon = new JMenuItem("��ȡ�Ż�ȯ");
	private JMenuItem mntmpromotion = new JMenuItem("������Ʒ");

	
	/**
	 * Create the frame.
	 */
	
	public FrmMain() {
		
		this.setTitle("���ʳ���");
		dlgLogin=new FrmLogin(this,"��½",true);
		dlgLogin.setVisible(true);
		if(BeanUser.currentLoginUser.getUser_id()==null)
			this.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setJMenuBar(menuBar);
		menuBar.add(mntmSearhch);
		
		mntmSearhch.add(mntmSeachComd);
		
		mntmSearhch.add(mntmSystemCoupon);
		
		
		mntmSearhch.add(mntmSearchMenu);
		
		mntmSearhch.add(mntmpromotion);
		menuBar.add(mnmyOrder);
		
		mnmyOrder.add(mntmNewCart);
		mnmyOrder.add(mntmOrderdetail);
		mnmyOrder.add(mntmMyEval);
		menuBar.add(mnMineInfo);
		mnMineInfo.add(mntmMyBlance);
		mnMineInfo.add(mntmNewMyCoupon);
		mnMineInfo.add(mntmMyVIP);
		mnMineInfo.add(mntmMyIfo);
		mnMineInfo.add(mntmShippingAddr);
		
		mnMineInfo.add(mntmChangPwd);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		this.mntmSearhch.addActionListener(this);
		this.mnMineInfo.addActionListener(this);
		this.mntmShippingAddr.addActionListener(this);
		this.mntmMyIfo.addActionListener(this);
		this.mntmNewMyCoupon.addActionListener(this);
		this.mnmyOrder.addActionListener(this);
		this.mntmMyVIP.addActionListener(this);
		this.mntmOrderdetail.addActionListener(this);
		this.mntmMyEval.addActionListener(this);
		this.mntmMyIfo.addActionListener(this);
		this.mntmMyBlance.addActionListener(this);
		this.mntmSeachComd.addActionListener(this);
		this.mntmSearchMenu.addActionListener(this);
		this.mntmNewCart.addActionListener(this);
		this.mntmSystemCoupon.addActionListener(this);
		this.mntmChangPwd.addActionListener(this);
		
		this.getContentPane().add(new JScrollPane(this.dataTableCat), BorderLayout.WEST);
	    this.dataTableCat.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent e) {
				int i=FrmMain.this.dataTableCat.getSelectedRow();
				if(i<0) {
					return;
				}
				FrmMain.this.reloadCatComdTabel(i);
			}
	    	
	    });
	    
	    this.getContentPane().add(new JScrollPane(this.dataTableCatComd), BorderLayout.CENTER);
	    
	    this.reloadCatTable();
	    this.dataTableCatComd.addMouseListener(new MouseAdapter (){
			public void mouseClicked(MouseEvent e) {
				int i=FrmMain.this.dataTableCatComd.getSelectedRow();
				if(i<0) {
					return;
				}
				BeanComd.currentComd=allCatComd.get(i);
				new FrmComdDetails().setVisible(true);
			}
	    	
	    });
	    
	}
	private void reloadCatTable(){//���ǲ������ݣ���Ҫ��ʵ�����滻
		try {
			allCat=FreshMarketUtil.CatManager.loadallCat();
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblCatData =  new Object[allCat.size()][tblCatTitle.length];
		for(int i=0;i<allCat.size();i++){
			for(int j=0;j<tblCatTitle.length;j++)
				tblCatData[i][j]=allCat.get(i).getCell(j);
		}
		tabCatModel.setDataVector(tblCatData,tblCatTitle);
		this.dataTableCat.validate();
		this.dataTableCat.repaint();
	}
	private void reloadCatComdTabel(int planIdx){
		if(planIdx<0) return;
		curCat=allCat.get(planIdx);
		try {
			allCatComd=FreshMarketUtil.ComdManager.loadComdCat(curCat.getCat_id());
		} catch (BaseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "����",JOptionPane.ERROR_MESSAGE);
			return;
		}
		tblCatComdData =new Object[allCatComd.size()][tblCatComdTitle.length];
		for(int i=0;i<allCatComd.size();i++){
			for(int j=0;j<tblCatComdTitle.length;j++)
				tblCatComdData[i][j]=allCatComd.get(i).getCell(j);
		}
		
		tabCatComdModel.setDataVector(tblCatComdData,tblCatComdTitle);
		this.dataTableCatComd.validate();
		this.dataTableCatComd.repaint();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.mntmShippingAddr) {
			FrmShippingAddr dlg=new FrmShippingAddr();
			dlg.setVisible(true);
		}
		else if(e.getSource()==this.mntmSeachComd){
			FrmSearchComd dlg=new FrmSearchComd();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmOrderdetail) {
			FrmOrderManager dlg=new FrmOrderManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmMyEval) {
			FrmMyEvalList dlg=new FrmMyEvalList();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmSearchMenu) {
			FrmMenuList dlg=new FrmMenuList();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmMyBlance) {
			FrmBalanceManager dlg=new FrmBalanceManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmNewMyCoupon) {
			FrmMyCoupon dlg=new FrmMyCoupon();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmMyVIP) {
			try {
				FreshMarketUtil.userManager.beVIP();
			} catch (BusinessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		else if (e.getSource()==this.mntmMyIfo) {
			FrmUserInfoManager dlg=new FrmUserInfoManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmChangPwd) {
			FrmChangePwd dlg=new FrmChangePwd();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmNewCart) {
			FrmCart dlg = null;
			try {
				dlg = new FrmCart();
			} catch (BaseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dlg.setVisible(true);
		}
		  else if (e.getSource()==this.mntmSystemCoupon) {
			FrmSystemCoupon dlg=new FrmSystemCoupon();
			dlg.setVisible(true);
		}
		
	}

}
