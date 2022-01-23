package cyb.ot.javabackend.girajava14kt.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cyb.ot.javabackend.girajava14kt.common.ResponseHandler;
import cyb.ot.javabackend.girajava14kt.security.jwt.JwtUtils;

@RestController
public class AuthControllerImpl implements AuthController {
	@Autowired
	private JwtUtils jwtUtils;

	@Override
	public ResponseEntity<Object> createTemporatyToken(String username) {
		String token = jwtUtils.genarateJwtFakeToken(username);
		
		return ResponseHandler.getResponse(token, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Object> verifyFakeToken(String token) {
		boolean isValid = jwtUtils.validateJwtToken(token);
		return ResponseHandler.getResponse(isValid, HttpStatus.OK);
	}

}
