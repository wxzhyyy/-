package fm.itf;

import java.util.List;

import fm.model.BeanCoupon;
import fm.model.BeanOrder;
import fm.model.BeanShippingAddress;
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
	
	/**
	 * ѡ�񶩵��ĵ�ַ
	 * @param or
	 * @param sa
	 * @throws BaseException
	 */
	public void addOrderAddr(BeanOrder or, BeanShippingAddress sa) throws BaseException;
	
	/**
	 * ѡ������Ż�ȯ
	 * @param or
	 * @param cp
	 * @throws BaseException
	 */
	public void addOrderCoupon(BeanOrder or,BeanCoupon cp) throws BaseException;
	
	/**
	 * �����ܽ��
	 * @param or
	 * @return
	 * @throws BaseException
	 */
	public String OriginalPrice(BeanOrder or) throws BaseException;
	
	/**
	 * ����ʵ����֧��
	 * @param or
	 * @return
	 * @throws BaseException
	 */
	public String ActualPrice(BeanOrder or)throws BaseException;
	/**
	 * 
	 * @param or
	 * @throws BaseException
	 */
	public void OrderSubmit(BeanOrder or)throws BaseException;
	
	
	
}
