package cyb.ot.javabackend.girajava14kt.role.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cyb.ot.javabackend.girajava14kt.role.validation.validator.UniqueRoleCodeValidator;
import cyb.ot.javabackend.girajava14kt.role.validation.validator.UniqueRoleNameValidator;

@Constraint(validatedBy = UniqueRoleCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueRoleCode {
	String message() default "Role code is used.";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
