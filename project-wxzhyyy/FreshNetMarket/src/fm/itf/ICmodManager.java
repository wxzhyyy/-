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
}
