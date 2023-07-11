package com.chiwawa.lionheart.api.service.auth;

import com.chiwawa.lionheart.api.service.auth.dto.request.LoginRequest;
import com.chiwawa.lionheart.api.service.auth.dto.request.SignUpRequest;

public interface AuthService {

	Long signUp(SignUpRequest request);

	Long login(LoginRequest request);
}
