package fm.util;

public class DbException extends BaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbException(java.lang.Throwable ex){
		super("���ݿ��������"+ex.getMessage());
	}
}
