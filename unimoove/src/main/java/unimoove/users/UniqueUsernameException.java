package unimoove.users;

public class UniqueUsernameException extends Exception {
	private static final long serialVersionUID = 1L;
	public UniqueUsernameException(String errorMessage) {
        super(errorMessage);
    }
	
}