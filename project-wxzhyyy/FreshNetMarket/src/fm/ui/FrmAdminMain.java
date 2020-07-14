package fm.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmAdminMain extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private	JMenu mnInfoMaintain = new JMenu("��Ϣά��");
	private	JMenuItem mntmFullDiscManager = new JMenuItem("���۹���");
	private	JMenuItem mntmCouponManager = new JMenuItem("�Ż�ȯ����");
	private	JMenuItem mntmComdManager = new JMenuItem("��Ʒ����");
	private	JMenuItem mntmPromotionManager = new JMenuItem("��ʱ������Ʒ����");
	private JMenuItem mntmCatManager = new JMenuItem("�������");
	private JMenuItem mntmComdPurc = new JMenuItem("��Ʒ�ɹ�");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAdminMain frame = new FrmAdminMain();
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
	public FrmAdminMain() {
		setTitle("���ã�����Ա");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 788);
		
		
		setJMenuBar(menuBar);
		menuBar.add(mnInfoMaintain);
		mnInfoMaintain.add(mntmFullDiscManager);
		mnInfoMaintain.add(mntmCouponManager);
		mnInfoMaintain.add(mntmComdManager);
		
		mnInfoMaintain.add(mntmCatManager);
		this.mntmCatManager.addActionListener(this);
		
		mnInfoMaintain.add(mntmComdPurc);
		mnInfoMaintain.add(mntmPromotionManager);
		
		this.mntmFullDiscManager.addActionListener(this);
		this.mntmPromotionManager.addActionListener(this);
		this.mntmCouponManager.addActionListener(this);
		this.mntmComdManager.addActionListener(this);
		this.mntmComdPurc.addActionListener(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==this.mntmFullDiscManager) {
			FrmFullDiscManager dlg=new FrmFullDiscManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmPromotionManager) {
			FrmPromotionManager dlg=new FrmPromotionManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmCouponManager) {
			FrmCouponManager dlg = new FrmCouponManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmComdManager) {
			FrmComdManager dlg = new FrmComdManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmCatManager) {
			FrmCatManager dlg = new FrmCatManager();
			dlg.setVisible(true);
		}
		else if (e.getSource()==this.mntmComdPurc) {
			FrmComdPurcManager dlg = new FrmComdPurcManager();
			dlg.setVisible(true);
		}
	}

}
