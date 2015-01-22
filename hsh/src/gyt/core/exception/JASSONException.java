package gyt.core.exception;


/**
 *	业务异常
 *
 * 	需要主动拦截的业务异常
 */
@SuppressWarnings("serial")
public class JASSONException extends Exception{

	public JASSONException(String message) {
		super(message);
	}

}
