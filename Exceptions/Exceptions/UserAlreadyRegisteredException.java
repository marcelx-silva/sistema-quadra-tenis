package Exceptions;

public class UserAlreadyRegisteredException extends Exception{

private String email;
	
	public UserAlreadyRegisteredException(String message, String email) {
		super(message);
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return getMessage();
	}
}
