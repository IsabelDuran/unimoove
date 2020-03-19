package unimoove.cars;

public class MaxCarsPerUserReached extends Exception {
	private static final long serialVersionUID = 1L;
	public MaxCarsPerUserReached(String errorMessage) {
        super(errorMessage);
    }
	
}