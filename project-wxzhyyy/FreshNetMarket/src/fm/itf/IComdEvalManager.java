package fm.itf;

import java.util.List;

import fm.model.BeanComd;
import fm.model.BeanEvaluation;
import fm.util.BaseException;

public interface IComdEvalManager {
	/**
	 * һ����Ʒ�ջ������
	 * @param comd
	 * @return
	 * @throws BaseException
	 */
	public List<BeanEvaluation> loadComdEval(BeanComd comd)throws BaseException;
	
	/**
	 * �������й��������Ʒ
	 * @return
	 * @throws BaseException
	 */
	public List<BeanComd> allbuycomd() throws BaseException;
	
	/**
	 * �������
	 * @param comd
	 * @param content
	 * @param star
	 * @throws BaseException
	 */
	public void addeval(BeanComd comd, String content,String star) throws BaseException;
	
	
}
