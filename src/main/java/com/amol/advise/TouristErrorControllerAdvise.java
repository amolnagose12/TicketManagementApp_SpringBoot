package com.amol.advise;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.amol.error.ErrorDetails;
import com.amol.exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristErrorControllerAdvise {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails>handleTouristNotFound(TouristNotFoundException tf){
		System.out.println("TouristErrorControllerAdvise.handleTouristNotFound");
		
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),tf.getMessage(),"404-NOTFOUND");
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllproblem(Exception e){
		System.out.println("TouristErrorControllerAdvise.handleAllproblem");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),e.getMessage(),"404-NOTFOUND");
		
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.NOT_FOUND);
	}
	

}
