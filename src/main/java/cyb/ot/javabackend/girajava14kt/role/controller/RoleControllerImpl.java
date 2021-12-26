package cyb.ot.javabackend.girajava14kt.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cyb.ot.javabackend.girajava14kt.common.ResponseHandler;
import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.role.model.Role;
import cyb.ot.javabackend.girajava14kt.role.service.RoleService;

@RestController
public class RoleControllerImpl implements RoleController {
	private RoleService service;
	
	public RoleControllerImpl(RoleService roleService) {
		service = roleService;
	}
	
	@Override
	public ResponseEntity<Object> getRoles() {
		List<RoleDTO> roles = service.findAllDTO();
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> createRole(RoleDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
			//return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		RoleDTO createRole = service.create(dto);
		
		return ResponseHandler.getResponse(createRole, HttpStatus.OK);
		//return new ResponseEntity<>(createRole, HttpStatus.OK);
	}

}
