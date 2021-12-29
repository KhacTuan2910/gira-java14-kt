package cyb.ot.javabackend.girajava14kt.role.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupRoleDTO {

	private long id;
	@NotBlank(message = "Group Role name can not be blank.")
	private String name;
	@NotBlank(message = "Group Role code can not be blank.")
	private String code;
	@NotBlank(message = "Group Role description can not be blank.")
	private String description;
}
