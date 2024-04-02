package org.konzerra.springex6.domain.auth.impl;

import lombok.RequiredArgsConstructor;
import org.konzerra.springex6.domain.auth.AuthService;
import org.konzerra.springex6.domain.auth.dto.AuthRequest;
import org.konzerra.springex6.domain.auth.dto.AuthResponse;
import org.konzerra.springex6.domain.auth.dto.RegisterRequest;
import org.konzerra.springex6.domain.user.Role;
import org.konzerra.springex6.domain.user.User;
import org.konzerra.springex6.domain.user.UserRepository;
import org.konzerra.springex6.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.User)
                .build();
        userRepository.save(user);
        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword()
                )
        );

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var token = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }
}
