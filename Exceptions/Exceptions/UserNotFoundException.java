package Exceptions;

public class UserNotFoundException extends Exception {

	public UserNotFoundException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
