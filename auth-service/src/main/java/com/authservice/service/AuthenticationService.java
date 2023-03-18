package com.authservice.service;

import com.authservice.entity.User;

public interface AuthenticationService {
	User signInAndReturnJWT(User signInRequest);
}
