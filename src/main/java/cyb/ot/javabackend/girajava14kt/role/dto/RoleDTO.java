package cyb.ot.javabackend.girajava14kt.role.dto;

import javax.validation.constraints.NotBlank;

import cyb.ot.javabackend.girajava14kt.role.validation.annotation.UniqueRoleCode;
import cyb.ot.javabackend.girajava14kt.role.validation.annotation.UniqueRoleName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
	private long id;
	
	@NotBlank(message = "{role.name.not-blank}")
	@UniqueRoleName(message = "This role name can be used. Please choose other.")
	private String name;
	
	@NotBlank(message = "{role.code.not-blank}")
	@UniqueRoleCode(message = "This role code can be used. Please choose other.")
	private String code;
	@NotBlank(message = "{role.description.not-blank}")
	private String description;
	
}
