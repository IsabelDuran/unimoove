package unimoove.api.utils;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-14T00:59:07.824+01:00[Europe/Madrid]")
public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException (int code, String msg) {
        super(code, msg);
    }
}
