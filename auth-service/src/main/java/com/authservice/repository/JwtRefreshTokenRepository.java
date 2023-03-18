package com.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.entity.JwtRefreshToken;

public interface JwtRefreshTokenRepository extends JpaRepository<JwtRefreshToken, String>{

}
