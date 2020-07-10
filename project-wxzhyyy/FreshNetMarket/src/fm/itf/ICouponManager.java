package fm.itf;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import fm.model.BeanCoupon;
import fm.model.BeanUser;
import fm.util.BaseException;

public interface ICouponManager {

	/**
	 * ����ϵͳ���п���ȡ���Ż�ȯ
	 * Ҫ���Ż�ȯ�Ľ���ʱ�����ڵ�ǰʱ��
	 * @return
	 * @throws BaseException
	 */
	public List<BeanCoupon> loadAllSystemCoupons() throws BaseException;
	/**
	 * ���ظ��û�����ӵ�е��Ż�ȯ
	 * �����û������ѹ��ڵ��Ż�ȯ
	 * @param u
	 * @return
	 * @throws BaseException
	 */
	public List<BeanCoupon> loadAllUserCoupons(BeanUser u) throws BaseException;
	/**
	 * z����Ա�����Ż�ȯ
	 * �����Ż�ȯ�ļ�飬���ü۸��Ż�ȯ�Żݶ��ֹʱ��
	 * @param couponcontent
	 * @param couponfitmoney
	 * @param couponprice
	 * @param couponstarttime
	 * @param couponendtime
	 * @throws BaseException
	 */
	
	public void addSystemCoupons(String couponcontent, float couponfitmoney, float couponprice,String couponstarttime, String couponendtime) throws BaseException;
/**
 * ����Աɾ��ϵͳ�Ż�ȯ
 * ���б���ȡ��δʹ�õĲ��ܱ�ɾ��
 * @param coupon
 * @throws BaseException
 */
	public void deleteSystemCoupons(BeanCoupon coupon) throws BaseException;
	/**
	 * 
	 * @param coupon
	 * @param couponcontent
	 * @param couponfitmoney
	 * @param couponprice
	 * @param couponstarttime
	 * @param couponendtime
	 * @throws BaseException
	 */
	public void modifySystemCoupons(BeanCoupon coupon,String couponcontent, float couponfitmoney, float couponprice,String couponstarttime, String couponendtime)throws BaseException;
	
	/**
	 * �û�ѡ�����Ż�ȯ
	 * ��ͬ��ŵ��Ż�ȯֻ�ܻ��һ��
	 * �û���ʹ�õ��Ż�ȯ����user_coupon���б�ɾ��
	 * �û���ʹ�õĵ��Ż�ȯ�޷��ٴ���ȡ����ѯ��Ʒ������
	 * @param user
	 * @param coupon
	 * @throws BaseException
	 */
	public void addUserCoupons(BeanUser user, BeanCoupon coupon) throws BaseException;
	/**
	 * �û��ڶ�����ȷ��ʹ���Ż�ȯ����Ż�ȯ��user_coupon�ͻᱻɾ��
	 * @param user
	 * @param coupon
	 * @throws BaseException
	 */
	public void useUserCoupon(BeanUser user, BeanCoupon coupon) throws BaseException;
}
