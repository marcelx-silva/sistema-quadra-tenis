package Exceptions;

public class CourtAlreadyRegisteredException extends Exception {

	public CourtAlreadyRegisteredException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
