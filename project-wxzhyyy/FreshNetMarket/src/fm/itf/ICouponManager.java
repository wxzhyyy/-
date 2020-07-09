package fm.itf;

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
	
	public void addSystemCoupons(String couponcontent, float couponfitmoney, float couponprice,Date couponstarttime, Date couponendtime) throws BaseException;
}
