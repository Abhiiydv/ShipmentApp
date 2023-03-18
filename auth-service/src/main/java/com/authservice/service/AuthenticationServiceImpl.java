package com.authservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.authservice.entity.User;
import com.authservice.security.UserPrincipal;
import com.authservice.security.jwt.JwtProvider;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private JwtRefreshTokenService jwtRefreshTokenService;

	@Override
	public User signInAndReturnJWT(User signInRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(signInRequest.getUserName(), signInRequest.getPassword()));

		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		String jwt = jwtProvider.generateToken(userPrincipal);

		User signInUser = userPrincipal.getUser();
		signInUser.setAccessToken(jwt);
		signInUser.setRefreshToken(jwtRefreshTokenService.createRefreshToken(signInUser.getId()).getTokenId());

		return signInUser;
	}
}
