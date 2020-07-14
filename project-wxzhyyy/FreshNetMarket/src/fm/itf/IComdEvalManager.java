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
}
