/****************************************************************************************************************************
 - File Name        : Register Service Exception
 - Author           : Punit Kumar
 - Creation Date    : 13-06-2020
 - Description      : This is a exception class to throw the exception for Employee not found.
  ****************************************************************************************************************************/ 

package com.capgemini.greatoutdoor.registrationmanagement.exception;

public class EmployeeNotFoundException extends Exception {

	/****************************************************************************************************************************
	 - Method Name      : EmployeeNotFoundException
	 - Input Parameters : String message
	 - Author           : Punit Kumar
	 - Creation Date    : 13-06-2020
	 - Description      : For handling the exception with custom message.
	  ****************************************************************************************************************************/ 
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
