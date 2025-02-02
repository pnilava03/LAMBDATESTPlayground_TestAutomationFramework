/**
 * 
 */
package com.LAMBDATEST_Playground.Exceptions;

/**
 * 
 */
@SuppressWarnings("serial")
public final class EnvironmentTypeNotMatchException extends RuntimeException {

	public EnvironmentTypeNotMatchException() {
		super();
	}
	
	
	public EnvironmentTypeNotMatchException(String errorMsg) {
		super(errorMsg);
	}
	
}
