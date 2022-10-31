package org.maven.spring.library.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5831360231161366128L;
	String message;

	public ResourceNotFoundException(String message) {
		this.message = message;
	}
}
