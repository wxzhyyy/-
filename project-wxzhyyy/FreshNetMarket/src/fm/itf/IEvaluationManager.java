package fm.itf;

import java.util.List;

import fm.model.BeanEvaluation;
import fm.util.BaseException;

public interface IEvaluationManager {

	/**
	 * ����һ����Ʒ����������
	 * @param comdid
	 * @return
	 * @throws BaseException
	 */
	public List<BeanEvaluation> loadEvalComd(String comdid)throws BaseException;
	
	/**
	 * ����һ���û���������������
	 * @param userid
	 * @return
	 * @throws BaseException
	 */
	public List<BeanEvaluation> loadEvalUser(String userid) throws BaseException;
	
	
	/**
	 * �������
	 * @param userid
	 * @param comdid
	 * @param evalcontent
	 * @param evalstar
	 * @throws BaseException
	 */
	public void addComdEval(String userid, String comdid, String evalcontent, int evalstar) throws BaseException;

	/**
	 * ɾ������
	 * ����Ա���߷������۵��˿�ִ�иò���
	 * @param eva
	 * @throws BaseException
	 */
	public void deleteComdEval(BeanEvaluation eva) throws BaseException;
	/**
	 * �޸�����
	 * ֻ�з������۵��û���ִ��
	 * @param eva
	 * @param evalcontent
	 * @param evalstar
	 * @throws BaseException
	 */
	public void modifyComdEval(BeanEvaluation eva, String evalcontent, int evalstar) throws BaseException;
	
	
}
