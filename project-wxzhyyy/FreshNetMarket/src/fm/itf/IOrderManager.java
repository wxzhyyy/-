package fm.itf;

import java.util.List;

import fm.model.BeanOrder;
import fm.model.BeanUser;
import fm.util.BaseException;

public interface IOrderManager {
	/**
	 * ���ظ��û��ĵ�ǰ������δ�ύ�������ﳵʹ�ã�
	 * Ѱ�Ҹ��û����һ������
	 * �ж����һ������״̬
	 * �����һ��������״̬�����½�����
	 * ����״̬����¸ö�������������Ϊ��ǰ����
	 * @param user
	 * @return
	 * @throws BaseException
	 */
	public BeanOrder loadlastOrder()throws BaseException;
	
	/**
	 * ���ص�ǰ�û������ж���
	 * @return
	 * @throws BaseException
	 */
	public List<BeanOrder> loadallOrder()throws BaseException;
	/**
	 * ����״̬��һ��
	 * @param or
	 * @throws BaseException
	 */
	public void nextStatus(BeanOrder or)throws BaseException;
	/**
	 * �˵�
	 * @param or
	 * @throws BaseException
	 */
	public void backOrder(BeanOrder or)throws BaseException;
	
	/**
	 * ����������ȷ���µ�
	 * @return 
	 * @throws BaseException
	 */
	public BeanOrder creatOrder() throws BaseException;
	
}
