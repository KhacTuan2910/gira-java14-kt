package cyb.ot.javabackend.girajava14kt.role.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cyb.ot.javabackend.girajava14kt.role.model.Role;
import cyb.ot.javabackend.girajava14kt.role.service.RoleService;
import cyb.ot.javabackend.girajava14kt.role.validation.annotation.UniqueRoleName;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName, String> {
	@Autowired
	private RoleService service;
	private String message;
	
	@Override
	public void initialize(UniqueRoleName uniqueRoleNameAnnotation) {
		ConstraintValidator.super.initialize(uniqueRoleNameAnnotation);
		this.message = uniqueRoleNameAnnotation.message();
	}
	
	@Override
	public boolean isValid(String roleName, ConstraintValidatorContext context) {
		Optional<Role> roleOpt = service.findByName(roleName);
		
		if (!roleOpt.isPresent()) {
			return true;
		}
		
		context.buildConstraintViolationWithTemplate(this.message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
