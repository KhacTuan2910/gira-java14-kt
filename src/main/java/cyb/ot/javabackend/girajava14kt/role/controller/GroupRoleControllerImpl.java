package cyb.ot.javabackend.girajava14kt.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cyb.ot.javabackend.girajava14kt.common.ResponseHandler;
import cyb.ot.javabackend.girajava14kt.role.dto.GroupRoleDTO;
import cyb.ot.javabackend.girajava14kt.role.service.GroupRoleService;

@RestController
public class GroupRoleControllerImpl implements GroupRoleController {

	private GroupRoleService service;
	
	public GroupRoleControllerImpl(GroupRoleService service) {
		this.service = service;
	}
	
	@Override
	public ResponseEntity<Object> getGroupRoles() {
		List<GroupRoleDTO> grouproles = service.findAllDTO();
		
		return ResponseHandler.getResponse(grouproles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createGroupRoles(@Valid GroupRoleDTO dto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		GroupRoleDTO createdGroupRole = service.create(dto);
		
		return ResponseHandler.getResponse(createdGroupRole, HttpStatus.OK);
	}

}
