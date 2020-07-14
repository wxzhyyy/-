package fm.itf;

import java.util.List;

import fm.model.BeanShippingAddress;
import fm.util.BaseException;

public interface IShippingAddressManager {
	

	/**
	 * �������е�ǰ�û���Ӧ�����͵�ַ
	 * @param userid
	 * @return
	 * @throws BaseException
	 */
	public List<BeanShippingAddress> loadAll(String userid) throws BaseException;
	/**
	 * ������͵�ַ
	 * @param userid
	 * @throws BaseException
	 */
	public void addShippingAddress(String userid, String province, String city, String cell, String address, String linkman, String phone) throws BaseException;
	
	/**
	 * ɾ�����͵�ַ
	 * @param userid
	 * @throws BaseException
	 */
	public void deleteShippingAddress(BeanShippingAddress sa) throws BaseException;
	/**
	 * �޸����͵�ַ
	 * @param userid
	 * @throws BaseException
	 */
	public void modifyShippingAddress(BeanShippingAddress sa, String province, String city, String cell, String address, String linkman, String phone) throws BaseException;
}
