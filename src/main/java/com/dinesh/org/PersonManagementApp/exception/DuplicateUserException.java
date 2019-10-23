package com.dinesh.org.PersonManagementApp.exception;

public class DuplicateUserException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String message;

	public DuplicateUserException(String message)
	{
		super();
		this.message = message;
	}

	public DuplicateUserException()
	{
		super();
	}
	
	
}
