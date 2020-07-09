package fm.itf;

import java.util.List;

import fm.model.BeanComd;
import fm.model.BeanOrder;
import fm.model.BeanOrderDetails;
import fm.util.BaseException;

public interface IOrderDetailManager {

	/**
	 * ������ϸ
	 * @param orderid
	 * @return
	 * @throws BaseException
	 */
	public List<BeanOrderDetails> loadAll(BeanOrder comdorder) throws BaseException;
	
	/**
	 * �ڶ�����������Ʒ
	 * ����Ʒ�Ѵ�����������һ
	 * �������ڣ�������һ����¼
	 * @param orderid
	 * @param comdid
	 * @param orderquantity
	 * @throws BaseException
	 */
	public void addComdtoOrder(BeanOrder comdorder, BeanComd comd) throws BaseException;
	/**
	 * �ڶ����ڼ�����Ʒ
	 * ����Ʒ��������1����������һ
	 * ����Ʒ����С��1����ɾ����¼
	 * @param orderid
	 * @param comdid
	 * @param orderquantity
	 * @throws BaseException
	 */
	public void reduceComdtoOrder(BeanOrder comdorder, BeanComd comd) throws BaseException;
	/**
	 * ������Ʒ��ԭ�۸�
	 * @param comdorder
	 * @param comd
	 * @return
	 * @throws BaseException
	 */
//	public float CalOriginalPriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;
//	/**
//	 * ������Ʒ�Żݺ�ļ۸�
//	 * @param comdorder
//	 * @param comd
//	 * @return
//	 * @throws BaseException
//	 */
//	public float CalPrivilegePriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;
//	

	public float CalOriginalPriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;

	public float CalPrivilegePriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;
}
