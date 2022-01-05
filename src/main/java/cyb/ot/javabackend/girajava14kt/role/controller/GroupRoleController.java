package cyb.ot.javabackend.girajava14kt.role.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cyb.ot.javabackend.girajava14kt.role.dto.GroupRoleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Group Role Controller", description = "Api group role")
public interface GroupRoleController {
	@Operation(method = "get", description = "get all group roles")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "get group roles successfully"),
		@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/grouproles", produces = "application/json")
	public ResponseEntity<Object> getGroupRoles();
	
	@Operation(method = "post", description = "create new group role")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "create group role successfully."),
		@ApiResponse(responseCode = "400", description = "Invalid group role.")
	})
	@PostMapping("/grouprole")
	public ResponseEntity<Object> createGroupRoles(
			@Parameter(description = "group role dto") @Valid @RequestBody GroupRoleDTO dto,
			BindingResult bindingResult);
}
