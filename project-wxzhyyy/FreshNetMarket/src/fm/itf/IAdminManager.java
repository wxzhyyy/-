package fm.itf;

import fm.model.BeanAdmin;
import fm.util.BaseException;

public interface IAdminManager {
	/**
	 * ע�᣺
	 * Ҫ���û�������
	 * ����������������һ�£����벻��Ϊ��
	 * ���ע��ʧ�ܣ����׳��쳣
	 * @param adminid
	 * @param pwd  ����
	 * @param pwd2 �ظ����������
	 * @return
	 * @throws BaseException
	 */
	public BeanAdmin reg(String adminname, String pwd,String pwd2) throws BaseException;
	/**
	 * ��½
	 * 1������û������ڻ�����������׳�һ���쳣
	 * 2�������֤�ɹ����򷵻ص�ǰ�û���Ϣ
	 * @param adminid
	 * @return
	 * @throws BaseException
	 */
	public BeanAdmin login(String adminname)throws BaseException;
	/**
	 * �޸�����
	 * ���û�гɹ��޸ģ����׳��쳣
	 * @param admin    ��ǰ�û�
	 * @param oldPwd  ԭ����
	 * @param newPwd  ������
	 * @param newPwd2 �ظ������������
	 */
	public void changePwd(BeanAdmin admin, String oldPwd,String newPwd, String newPwd2)throws BaseException;
	
}
