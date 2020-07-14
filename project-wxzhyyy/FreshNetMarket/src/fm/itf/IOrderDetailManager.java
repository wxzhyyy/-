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
	public void addComdtoOrder(BeanOrder comdorder, BeanComd comd,int num) throws BaseException;

	/**
	 * ɾ�����������е���Ʒ
	 * @param od
	 * @throws BaseException
	 */
	public void deleteComdtoOrder(BeanOrderDetails od)throws BaseException;

	public float CalOriginalPriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;

	public float CalPrivilegePriceofComd(BeanOrder comdorder, BeanComd comd) throws BaseException;
	/**
	 *�޸Ĺ�����Ʒ������
	 * @param od
	 * @param num
	 * @throws BaseException
	 */
	public void modifyComdOrder(BeanOrderDetails od,int num) throws BaseException;

}
