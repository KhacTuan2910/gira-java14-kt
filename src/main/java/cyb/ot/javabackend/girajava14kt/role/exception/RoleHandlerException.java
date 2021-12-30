package cyb.ot.javabackend.girajava14kt.role.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cyb.ot.javabackend.girajava14kt.common.ResponseHandler;

@RestControllerAdvice
public class RoleHandlerException {
	@ExceptionHandler(InvalidRoleException.class)
	public Object handleINvalidROleException(InvalidRoleException e) {
		return ResponseHandler.getErrorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
