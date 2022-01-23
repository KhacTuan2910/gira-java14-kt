package cyb.ot.javabackend.girajava14kt.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import cyb.ot.javabackend.girajava14kt.common.ResponseHandler;
import cyb.ot.javabackend.girajava14kt.role.dto.RoleDTO;
import cyb.ot.javabackend.girajava14kt.user.dto.CreateUserDTO;
import cyb.ot.javabackend.girajava14kt.user.service.UserService;

@RestController
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService service;
	
	@Override
	public ResponseEntity<Object> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Object> createUser(@Valid CreateUserDTO dto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseHandler.getErrorResponse(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
			//return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		CreateUserDTO createdUser = service.create(dto);
		
		
		return ResponseHandler.getResponse(createdUser, HttpStatus.OK);
	}

}
