package Exceptions;

import java.util.Arrays;

public class MaintenanceNotFoundException extends Exception {


	public MaintenanceNotFoundException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}
	}
