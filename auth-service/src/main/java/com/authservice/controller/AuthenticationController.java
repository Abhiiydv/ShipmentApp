package com.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.authservice.entity.User;
import com.authservice.service.AuthenticationService;
import com.authservice.service.JwtRefreshTokenService;
import com.authservice.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/authentication")
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private JwtRefreshTokenService jwtRefreshTokenService;


	@Autowired
	private UserService userService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/sign-up")
	public ResponseEntity<?> signUp(@RequestBody User user) {

		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);

	}

	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@RequestBody User user) {
		System.out.println("Inside signIn controller");
		return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
	}

	/*
	 * @GetMapping("/physicians") public List<Physician> fetchAllPhysicians() {
	 * return physicianServ.fetchAllPhysicians(); }
	 * 
	 * @PostMapping("/submit") public Integer submitClaim(@RequestBody Claim claim)
	 * throws Exception { Claim obj = (Claim)
	 * restTemplate.postForObject("http://claim-service//submit/", claim,
	 * Claim.class);
	 * 
	 * return obj.getClaim_id(); }
	 */

	// api/authentication/refresh-token?token=
	@PostMapping("refresh-token")
	public ResponseEntity<?> refreshToken(@RequestParam String token) {
		return ResponseEntity.ok(jwtRefreshTokenService.generateAccessTokenFromRefreshToken(token));
	}

	/*
	 * @PostMapping("/sign-up") public ResponseEntity<?>signUp(@RequestBody User
	 * user) { if(userService.findByUsername(user.getUserName()).isPresent()) {
	 * return new ResponseEntity<>(HttpStatus.CONFLICT); } return new
	 * ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED); }
	 */

}
