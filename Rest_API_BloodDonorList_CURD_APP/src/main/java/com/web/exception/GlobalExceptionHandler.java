package com.web.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<Map<String ,String>> handleMethodArgumentException(MethodArgumentNotValidException ex){
	Map<String,String> errors=new HashMap<>();
	List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
	for(int i=0;i<fieldErrors.size();i++) {
		FieldError error = fieldErrors.get(i);
		String fieldName=error.getField();
		String errorMessage=error.getDefaultMessage();
		
		errors.put(fieldName, errorMessage);
		
		
		
	}
	
	
	return new ResponseEntity<Map<String,String>>(errors,HttpStatus.BAD_REQUEST);
}
@ExceptionHandler(DonorNotFoundException.class)
public ResponseEntity<String> handleDonorNotFoundException(DonorNotFoundException ex) {
    return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
}


@ExceptionHandler(TransactionSystemException.class)
public ResponseEntity<String> handleTransactionException(TransactionSystemException ex) {
    return new ResponseEntity<>("Transaction failed: " + ex.getMostSpecificCause().getMessage(), HttpStatus.BAD_REQUEST);
}

}
