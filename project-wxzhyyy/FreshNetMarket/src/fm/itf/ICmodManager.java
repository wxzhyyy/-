package fm.itf;
 
import fm.util.BaseException;

import java.util.List;

import fm.model.BeanComd;

public interface ICmodManager {
	/**
	 * ����������Ʒ
	 * @return
	 * @throws BaseException
	 */
	public List<BeanComd> loadall() throws BaseException;
	
	/**
	 * ������Ʒ
	 * ģ�����������ݹؼ���
	 * ��������д����������Ʒ����
	 * @param keyboard
	 * @return
	 * @throws BaseException
	 */
	public List<BeanComd> searchComd(String keyboard) throws BaseException;
	
	/**
	 * ����ĳһ������������Ʒ
	 * @param catid
	 * @return
	 * @throws BaseException
	 */
	public List<BeanComd> loadComdCat(String catid) throws BaseException;
	
	
	
	/**
	 * �����Ʒ
	 * ����Աִ��
	 * �ж���Ʒ�����Ƿ��ظ��������ظ����޷����
	 * @param comdname
	 * @param comdprice
	 * @param comdvipprice
	 * @param comdquantity
	 * @param comdspecif
	 * @param comddetail
	 * @throws BaseException
	 */
	public void addcomd(String catid, String comdname, float comdprice, float comdvipprice, int comdquantity, String comdspecif, String comddetail) throws BaseException;
	
	/**
	 * �޸���Ʒ��Ϣ
	 * ����Ա
	 * @param comdname
	 * @param comdprice
	 * @param comdvipprice
	 * @param comdquantity
	 * @param comdspecif
	 * @param comddetail
	 * @throws BaseException
	 */
	public void modifycomd(BeanComd comd,String comdname, float comdprice, float comdvipprice, int comdquantity, String comdspecif, String comddetail) throws BaseException;
	
	/**
	 * ɾ����Ʒ
	 * ����Ʒ������Ϊ0���������棬ȷ�����ɾ��
	 * @param comdname
	 * @param comdprice
	 * @param comdvipprice
	 * @param comdquantity
	 * @param comdspecif
	 * @param comddetail
	 * @throws BaseException
	 */
	public void deletecomd(BeanComd comd) throws BaseException;
	
	
}
