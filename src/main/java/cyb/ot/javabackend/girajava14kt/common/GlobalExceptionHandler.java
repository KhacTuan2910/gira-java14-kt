package cyb.ot.javabackend.girajava14kt.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cyb.ot.javabackend.girajava14kt.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = {
			NotFoundException.class
	})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Result was not found.")
	public Object handleNotFoundException(NotFoundException e) {
		log.debug("ERROR CATCHED : {}", e);
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.NOT_FOUND);
	}
	  
	@ExceptionHandler(value = {
			Exception.class
	})
	public Object handleUnexpectedException(Exception e) {
		
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
