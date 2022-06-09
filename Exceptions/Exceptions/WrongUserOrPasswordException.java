package Exceptions;

public class WrongUserOrPasswordException extends Exception {

	public WrongUserOrPasswordException(String msg) {
		super(msg);
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
