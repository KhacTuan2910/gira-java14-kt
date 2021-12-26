package cyb.ot.javabackend.girajava14kt.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cyb.ot.javabackend.girajava14kt.role.model.Role;
import cyb.ot.javabackend.girajava14kt.role.service.RoleService;
import cyb.ot.javabackend.girajava14kt.role.validation.annotation.UniqueRoleCode;

public class UniqueRoleCodeValidator implements ConstraintValidator<UniqueRoleCode, String> {
	@Autowired
	private RoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueRoleCode uniqueRoleCodeAnnotation) {
		ConstraintValidator.super.initialize(uniqueRoleCodeAnnotation);
		this.message = uniqueRoleCodeAnnotation.message();
	}

	@Override
	public boolean isValid(String roleCode, ConstraintValidatorContext context) {
		Optional<Role> roleOpt = service.findByCode(roleCode);
		
		if (!roleOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		return false;
	}
	
}
