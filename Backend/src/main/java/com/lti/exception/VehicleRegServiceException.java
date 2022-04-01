package com.lti.exception;

/**
 * Exception class- if vehicle already registered
 * @author Urjita Kerkar
 */
public class VehicleRegServiceException extends RuntimeException {

	public VehicleRegServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VehicleRegServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public VehicleRegServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VehicleRegServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VehicleRegServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
