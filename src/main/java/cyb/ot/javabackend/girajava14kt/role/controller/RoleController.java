package cyb.ot.javabackend.girajava14kt.role.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.dto.UpdateRoleDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Role Controller", description = "Api role")
public interface RoleController {
	
	@Operation(method = "get", description = "get all roles")
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "get roles successfully"),
			@ApiResponse(responseCode = "403", description = "do not have the correct authorization")
	})
	@GetMapping(value = "/roles", produces = "application/json")
	public ResponseEntity<Object> getRoles();
	
	@Operation(method = "post", description = "create new role")
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = "Invalid role"),
		@ApiResponse(responseCode = "200", description = "create role successfully")
	})
	@PostMapping(value = "/role")
	public ResponseEntity<Object> createRole(
				@Parameter(description = "role dto") @Valid @RequestBody RoleDTO dto,
				BindingResult bindingResult
			);
	
	@Operation(method = "put", description = "update role",
			responses = {
					@ApiResponse(responseCode = "400", description = "Invalid data"),
					@ApiResponse(responseCode = "200", description = "updated role successfully")
			})
	@PutMapping(value = "/role/{id}")
	public ResponseEntity<Object> updateRole(
			@Parameter(description = "role id") @PathVariable("id") long id,
			@Parameter(description = "role dto") @Valid @RequestBody UpdateRoleDTO dto,
				BindingResult bindingResult
			);
	
	@Operation(method = "delete", description = "detele role",
			responses = {
					@ApiResponse(responseCode = "400", description = "Invalid id"),
					@ApiResponse(responseCode = "200", description = "deteled role successfully")
			})
	@DeleteMapping(value = "/role/{id}")
	public ResponseEntity<Object> deleteRole(@Parameter(description = "role id") @PathVariable("id") long id);
}
