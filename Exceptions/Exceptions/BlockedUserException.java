package Exceptions;

public class BlockedUserException extends Exception {
	
	public BlockedUserException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}
}
