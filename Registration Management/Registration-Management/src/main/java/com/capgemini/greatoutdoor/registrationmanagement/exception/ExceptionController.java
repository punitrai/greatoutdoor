package com.capgemini.greatoutdoor.registrationmanagement.exception;


import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleException(EmployeeNotFoundException e) {
		return e.getMessage();
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	   public Map<String,String> handleContraintViolation(ConstraintViolationException ex){
		Map<String, String> errors = new HashMap<>();
	    
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", cv.getPropertyPath().toString());
	    }); 
	 
	    return errors;
	} 
}
