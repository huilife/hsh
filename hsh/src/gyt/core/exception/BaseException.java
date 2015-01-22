package gyt.core.exception;


/**
 *	中断异常
 *
 *	不需要主动拦截，当异常发生时，用于阻断线程执行
 */
@SuppressWarnings("serial")
public class BaseException extends RuntimeException{
	
	public BaseException(Throwable e)
	{
		super(e);
	}

	public BaseException(String message, Throwable e) {
		super(message,e);
	}

}
