package unimoove.reservations;

public class FullTripException extends Exception {
	private static final long serialVersionUID = 1L;
	public FullTripException(String errorMessage) {
        super(errorMessage);
    }
}
