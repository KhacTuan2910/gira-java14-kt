package cyb.ot.javabackend.girajava14kt.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth Controller", description = "Api Auth")
public interface AuthController {
	@Operation(method = "post", description = "genarate fake token")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "genarated token successfully."),
		@ApiResponse(responseCode = "403", description = "Error.")
	})
	@PostMapping(value = "/api/fake-token", produces = "application/json")
	public ResponseEntity<Object> createTemporatyToken(
			@RequestParam(value = "username", defaultValue = "tuannguyen") String username);
	
	@Operation(method = "post", description = "verify fake token")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "verify token successfully."),
		@ApiResponse(responseCode = "403", description = "Error.")
	})
	@PostMapping(value = "/api/verify-token", produces = "application/json")
	public ResponseEntity<Object> verifyFakeToken(
			@RequestBody String token);
}
