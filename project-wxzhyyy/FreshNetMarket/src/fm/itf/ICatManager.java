package fm.itf;

import java.util.List;

import fm.model.BeanCat;
import fm.util.BaseException;

public interface ICatManager {

	/**
	 * ��ӷ���
	 * �ж���������Ƿ��ظ������Ѵ������޷����
	 * @param catname
	 * @param catdescribe
	 * @throws BaseException
	 */
	public void addCat(String catname, String catdescribe) throws BaseException;
	
	/**
	 * ɾ������
	 * ���������»�������Ʒ���޷�ɾ��
	 * @param cat
	 * @throws BaseException
	 */
	public void deleteCat(BeanCat cat) throws BaseException;
	
	/**
	 * �޸�������Ϣ
	 * �ж����������Ƿ��Ѵ��ڣ��Ѵ��ڲ��ɸ���
	 * @param cat
	 * @param catname
	 * @param catdescribe
	 * @throws BaseException
	 */
	public void modifyCat(BeanCat cat, String catname, String catdescribe) throws BaseException;
	/**
	 * �����������
	 * @return
	 * @throws BaseException
	 */
	public List<BeanCat> loadallCat() throws BaseException;
}
