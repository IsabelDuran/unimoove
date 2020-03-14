package unimoove.api.utils;


public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException (int code, String msg) {
        super(code, msg);
    }
}
