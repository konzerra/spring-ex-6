package org.konzerra.springex6.domain.auth;

import org.konzerra.springex6.domain.auth.dto.AuthRequest;
import org.konzerra.springex6.domain.auth.dto.AuthResponse;
import org.konzerra.springex6.domain.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse authenticate(AuthRequest request);
}
