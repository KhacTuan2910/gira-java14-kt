package cyb.ot.javabackend.girajava14kt.role.exception;

public class InvalidRoleException extends RuntimeException {
	public InvalidRoleException() {
		super();
	}
	
	public InvalidRoleException(String mess) {
		super(mess);
	}
	
	public InvalidRoleException(String mess, Throwable throwable) {
		super(mess, throwable);
	}
}
