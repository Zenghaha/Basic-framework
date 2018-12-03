package com.ud.basic.security.exception;

import org.springframework.security.core.AuthenticationException;

public class BadAuthCodeException extends AuthenticationException {
	// ~ Constructors
	// ===================================================================================================

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a <code>BadCredentialsException</code> with the specified message.
	 *
	 * @param msg the detail message
	 */
	public BadAuthCodeException(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>BadCredentialsException</code> with the specified message and
	 * root cause.
	 *
	 * @param msg the detail message
	 * @param t root cause
	 */
	public BadAuthCodeException(String msg, Throwable t) {
		super(msg, t);
	}
}