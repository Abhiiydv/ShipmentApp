package com.authservice.service;

import com.authservice.entity.JwtRefreshToken;
import com.authservice.entity.User;

public interface JwtRefreshTokenService {

	   JwtRefreshToken createRefreshToken(Long userId);

	    User generateAccessTokenFromRefreshToken(String refreshTokenId);
	    
}
