package fm.control;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import fm.itf.ICatManager;
import fm.model.BeanCat;
import fm.util.BaseException;
import fm.util.BusinessException;
import fm.util.DBUtil;
import fm.util.DbException;

public class CatManager implements ICatManager{

	@Override
	public void addCat(String catname, String catdescribe) throws BaseException {
		// TODO Auto-generated method stub
		BeanCat cat=new BeanCat();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from category where cat_name=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, catname);
			java.sql.ResultSet rs=pst.executeQuery();
			if(rs.next()) throw new BusinessException("������Ѵ���");
			System.out.print(1);
			sql="select max(cat_id+0) from category";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			rs.next();
			if (rs.getString(1)!=null) {
				cat.setCat_id(rs.getString(1));
				int num=Integer.parseInt(cat.getCat_id().trim());
				num=num+1;
				cat.setCat_id(String.valueOf(num));
				System.out.print(num);
			}else {
				cat.setCat_id("1");
			}
			
			sql="insert into category(cat_id,cat_name,cat_describe) values(?,?,?)";
			pst=conn.prepareStatement(sql);
			pst.setString( 1, cat.getCat_id());
			pst.setString(2, catname);
			pst.setString(3, catdescribe);
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	@Override
	public void deleteCat(BeanCat cat) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			//�жϸ÷�����������Ʒ
			String sql="select * from commodity where cat_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, cat.getCat_id());
			System.out.print(cat.getCat_id());
			java.sql.ResultSet rs=pst.executeQuery();
			//System.out.print(rs.next());
			while(rs.next()) {
				if (rs.getString(1) != null) {
					JOptionPane.showMessageDialog(null, "�÷����д�����Ʒ���޷�ɾ��", "��ʾ", JOptionPane.ERROR_MESSAGE);
					throw new BusinessException("�÷����д�����Ʒ���޷�ɾ��");
				}
			}
			sql="delete from category where cat_id=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, cat.getCat_id());
			pst.execute();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}

	@Override
	public List<BeanCat> loadallCat() throws BaseException {
		// TODO Auto-generated method stub
		List<BeanCat> result=new ArrayList<BeanCat>();
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from category";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			java.sql.ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				BeanCat c=new BeanCat();
				c.setCat_id(rs.getString(1));
				c.setCat_name(rs.getString(2));
				c.setCat_describe(rs.getString(3));
				result.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
	@Override
	public void modifyCat(BeanCat cat, String catname, String catdescribe) throws BaseException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
//			String sql="select * from category where cat_name=?";
//			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//			pst.setString(1, catname);
//			java.sql.ResultSet rs=pst.executeQuery();
//			if (rs.next()) throw new BusinessException("������Ѵ��ڣ��޷��޸�");
			String sql="update category set cat_name=?, cat_describe=? where cat_id=?";
			java.sql.PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, catname);
			pst.setString(2, catdescribe);
			pst.setString(3, cat.getCat_id());
			pst.executeUpdate();
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public static void main(String args[]){
		CatManager cm=new CatManager();
		try {
			BeanCat cat=new BeanCat();
			cat.setCat_id("3");
			/* ��ӷ��ຯ������ */
//			cm.addCat("�����","�ɿɿɿɿɰ���");
			/*ɾ�����ຯ������*/
			
			//cm.deleteCat(cat);
			/*�޸ķ��ຯ������*/
//			cm.modifyCat(cat, "ˮ��", "��ţ��");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
