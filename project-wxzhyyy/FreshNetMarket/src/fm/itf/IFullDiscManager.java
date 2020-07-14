package fm.itf;

import java.util.List;

import fm.model.BeanCoupon;
import fm.model.BeanFullDisc;
import fm.util.BaseException;

public interface IFullDiscManager {

	/**
	 * �������е��������ۻ
	 * @return
	 * @throws BaseException
	 */
	public List<BeanFullDisc> loadAllSystemFullDiscs()throws BaseException;
	/**
	 * ����Ա������ۻ
	 * @param discid
	 * @param content
	 * @param number
	 * @param discount
	 * @param starttime
	 * @param endtime
	 * @throws BaseException
	 */
	public void addSystemFullDiscs(String content,String number,String discount,String
			 starttime,String endtime) throws BaseException;

	/**
	 * ɾ��������Ա�ſ���
	 * @param fulldisc
	 * @throws BaseException
	 */
	public void deleteSystemFullDisc(BeanFullDisc fulldisc) throws BaseException;
	
	/**
	 * ����Ա�޸����ۻ
	 * @param fulldisc
	 * @param content
	 * @param number
	 * @param discount
	 * @param starttime
	 * @param endtime
	 * @throws BaseException
	 */
	public void modifySystemFullDisc(BeanFullDisc fulldisc,String content,String number,String discount,String
			 starttime,String endtime)throws BaseException;
	
}
