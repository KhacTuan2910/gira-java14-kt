package cyb.ot.javabackend.girajava14kt.role.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cyb.ot.javabackend.girajava14kt.role.model.Role;

@RestController
public class RoleControllerImpl implements RoleController {
	
	@Override
	public ResponseEntity<List<Role>> getRoles() {
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
