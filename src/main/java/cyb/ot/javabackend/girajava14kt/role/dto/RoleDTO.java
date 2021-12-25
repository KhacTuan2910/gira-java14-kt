package cyb.ot.javabackend.girajava14kt.role.dto;

import javax.validation.constraints.NotBlank;

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
	@NotBlank(message = "Role name can not be blank.")
	private String name;
	@NotBlank(message = "Role code can not be blank.")
	private String code;
	@NotBlank(message = "Role description can not be blank.")
	private String description;
	
}